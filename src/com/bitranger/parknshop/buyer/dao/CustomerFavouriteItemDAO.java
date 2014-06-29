package com.bitranger.parknshop.buyer.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bitranger.parknshop.buyer.model.CartCustomerItem;
import com.bitranger.parknshop.buyer.model.CustomerFavouriteItem;
import com.bitranger.parknshop.buyer.model.CustomerFavouriteItemId;
<<<<<<< HEAD
import com.bitranger.parknshop.common.dao.FetchOption;
import com.bitranger.parknshop.common.dao.SortOption;
=======
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79

/**
 * A data access object (DAO) providing persistence and search support for
 * CustomerFavouriteItem entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see temp.CustomerFavouriteItem
 * @author MyEclipse Persistence Tools
 */
public class CustomerFavouriteItemDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CustomerFavouriteItemDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(CustomerFavouriteItem transientInstance) {
		log.debug("saving CustomerFavouriteItem instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CustomerFavouriteItem persistentInstance) {
		log.debug("deleting CustomerFavouriteItem instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CustomerFavouriteItem findById(CustomerFavouriteItemId id) {
		log.debug("getting CustomerFavouriteItem instance with id: " + id);
		try {
			CustomerFavouriteItem instance = (CustomerFavouriteItem) getHibernateTemplate()
					.get("com.bitranger.parknshop.buyer.model.CustomerFavouriteItem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<CustomerFavouriteItem> findByExample(
			CustomerFavouriteItem instance) {
		log.debug("finding CustomerFavouriteItem instance by example");
		try {
			List<CustomerFavouriteItem> results = (List<CustomerFavouriteItem>) getHibernateTemplate()
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
		log.debug("finding CustomerFavouriteItem instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CustomerFavouriteItem as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomerFavouriteItem> findByCustomerId(final Integer psCustomerId,
			final FetchOption option) {
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<CustomerFavouriteItem>>() {

						@Override
						public List<CustomerFavouriteItem> doInHibernate(
								Session session) throws HibernateException,
								SQLException {

							SQLQuery query = session
									.createSQLQuery("select * from customer_favourite_item as C where C.id_customer = ?"
											+ " order by C.time_created "
											+ (option.sortOption == SortOption.ASCENDING ? "asc"
													: "desc")
											+ " limit ? offset ?");
							query.setInteger(0, psCustomerId);
							query.setInteger(1, option.limit);
							query.setInteger(2, option.offset);
							query.addEntity(CustomerFavouriteItem.class);
							return query.list();
						}
					});
		} catch (RuntimeException e) {
			log.error("get failed", e);
			throw e;
		}
	}

	public List findAll() {
		log.debug("finding all CustomerFavouriteItem instances");
		try {
			String queryString = "from CustomerFavouriteItem";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CustomerFavouriteItem merge(CustomerFavouriteItem detachedInstance) {
		log.debug("merging CustomerFavouriteItem instance");
		try {
			CustomerFavouriteItem result = (CustomerFavouriteItem) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CustomerFavouriteItem instance) {
		log.debug("attaching dirty CustomerFavouriteItem instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CustomerFavouriteItem instance) {
		log.debug("attaching clean CustomerFavouriteItem instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CustomerFavouriteItemDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CustomerFavouriteItemDAO) ctx
				.getBean("CustomerFavouriteItemDAO");
	}
}