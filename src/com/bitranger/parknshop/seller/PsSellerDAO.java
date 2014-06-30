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
package com.bitranger.parknshop.seller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bitranger.parknshop.seller.model.PsSeller;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsSeller entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see temp.PsSeller
 * @author MyEclipse Persistence Tools
 */
public class PsSellerDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PsSellerDAO.class);
	// property constants
	public static final String NICKNAME = "nickname";
	public static final String PERSON_ID_NUM = "personIdNum";
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";
	public static final String STATUS = "status";
	public static final String BALANCE = "balance";

	protected void initDao() {
		// do nothing
	}

	public void save(PsSeller transientInstance) {
		log.debug("saving PsSeller instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PsSeller persistentInstance) {
		log.debug("deleting PsSeller instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PsSeller findById(java.lang.Integer id) {
		log.debug("getting PsSeller instance with id: " + id);
		try {
			PsSeller instance = (PsSeller) getHibernateTemplate().get(
					"temp.PsSeller", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PsSeller> findByExample(PsSeller instance) {
		log.debug("finding PsSeller instance by example");
		try {
			List<PsSeller> results = (List<PsSeller>) getHibernateTemplate()
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
		log.debug("finding PsSeller instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PsSeller as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PsSeller> findByNickname(Object nickname) {
		return findByProperty(NICKNAME, nickname);
	}

	public List<PsSeller> findByPersonIdNum(Object personIdNum) {
		return findByProperty(PERSON_ID_NUM, personIdNum);
	}

	public List<PsSeller> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<PsSeller> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<PsSeller> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List<PsSeller> findByBalance(Object balance) {
		return findByProperty(BALANCE, balance);
	}

	public List findAll() {
		log.debug("finding all PsSeller instances");
		try {
			String queryString = "from PsSeller";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PsSeller merge(PsSeller detachedInstance) {
		log.debug("merging PsSeller instance");
		try {
			PsSeller result = (PsSeller) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PsSeller instance) {
		log.debug("attaching dirty PsSeller instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PsSeller instance) {
		log.debug("attaching clean PsSeller instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PsSellerDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PsSellerDAO) ctx.getBean("PsSellerDAO");
	}
}
