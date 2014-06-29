package com.bitranger.parknshop.admin.data;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsAdministrator entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see PsAdministrator
 * @author MyEclipse Persistence Tools
 */
public class PsAdministratorDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PsAdministratorDAO.class);
	// property constants
	public static final String EMAIL = "email";
	public static final String NAME = "name";
	public static final String PASSWORD = "password";

	protected void initDao() {
		// do nothing
	}

	public void save(PsAdministrator transientInstance) {
		log.debug("saving PsAdministrator instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PsAdministrator persistentInstance) {
		log.debug("deleting PsAdministrator instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void update(PsAdministrator persistentInstance) {
		log.debug("updating PsAdministrator instance");
		try {
			getHibernateTemplate().update(persistentInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public PsAdministrator findById(java.lang.Integer id) {
		log.debug("getting PsAdministrator instance with id: " + id);
		try {
			PsAdministrator instance = (PsAdministrator) getHibernateTemplate()
					.get("com.bitranger.parknshop.admin.data.PsAdministrator", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PsAdministrator> findByExample(PsAdministrator instance) {
		log.debug("finding PsAdministrator instance by example");
		try {
			List<PsAdministrator> results = (List<PsAdministrator>) getHibernateTemplate()
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
		log.debug("finding PsAdministrator instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from PsAdministrator as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PsAdministrator> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<PsAdministrator> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<PsAdministrator> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<PsAdministrator> findAll() {
		log.debug("finding all PsAdministrator instances");
		try {
			String queryString = "from PsAdministrator";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PsAdministrator merge(PsAdministrator detachedInstance) {
		log.debug("merging PsAdministrator instance");
		try {
			PsAdministrator result = (PsAdministrator) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PsAdministrator instance) {
		log.debug("attaching dirty PsAdministrator instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PsAdministrator instance) {
		log.debug("attaching clean PsAdministrator instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PsAdministratorDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (PsAdministratorDAO) ctx.getBean("PsAdministratorDAO");
	}
}