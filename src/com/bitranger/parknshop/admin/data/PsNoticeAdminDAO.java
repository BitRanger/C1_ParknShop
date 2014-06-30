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
 * PsNoticeAdmin entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see temp.PsNoticeAdmin
 * @author MyEclipse Persistence Tools
 */
public class PsNoticeAdminDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PsNoticeAdminDAO.class);
	// property constants
	public static final String MESSAGE = "message";
	public static final String SOURCE = "source";
	public static final String IS_VALID = "isValid";

	protected void initDao() {
		// do nothing
	}

	public void save(PsNoticeAdmin transientInstance) {
		log.debug("saving PsNoticeAdmin instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PsNoticeAdmin persistentInstance) {
		log.debug("deleting PsNoticeAdmin instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PsNoticeAdmin findById(java.lang.Integer id) {
		log.debug("getting PsNoticeAdmin instance with id: " + id);
		try {
			PsNoticeAdmin instance = (PsNoticeAdmin) getHibernateTemplate()
					.get("com.bitranger.parknshop.admin.data.PsNoticeAdmin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);

//			PsNoticeAdmin instance = (PsNoticeAdmin) getHibernateTemplate()
//					.get(" PsNoticeAdmin ", id);
//			return instance;
			throw re;
		}
	}

	public List<PsNoticeAdmin> findByExample(PsNoticeAdmin instance) {
		log.debug("finding PsNoticeAdmin instance by example");
		try {
			List<PsNoticeAdmin> results = (List<PsNoticeAdmin>) getHibernateTemplate()
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
		log.debug("finding PsNoticeAdmin instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from PsNoticeAdmin as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PsNoticeAdmin> findByMessage(Object message) {
		return findByProperty(MESSAGE, message);
	}

	public List<PsNoticeAdmin> findBySource(Object source) {
		return findByProperty(SOURCE, source);
	}

	public List<PsNoticeAdmin> findByIsValid(Object isValid) {
		return findByProperty(IS_VALID, isValid);
	}

	public List<PsNoticeAdmin> findAll() {
		log.debug("finding all PsNoticeAdmin instances");
		try {
			String queryString = "from PsNoticeAdmin";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PsNoticeAdmin merge(PsNoticeAdmin detachedInstance) {
		log.debug("merging PsNoticeAdmin instance");
		try {
			PsNoticeAdmin result = (PsNoticeAdmin) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PsNoticeAdmin instance) {
		log.debug("attaching dirty PsNoticeAdmin instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PsNoticeAdmin instance) {
		log.debug("attaching clean PsNoticeAdmin instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PsNoticeAdminDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (PsNoticeAdminDAO) ctx.getBean("PsNoticeAdminDAO");
	}
}
