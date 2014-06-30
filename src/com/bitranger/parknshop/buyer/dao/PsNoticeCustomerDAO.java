/*******************************************************************************
 * Copyright (c) 2014 BitRangers (Team C1).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      BitRangers (Team C1) - initial API and implementation
 ******************************************************************************/
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

import com.bitranger.parknshop.buyer.model.PsNoticeCustomer;
import com.bitranger.parknshop.seller.model.PsNoticeSeller;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsNoticeCustomer entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see temp.PsNoticeCustomer
 * @author MyEclipse Persistence Tools
 */
public class PsNoticeCustomerDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PsNoticeCustomerDAO.class);
	// property constants
	public static final String SOURCE = "source";
	public static final String MESSAGE = "message";
	public static final String IS_VALID = "isValid";

	@Override
	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.bitranger.parknshop.buyer.model.IPsNoticeSellerDAO#save(com.bitranger.parknshop.buyer.model.PsNoticeCustomer)
	 */
	
	public void save(PsNoticeCustomer transientInstance) {
		log.debug("saving PsNoticeCustomer instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.bitranger.parknshop.buyer.model.IPsNoticeSellerDAO#delete(com.bitranger.parknshop.buyer.model.PsNoticeCustomer)
	 */
	
	public void delete(PsNoticeCustomer persistentInstance) {
		log.debug("deleting PsNoticeCustomer instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.bitranger.parknshop.buyer.model.IPsNoticeSellerDAO#findById(java.lang.Integer)
	 */
	
	public PsNoticeCustomer findById(java.lang.Integer id) {
		log.debug("getting PsNoticeCustomer instance with id: " + id);
		try {
			PsNoticeCustomer instance = (PsNoticeCustomer) getHibernateTemplate()
					.get("com.bitranger.parknshop.buyer.model.PsNoticeCustomer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PsNoticeCustomer> findByExample(PsNoticeCustomer instance) {
		log.debug("finding PsNoticeCustomer instance by example");
		try {
			List<PsNoticeCustomer> results = (List<PsNoticeCustomer>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.bitranger.parknshop.buyer.model.IPsNoticeSellerDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List<PsNoticeCustomer> findByProperty(String propertyName, Object value) {
		log.debug("finding PsNoticeCustomer instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from PsNoticeCustomer as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.bitranger.parknshop.buyer.model.IPsNoticeSellerDAO#findBySource(java.lang.Object)
	 */
	
	public List<PsNoticeCustomer> findBySource(Object source) {
		return findByProperty(SOURCE, source);
	}

	/* (non-Javadoc)
	 * @see com.bitranger.parknshop.buyer.model.IPsNoticeSellerDAO#findByMessage(java.lang.Object)
	 */
	
	public List<PsNoticeCustomer> findByMessage(Object message) {
		return findByProperty(MESSAGE, message);
	}

	/* (non-Javadoc)
	 * @see com.bitranger.parknshop.buyer.model.IPsNoticeSellerDAO#findByIsValid(java.lang.Object)
	 */
	
	public List<PsNoticeCustomer> findByIsValid(Object isValid) {
		return findByProperty(IS_VALID, isValid);
	}

	/* (non-Javadoc)
	 * @see com.bitranger.parknshop.buyer.model.IPsNoticeSellerDAO#findAll()
	 */
	
	public List findAll() {
		log.debug("finding all PsNoticeCustomer instances");
		try {
			String queryString = "from PsNoticeCustomer";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.bitranger.parknshop.buyer.model.IPsNoticeSellerDAO#merge(com.bitranger.parknshop.buyer.model.PsNoticeCustomer)
	 */
	
	public PsNoticeCustomer merge(PsNoticeCustomer detachedInstance) {
		log.debug("merging PsNoticeCustomer instance");
		try {
			PsNoticeCustomer result = getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PsNoticeCustomer instance) {
		log.debug("attaching dirty PsNoticeCustomer instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PsNoticeCustomer instance) {
		log.debug("attaching clean PsNoticeCustomer instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	
	public List<PsNoticeCustomer> getLatest(final int customerID, final int n) {
		
		return getHibernateTemplate().executeFind(new HibernateCallback<List<PsNoticeCustomer>>() {

			
			@Override
			public List<PsNoticeCustomer> doInHibernate(Session arg0)
					throws HibernateException, SQLException {
				
				SQLQuery q = arg0.createSQLQuery(
				" select ps_notice_customer as NC "
				+ " where NC.is_valid = 1 and id_customer = ? "
				+ " order by time_created desc limit ?"
				);
				q.setInteger(0, customerID);
				q.setInteger(1, n);
				q.addEntity(PsNoticeCustomer.class);
				return q.list();
			}
			
		});
	}
}





