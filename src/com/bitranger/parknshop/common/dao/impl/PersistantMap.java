package com.bitranger.parknshop.common.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
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

//	ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap<>(256);
	
	@Override
	public boolean containsKey(final String key) {
		int i = getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(
				"select count(*) as ct from `ps_key_value` where `key`=?");
				query.addScalar("ct", Hibernate.INTEGER);
				Object ret  = query.setString(0, key).uniqueResult();
				if (ret instanceof Integer) {
					return ((Integer)(ret)).intValue();
				} else {
					return -1;
				}
			}
		});
		return i == 1;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<String> keys() {
		return getHibernateTemplate().executeFind(new HibernateCallback<List<String>>() {

			@Override
			public List<String> doInHibernate(Session session)
					throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(
				"select `key` from `ps_key_value`");
				return query.addScalar("key", Hibernate.STRING).list();
			}
			
		});
	}

	@Override
	public void remove(final String key) {
		getHibernateTemplate().execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session)
					throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery("delete from `ps_key_value` where `key` = ?");
				query.setString(0, key);
				query.executeUpdate();
				return null;
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public<T> T  get(final String key) {
		Assert.notBlank(key);
		
		byte[] b = getHibernateTemplate().execute(new HibernateCallback<byte[]>() {

			@Override
			public byte[] doInHibernate(Session arg0) throws HibernateException,
					SQLException {
				SQLQuery query = arg0.createSQLQuery(
					"select val from `ps_key_value` where `key` = ?");
				query.setString(0, key);
				query.addScalar("val", Hibernate.BINARY);
				return (byte[]) query.uniqueResult();
			}
		});
		return (T) ObjUtils.fromBytes(b);
	}
	
	@Override
	public void put(final String key, final Object value) {
		Assert.isTrue(value instanceof Serializable, 
				"value must be Serializable");
		
		getHibernateTemplate().execute(new HibernateCallback<Void>() {
			@Override
			public Void doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.doWork(new Work() {
					@Override
					public void execute(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(
						"insert into `ps_key_value`(`key`,`val`)values(?,?)");
						ps.setString(1, key);
						ps.setBytes(2, ObjUtils.toBytes(value));
						ps.execute();
						ps.close();
						connection.close();
					}
				});
				return null;
			}
		});
	}
}
