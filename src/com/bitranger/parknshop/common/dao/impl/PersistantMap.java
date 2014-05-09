package com.bitranger.parknshop.common.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bitranger.parknshop.common.dao.IPersistantMap;
import com.bitranger.parknshop.util.Assert;
import com.bitranger.parknshop.util.ObjUtils;

/**
 *@author BowenCai
 *@since 9:24:53 PM
 */
public class PersistantMap extends HibernateDaoSupport implements IPersistantMap {

	@Override
	public boolean containsKey(String key) {
		return false;
	}

	@Override
	public Object get(final String key) {
		Assert.notBlank(key);
		
		byte[] b = getHibernateTemplate().execute(new HibernateCallback<byte[]>() {

			@Override
			public byte[] doInHibernate(Session arg0) throws HibernateException,
					SQLException {
				SQLQuery query = arg0.createSQLQuery(
					"select val from ps_key_values where key = ?");
				query.setString(0, key);
				query.addScalar("val", Hibernate.BLOB);
				return (byte[]) query.uniqueResult();
			}
		});
		return ObjUtils.fromBytes(b);
	}

	@Override
	public void put(final String key, Object value) {
		Assert.isTrue(value instanceof Serializable, 
				"value must be Serializable");
		final byte[] b = ObjUtils.toBytes(value);
		
		getHibernateTemplate().execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session arg0) throws HibernateException,
					SQLException {
				SQLQuery query = arg0.createSQLQuery(
				"insert into ps_key_value(key, val)values(?,?)");
				query.setString(0, key);
				query.setBinary(1, b);
				query.executeUpdate();
				return null;
			}
		});
	}

	@Override
	public Object remove(String key) {
		return null;
	}


	@Override
	public Set<String> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

}
