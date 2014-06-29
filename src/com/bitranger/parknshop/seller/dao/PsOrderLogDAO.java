package com.bitranger.parknshop.seller.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bitranger.parknshop.seller.model.PsOrderLog;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsOrderLog entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see temp.PsOrderLog
 * @author MyEclipse Persistence Tools
 */
public class PsOrderLogDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PsOrderLogDAO.class);
	// property constants
	public static final String ID_RECIP_ADDR = "idRecipAddr";
	public static final String STR_ADDR = "strAddr";
	public static final String ID_CUSTOMER = "idCustomer";
	public static final String ID_SHOP = "idShop";
	public static final String STATUS = "status";
	public static final String TRACKING_NUMBER = "trackingNumber";
	public static final String PRICE_TOTAL = "priceTotal";
	public static final String NAME_BUYER = "nameBuyer";
	public static final String NAME_SHOP = "nameShop";

	protected void initDao() {
		// do nothing
	}

	public void save(PsOrderLog transientInstance) {
		log.debug("saving PsOrderLog instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PsOrderLog persistentInstance) {
		log.debug("deleting PsOrderLog instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PsOrderLog findById(java.lang.Integer id) {
		log.debug("getting PsOrderLog instance with id: " + id);
		try {
			PsOrderLog instance = (PsOrderLog) getHibernateTemplate().get(
					"temp.PsOrderLog", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PsOrderLog> findByExample(PsOrderLog instance) {
		log.debug("finding PsOrderLog instance by example");
		try {
			List<PsOrderLog> results = (List<PsOrderLog>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding PsOrderLog instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PsOrderLog as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PsOrderLog> findByIdRecipAddr(Object idRecipAddr) {
		return findByProperty(ID_RECIP_ADDR, idRecipAddr);
	}

	public List<PsOrderLog> findByStrAddr(Object strAddr) {
		return findByProperty(STR_ADDR, strAddr);
	}

	public List<PsOrderLog> findByIdCustomer(Object idCustomer) {
		return findByProperty(ID_CUSTOMER, idCustomer);
	}

	public List<PsOrderLog> findByIdShop(Object idShop) {
		return findByProperty(ID_SHOP, idShop);
	}

	public List<PsOrderLog> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List<PsOrderLog> findByTrackingNumber(Object trackingNumber) {
		return findByProperty(TRACKING_NUMBER, trackingNumber);
	}

	public List<PsOrderLog> findByPriceTotal(Object priceTotal) {
		return findByProperty(PRICE_TOTAL, priceTotal);
	}

	public List<PsOrderLog> findByNameBuyer(Object nameBuyer) {
		return findByProperty(NAME_BUYER, nameBuyer);
	}

	public List<PsOrderLog> findByNameShop(Object nameShop) {
		return findByProperty(NAME_SHOP, nameShop);
	}

	public List<PsOrderLog> findAll() {
		log.debug("finding all PsOrderLog instances");
		try {
			String queryString = "from PsOrderLog";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PsOrderLog merge(PsOrderLog detachedInstance) {
		log.debug("merging PsOrderLog instance");
		try {
			PsOrderLog result = (PsOrderLog) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PsOrderLog instance) {
		log.debug("attaching dirty PsOrderLog instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PsOrderLog instance) {
		log.debug("attaching clean PsOrderLog instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PsOrderLogDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PsOrderLogDAO) ctx.getBean("PsOrderLogDAO");
	}

//	@SuppressWarnings("unchecked")
//	public List<PsOrderLog> findBySellerId(int id) {
//		return getHibernateTemplate().executeFind(new HibernateCallback<List<PsOrderLog>>() {
//			@Override
//			public List<PsOrderLog> doInHibernate(Session session)
//					throws HibernateException, SQLException {
//				SQLQuery q = session.createSQLQuery("");
//				q.addEntity(PsOrderLog.class);
//				q.setInteger(0, id);
//				return q.list();
//			}
//		});
//	}
}