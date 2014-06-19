package com.bitranger.parknshop.seller.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bitranger.parknshop.seller.model.PsSellerAcc;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsSellerAcc entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see PsSellerAcc
 * @author MyEclipse Persistence Tools
 */
public class PsSellerAccDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PsSellerAccDAO.class);
	// property constants
	public static final String BALANCE = "balance";

	protected void initDao() {
		// do nothing
	}

	public void save(PsSellerAcc transientInstance) {
		log.debug("saving PsSellerAcc instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void update(PsSellerAcc transientInstance) {
		log.debug("updating PsSellerAcc instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public void delete(PsSellerAcc persistentInstance) {
		log.debug("deleting PsSellerAcc instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PsSellerAcc findById(java.lang.Integer id) {
		log.debug("getting PsSellerAcc instance with id: " + id);
		try {
			PsSellerAcc instance = (PsSellerAcc) getHibernateTemplate().get(
					"com.bitranger.parknshop.seller.model.PsSellerAcc", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PsSellerAcc> findByExample(PsSellerAcc instance) {
		log.debug("finding PsSellerAcc instance by example");
		try {
			List<PsSellerAcc> results = (List<PsSellerAcc>) getHibernateTemplate()
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
		log.debug("finding PsSellerAcc instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PsSellerAcc as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PsSellerAcc> findByBalance(Object balance) {
		return findByProperty(BALANCE, balance);
	}

	public List findAll() {
		log.debug("finding all PsSellerAcc instances");
		try {
			String queryString = "from PsSellerAcc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PsSellerAcc merge(PsSellerAcc detachedInstance) {
		log.debug("merging PsSellerAcc instance");
		try {
			PsSellerAcc result = (PsSellerAcc) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PsSellerAcc instance) {
		log.debug("attaching dirty PsSellerAcc instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PsSellerAcc instance) {
		log.debug("attaching clean PsSellerAcc instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PsSellerAccDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (PsSellerAccDAO) ctx.getBean("PsSellerAccDAO");
	}
}