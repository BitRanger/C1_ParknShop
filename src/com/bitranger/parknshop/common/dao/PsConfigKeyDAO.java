package com.bitranger.parknshop.common.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bitranger.parknshop.common.model.PsConfigKey;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsConfigKey entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see temp.PsConfigKey
 * @author MyEclipse Persistence Tools
 */
public class PsConfigKeyDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PsConfigKeyDAO.class);
	// property constants
	public static final String IS_VALID = "isValid";
	public static final String NAME = "name";

	protected void initDao() {
		// do nothing
	}

	public void save(PsConfigKey transientInstance) {
		log.debug("saving PsConfigKey instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PsConfigKey persistentInstance) {
		log.debug("deleting PsConfigKey instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PsConfigKey findById(java.lang.Integer id) {
		log.debug("getting PsConfigKey instance with id: " + id);
		try {
			PsConfigKey instance = (PsConfigKey) getHibernateTemplate().get(
					"temp.PsConfigKey", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PsConfigKey> findByExample(PsConfigKey instance) {
		log.debug("finding PsConfigKey instance by example");
		try {
			List<PsConfigKey> results = (List<PsConfigKey>) getHibernateTemplate()
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
		log.debug("finding PsConfigKey instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PsConfigKey as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PsConfigKey> findByIsValid(Object isValid) {
		return findByProperty(IS_VALID, isValid);
	}

	public List<PsConfigKey> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findAll() {
		log.debug("finding all PsConfigKey instances");
		try {
			String queryString = "from PsConfigKey";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PsConfigKey merge(PsConfigKey detachedInstance) {
		log.debug("merging PsConfigKey instance");
		try {
			PsConfigKey result = (PsConfigKey) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PsConfigKey instance) {
		log.debug("attaching dirty PsConfigKey instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PsConfigKey instance) {
		log.debug("attaching clean PsConfigKey instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PsConfigKeyDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (PsConfigKeyDAO) ctx.getBean("PsConfigKeyDAO");
	}
}