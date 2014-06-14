package com.bitranger.parknshop.common.ads;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsPromotItem entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bitranger.parknshop.common.ads.PsPromotItem
 * @author MyEclipse Persistence Tools
 */
public class PsPromotItemDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PsPromotItemDAO.class);
	// property constants
	public static final String ITEM_INFO = "itemInfo";
	public static final String DESCRIPTION = "description";

	protected void initDao() {
		// do nothing
	}
	public HibernateTemplate hibernate() {
		return getHibernateTemplate();
	}
	
	public void save(PsPromotItem transientInstance) {
		log.debug("saving PsPromotItem instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PsPromotItem persistentInstance) {
		log.debug("deleting PsPromotItem instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PsPromotItem findById(java.lang.Integer id) {
		log.debug("getting PsPromotItem instance with id: " + id);
		try {
			PsPromotItem instance = (PsPromotItem) getHibernateTemplate().get(
					"temp.PsPromotItem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PsPromotItem> findByExample(PsPromotItem instance) {
		log.debug("finding PsPromotItem instance by example");
		try {
			List<PsPromotItem> results = (List<PsPromotItem>) getHibernateTemplate()
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
		log.debug("finding PsPromotItem instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from PsPromotItem as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PsPromotItem> findByItemInfo(Object itemInfo) {
		return findByProperty(ITEM_INFO, itemInfo);
	}

	public List<PsPromotItem> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findAll() {
		log.debug("finding all PsPromotItem instances");
		try {
			String queryString = "from PsPromotItem";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PsPromotItem merge(PsPromotItem detachedInstance) {
		log.debug("merging PsPromotItem instance");
		try {
			PsPromotItem result = (PsPromotItem) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PsPromotItem instance) {
		log.debug("attaching dirty PsPromotItem instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PsPromotItem instance) {
		log.debug("attaching clean PsPromotItem instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PsPromotItemDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (PsPromotItemDAO) ctx.getBean("PsPromotItemDAO");
	}
}