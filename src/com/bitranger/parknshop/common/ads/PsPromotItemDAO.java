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
package com.bitranger.parknshop.common.ads;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsPromotItem entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see temp.PsPromotItem
 * @author MyEclipse Persistence Tools
 */
public class PsPromotItemDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PsPromotItemDAO.class);
	// property constants
	public static final String ITEM_INFO = "itemInfo";
	public static final String DESCRIPTION = "description";
	public static final String PIC_URL = "picUrl";

	protected void initDao() {
		// do nothing
	}

	@SuppressWarnings("unchecked")
	public List<PsPromotItem> findBySeller(final int id) {
		return getHibernateTemplate().executeFind(new HibernateCallback<List<PsPromotItem>>() {

			@Override
			public List<PsPromotItem> doInHibernate(Session session)
					throws HibernateException, SQLException {
				SQLQuery q = session.createSQLQuery(
" select IP.* from ps_promot_item as IP " +
" inner join ps_item as IT on IT.id = IP.id_item " +
" inner join ps_shop as SP on SP.id = IT.id_shop " +
" where SP.id_seller = ? ");
				q.setInteger(0, id);
				q.addEntity(PsPromotItem.class);
				return q.list();
			}
		});
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
					"com.bitranger.parknshop.common.ads.PsPromotItem", id);
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

	public List<PsPromotItem> findByPicUrl(Object picUrl) {
		return findByProperty(PIC_URL, picUrl);
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
	
/**
 select PI.* from ps_promot_item as PI 
	inner join ps_ad_item as AD on AD.id_promot = PI.id
where AD.time_start < CURRENT_TIMESTAMP and CURRENT_TIMESTAMP < AD.time_end

 */
	@SuppressWarnings("unchecked")
	public List<PsPromotItem> findAllValid() {
		log.debug("finding all PsPromotItem instances");
		try {
			return getHibernateTemplate().executeFind(new HibernateCallback<List<PsPromotItem>>() {

				@Override
				public List<PsPromotItem> doInHibernate(Session session)
						throws HibernateException, SQLException {
					SQLQuery q = session.createSQLQuery(
			"		select PI.* from ps_promot_item as PI " +
				"	inner join ps_ad_item as AD on AD.id_promot = PI.id " +
			"	where AD.time_start < CURRENT_TIMESTAMP and CURRENT_TIMESTAMP < AD.time_end ");
					q.addEntity(PsPromotItem.class);
					return q.list();
				}
			});
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
public double calAdRevenue() {
		
		return getHibernateTemplate().execute(new HibernateCallback<Double>() {

			@Override
			public Double doInHibernate(Session session)
					throws HibernateException, SQLException {
				SQLQuery q = session.createSQLQuery(
" select sum(AD.num_fetched * AD.weight) as ACC from ps_promot_item as PI  " +
"	inner join ps_ad_item as AD on AD.id_promot = PI.id " +
" where AD.time_start < CURRENT_TIMESTAMP  " +
"		and CURRENT_TIMESTAMP < AD.time_end ");
				q.addScalar("ACC", Hibernate.DOUBLE);
				Double db = (Double) q.uniqueResult();
				return db == null? 0.0 : db;
			}
		});
	}
	
}
