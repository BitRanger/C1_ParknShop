package com.bitranger.parknshop.common.ads;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsAdItem entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see temp.PsAdItem
 * @author MyEclipse Persistence Tools
 */
public class PsAdItemDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PsAdItemDAO.class);
	// property constants
	public static final String WEIGHT = "weight";
	public static final String PRICE = "price";
	public static final String NUM_FETCHED = "numFetched";
	public static final String ID = "id";

	protected void initDao() {
		// do nothing
	}

	public void save(PsAdItem transientInstance) {
		log.debug("saving PsAdItem instance");
		try {
			if (transientInstance.getNumFetched() == null) {
				transientInstance.setNumFetched(0);
			}
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PsAdItem persistentInstance) {
		log.debug("deleting PsAdItem instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PsAdItem findById(java.lang.Integer id) {
		log.debug("getting PsAdItem instance with id: " + id);
		try {
			PsAdItem instance = (PsAdItem) getHibernateTemplate().get(
					"com.bitranger.parknshop.common.ads.PsAdItem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PsAdItem> findByExample(PsAdItem instance) {
		log.debug("finding PsAdItem instance by example");
		try {
			List<PsAdItem> results = (List<PsAdItem>) getHibernateTemplate()
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
		log.debug("finding PsAdItem instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PsAdItem as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PsAdItem> findByWeight(Object weight) {
		return findByProperty(WEIGHT, weight);
	}

	public List<PsAdItem> findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List<PsAdItem> findByNumFetched(Object numFetched) {
		return findByProperty(NUM_FETCHED, numFetched);
	}

	public List<PsAdItem> findById(Object id) {
		return findByProperty(ID, id);
	}

	public List findAll() {
		log.debug("finding all PsAdItem instances");
		try {
			String queryString = "from PsAdItem";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PsAdItem merge(PsAdItem detachedInstance) {
		log.debug("merging PsAdItem instance");
		try {
			PsAdItem result = (PsAdItem) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PsAdItem instance) {
		log.debug("attaching dirty PsAdItem instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PsAdItem instance) {
		log.debug("attaching clean PsAdItem instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PsAdItemDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PsAdItemDAO) ctx.getBean("PsAdItemDAO");
	}

	public HibernateTemplate hibernate() {
		return getHibernateTemplate();
	}
}