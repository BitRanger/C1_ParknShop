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
package com.bitranger.parknshop.common.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bitranger.parknshop.common.model.PsConfigVal;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsConfigVal entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see PsConfigVal
 * @author MyEclipse Persistence Tools
 */
public class PsConfigValDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PsConfigValDAO.class);
	// property constants
	public static final String VAL = "val";

	protected void initDao() {
		// do nothing
	}

	public void save(PsConfigVal transientInstance) {
		log.debug("saving PsConfigVal instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PsConfigVal persistentInstance) {
		log.debug("deleting PsConfigVal instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PsConfigVal findById(java.lang.Integer id) {
		log.debug("getting PsConfigVal instance with id: " + id);
		try {
			PsConfigVal instance = (PsConfigVal) getHibernateTemplate().get(
					"com.bitranger.parknshop.common.model.PsConfigKey", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PsConfigVal> findByExample(PsConfigVal instance) {
		log.debug("finding PsConfigVal instance by example");
		try {
			List<PsConfigVal> results = (List<PsConfigVal>) getHibernateTemplate()
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
		log.debug("finding PsConfigVal instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PsConfigVal as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PsConfigVal> findByVal(Object val) {
		return findByProperty(VAL, val);
	}

	public List findAll() {
		log.debug("finding all PsConfigVal instances");
		try {
			String queryString = "from PsConfigVal";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PsConfigVal merge(PsConfigVal detachedInstance) {
		log.debug("merging PsConfigVal instance");
		try {
			PsConfigVal result = (PsConfigVal) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PsConfigVal instance) {
		log.debug("attaching dirty PsConfigVal instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PsConfigVal instance) {
		log.debug("attaching clean PsConfigVal instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PsConfigValDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (PsConfigValDAO) ctx.getBean("PsConfigValDAO");
	}
}
