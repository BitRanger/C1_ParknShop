package com.bitranger.parknshop.buyer.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bitranger.parknshop.buyer.model.CustomerFavouriteShop;
import com.bitranger.parknshop.buyer.model.CustomerFavouriteShopId;

/**
 * A data access object (DAO) providing persistence and search support for
 * CustomerFavouriteShop entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see temp.CustomerFavouriteShop
 * @author MyEclipse Persistence Tools
 */
public class CustomerFavouriteShopDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CustomerFavouriteShopDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(CustomerFavouriteShop transientInstance) {
		log.debug("saving CustomerFavouriteShop instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CustomerFavouriteShop persistentInstance) {
		log.debug("deleting CustomerFavouriteShop instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CustomerFavouriteShop findById(CustomerFavouriteShopId id) {
		log.debug("getting CustomerFavouriteShop instance with id: " + id);
		try {
			CustomerFavouriteShop instance = (CustomerFavouriteShop) getHibernateTemplate()
					.get("com.bitranger.parknshop.buyer.model.CustomerFavouriteShop", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<CustomerFavouriteShop> findByExample(
			CustomerFavouriteShop instance) {
		log.debug("finding CustomerFavouriteShop instance by example");
		try {
			List<CustomerFavouriteShop> results = (List<CustomerFavouriteShop>) getHibernateTemplate()
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
		log.debug("finding CustomerFavouriteShop instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CustomerFavouriteShop as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all CustomerFavouriteShop instances");
		try {
			String queryString = "from CustomerFavouriteShop";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CustomerFavouriteShop merge(CustomerFavouriteShop detachedInstance) {
		log.debug("merging CustomerFavouriteShop instance");
		try {
			CustomerFavouriteShop result = (CustomerFavouriteShop) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CustomerFavouriteShop instance) {
		log.debug("attaching dirty CustomerFavouriteShop instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CustomerFavouriteShop instance) {
		log.debug("attaching clean CustomerFavouriteShop instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CustomerFavouriteShopDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CustomerFavouriteShopDAO) ctx
				.getBean("CustomerFavouriteShopDAO");
	}
}