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
package com.bitranger.parknshop.seller.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bitranger.parknshop.seller.model.PsShopApply;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsShopApply entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bitranger.parknshop.seller.model.PsShopApply
 * @author MyEclipse Persistence Tools
 */
public class PsShopApplyDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PsShopApplyDAO.class);
	// property constants
	public static final String ID_SELLER = "idSeller";
	public static final String MESSAGE = "message";
	public static final String APPROVED = "approved";
	public static final String IS_VALID = "isValid";

	protected void initDao() {
		// do nothing
	}

	public void save(PsShopApply transientInstance) {
		log.debug("saving PsShopApply instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PsShopApply persistentInstance) {
		log.debug("deleting PsShopApply instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PsShopApply findById(java.lang.Integer id) {
		log.debug("getting PsShopApply instance with id: " + id);
		try {
			PsShopApply instance = (PsShopApply) getHibernateTemplate().get(
					"com.bitranger.parknshop.seller.model.PsShopApply", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PsShopApply> findByExample(PsShopApply instance) {
		log.debug("finding PsShopApply instance by example");
		try {
			List<PsShopApply> results = (List<PsShopApply>) getHibernateTemplate()
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
		log.debug("finding PsShopApply instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PsShopApply as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PsShopApply> findByIdSeller(Object idSeller) {
		return findByProperty(ID_SELLER, idSeller);
	}

	public List<PsShopApply> findByMessage(Object message) {
		return findByProperty(MESSAGE, message);
	}

	public List<PsShopApply> findByApproved(Object approved) {
		return findByProperty(APPROVED, approved);
	}

	public List<PsShopApply> findByIsValid(Object isValid) {
		return findByProperty(IS_VALID, isValid);
	}

	public List findAll() {
		log.debug("finding all PsShopApply instances");
		try {
			String queryString = "from PsShopApply";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PsShopApply merge(PsShopApply detachedInstance) {
		log.debug("merging PsShopApply instance");
		try {
			PsShopApply result = (PsShopApply) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PsShopApply instance) {
		log.debug("attaching dirty PsShopApply instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PsShopApply instance) {
		log.debug("attaching clean PsShopApply instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PsShopApplyDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (PsShopApplyDAO) ctx.getBean("PsShopApplyDAO");
	}
}
