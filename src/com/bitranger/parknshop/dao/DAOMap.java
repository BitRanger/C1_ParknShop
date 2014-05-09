package com.bitranger.parknshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bitranger.parknshop.model.Entry;



//CREATE TABLE BW_Web.BW_Map
//(
//	id 			SMALLINT 		UNSIGNED NOT NULL AUTO_INCREMENT,
//	ref 		VARCHAR(64) 	NOT NULL,
//	obj			BLOB 			NOT NULL,
//
//	PRIMARY KEY(id)
//)
/**
 * @author BowenCai
 *
 */
public class DAOMap extends HibernateDaoSupport  {

	protected DAOMap() {
	}

	public Entry getEntry(int id) {
		getHibernateTemplate().execute(new HibernateCallback<Void>() {
			@Override
			public Void doInHibernate(Session session)
					throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(
				"");
				query.uniqueResult();
				return null;
			}
		});
		return null;
	}

	public int put(Entry entry) {
		return 0;

	}

	public final<E> int put(final String key, final E var) {
		return 0;
	}

	@SuppressWarnings("unchecked")
	public final <E> E get(final String key) {
		return null;

	}

	public final<E> E get(final int id) {
		return null;

	}

	public Entry getEntry(final String key) {
		return null;

	}

	public Entry getEntry1(int id) {

	}

	public boolean contains(int id) {
		return false;
	}

	public boolean contains(final String ref) {
		return false;

	}

	public Set<String> keySet() {
		return null;

	}

	/**
	 * do not change this code unless you have read and understood spring src
	 * 
	 * we could use ConnectionCallBack, or could we?
	 * 
	 * spring has wrapped around connections and PreparedStatement
	 * if we user ConnectionCallBack, this lines of code are lost:
	 * 		ps = psc.createPreparedStatement(conToUse);
	 * 		applyStatementSettings(ps);
	 * 
	 * so we must pass let spring generate PreparedStatement and do the processing 
	 * before using PreparedStatementCallback
	 * 
	 */
	public void putAll(final Map<String, Object> map) {


	}

//	getJdbcTemplate().execute(new ConnectionCallback<Object>() {
//
//		@Override
//		public Object doInConnection(Connection con) throws SQLException,
//				DataAccessException {
//			
//			PreparedStatement ps = con.prepareStatement(
//				"insert into bw_map(ref,obj)values(?,?)");
//			
//			for (Map.Entry<String, Object> entry : map.entrySet()) {
//				ps.setString(1, entry.getKey());
//				ps.setBytes(2, ObjUtil.objToBytes(entry.getValue()));
//				
//				ps.addBatch();
//			}
//			ps.executeBatch();
//			return null;
//		}
//	});
}
