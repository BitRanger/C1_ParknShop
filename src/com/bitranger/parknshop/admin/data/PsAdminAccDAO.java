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
 * PsAdminAcc entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see PsAdminAcc
 * @author MyEclipse Persistence Tools
 */
public class PsAdminAccDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PsAdminAccDAO.class);
	// property constants
	public static final String AMOUNT = "amount";

	protected void initDao() {
		// do nothing
	}

	public void save(PsAdminAcc transientInstance) {
		log.debug("saving PsAdminAcc instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PsAdminAcc persistentInstance) {
		log.debug("deleting PsAdminAcc instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void update(PsAdminAcc persistentInstance) {
		log.debug("deleting PsAdminAcc instance");
		try {
			getHibernateTemplate().update(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PsAdminAcc findById(java.lang.Integer id) {
		log.debug("getting PsAdminAcc instance with id: " + id);
		try {
			PsAdminAcc instance = (PsAdminAcc) getHibernateTemplate().get(
					"com.bitranger.parknshop.admin.data.PsAdminAcc", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PsAdminAcc> findByExample(PsAdminAcc instance) {
		log.debug("finding PsAdminAcc instance by example");
		try {
			List<PsAdminAcc> results = (List<PsAdminAcc>) getHibernateTemplate()
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
		log.debug("finding PsAdminAcc instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PsAdminAcc as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PsAdminAcc> findByAmount(Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	public List findAll() {
		log.debug("finding all PsAdminAcc instances");
		try {
			String queryString = "from PsAdminAcc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PsAdminAcc merge(PsAdminAcc detachedInstance) {
		log.debug("merging PsAdminAcc instance");
		try {
			PsAdminAcc result = (PsAdminAcc) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PsAdminAcc instance) {
		log.debug("attaching dirty PsAdminAcc instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PsAdminAcc instance) {
		log.debug("attaching clean PsAdminAcc instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PsAdminAccDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PsAdminAccDAO) ctx.getBean("PsAdminAccDAO");
	}
}
