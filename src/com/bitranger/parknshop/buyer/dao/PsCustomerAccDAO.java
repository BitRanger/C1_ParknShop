package com.bitranger.parknshop.buyer.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bitranger.parknshop.buyer.model.PsCustomerAcc;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsCustomerAcc entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see temp.PsCustomerAcc
 * @author MyEclipse Persistence Tools
 */
public class PsCustomerAccDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PsCustomerAccDAO.class);
	// property constants
	public static final String BALANCE = "balance";

	protected void initDao() {
		// do nothing
	}

	public void save(PsCustomerAcc transientInstance) {
		log.debug("saving PsCustomerAcc instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PsCustomerAcc persistentInstance) {
		log.debug("deleting PsCustomerAcc instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PsCustomerAcc findById(java.lang.Integer id) {
		log.debug("getting PsCustomerAcc instance with id: " + id);
		try {
			PsCustomerAcc instance = (PsCustomerAcc) getHibernateTemplate()
					.get("com.bitranger.parknshop.buyer.model.PsCustomerAcc", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PsCustomerAcc> findByExample(PsCustomerAcc instance) {
		log.debug("finding PsCustomerAcc instance by example");
		try {
			List<PsCustomerAcc> results = (List<PsCustomerAcc>) getHibernateTemplate()
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
		log.debug("finding PsCustomerAcc instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from PsCustomerAcc as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PsCustomerAcc> findByBalance(Object balance) {
		return findByProperty(BALANCE, balance);
	}

	public List findAll() {
		log.debug("finding all PsCustomerAcc instances");
		try {
			String queryString = "from PsCustomerAcc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PsCustomerAcc merge(PsCustomerAcc detachedInstance) {
		log.debug("merging PsCustomerAcc instance");
		try {
			PsCustomerAcc result = (PsCustomerAcc) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PsCustomerAcc instance) {
		log.debug("attaching dirty PsCustomerAcc instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PsCustomerAcc instance) {
		log.debug("attaching clean PsCustomerAcc instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PsCustomerAccDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (PsCustomerAccDAO) ctx.getBean("PsCustomerAccDAO");
	}
}