package com.bitranger.parknshop.common.ads;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsItemPromotInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bitranger.parknshop.common.ads.PsItemPromotInfo
 * @author MyEclipse Persistence Tools
 */
public class PsItemPromotInfoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PsItemPromotInfoDAO.class);
	// property constants
	public static final String KEY = "key";
	public static final String VALUE = "value";

	protected void initDao() {
		// do nothing
	}
	
	public HibernateTemplate hibernate() {
		return getHibernateTemplate();
	}

	
	public void save(PsItemPromotInfo transientInstance) {
		log.debug("saving PsItemPromotInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PsItemPromotInfo persistentInstance) {
		log.debug("deleting PsItemPromotInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PsItemPromotInfo findById(java.lang.Integer id) {
		log.debug("getting PsItemPromotInfo instance with id: " + id);
		try {
			PsItemPromotInfo instance = (PsItemPromotInfo) getHibernateTemplate()
					.get("temp.PsItemPromotInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PsItemPromotInfo> findByExample(PsItemPromotInfo instance) {
		log.debug("finding PsItemPromotInfo instance by example");
		try {
			List<PsItemPromotInfo> results = (List<PsItemPromotInfo>) getHibernateTemplate()
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
		log.debug("finding PsItemPromotInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from PsItemPromotInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PsItemPromotInfo> findByKey(Object key) {
		return findByProperty(KEY, key);
	}

	public List<PsItemPromotInfo> findByValue(Object value) {
		return findByProperty(VALUE, value);
	}

	public List findAll() {
		log.debug("finding all PsItemPromotInfo instances");
		try {
			String queryString = "from PsItemPromotInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PsItemPromotInfo merge(PsItemPromotInfo detachedInstance) {
		log.debug("merging PsItemPromotInfo instance");
		try {
			PsItemPromotInfo result = (PsItemPromotInfo) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PsItemPromotInfo instance) {
		log.debug("attaching dirty PsItemPromotInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PsItemPromotInfo instance) {
		log.debug("attaching clean PsItemPromotInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PsItemPromotInfoDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (PsItemPromotInfoDAO) ctx.getBean("PsItemPromotInfoDAO");
	}
}