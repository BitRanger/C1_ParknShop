package com.bitranger.parknshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bitranger.parknshop.dao.IROrderItemDAO;
import com.bitranger.parknshop.model.ROrderItem;

/**
 * A data access object (DAO) providing persistence and search support for
 * ROrderItem entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bitranger.ROrderItem
 * @author MyEclipse Persistence Tools
 */
public class ROrderItemDAO extends HibernateDaoSupport implements
		IROrderItemDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ROrderItemDAO.class);
	// property constants
	public static final String QUANTITIY = "quantitiy";
	public static final String EXTRA1 = "extra1";
	public static final String EXTRA2 = "extra2";

	protected void initDao() {
		// do nothing
	}

	public void save(ROrderItem transientInstance) {
		log.debug("saving ROrderItem instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ROrderItem persistentInstance) {
		log.debug("deleting ROrderItem instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ROrderItem findById(com.bitranger.parknshop.model.ROrderItemId id) {
		log.debug("getting ROrderItem instance with id: " + id);
		try {
			ROrderItem instance = (ROrderItem) getHibernateTemplate().get(
					"com.bitranger.ROrderItem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public void update(ROrderItem detachedInstance) {
		log.debug("updating ROrderItem instance");
		try {
			getHibernateTemplate().update(detachedInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ROrderItem> findByOrderId(final Integer id) {
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<ROrderItem>>() {
						@Override
						public List<ROrderItem> doInHibernate(Session session)
								throws HibernateException, SQLException {
							SQLQuery query = session
									.createSQLQuery("select * from r_order_item as R where R.id_order = ?");

							query.setInteger(0, id);

							return query.addEntity(ROrderItem.class).list();
						}
					});
		} catch (RuntimeException re) {
			log.error("find by order id failed", re);
			throw re;
		}
	}
}