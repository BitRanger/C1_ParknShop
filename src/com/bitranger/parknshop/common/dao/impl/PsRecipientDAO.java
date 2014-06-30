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
package com.bitranger.parknshop.common.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bitranger.parknshop.seller.dao.IPsRecipientDAO;
import com.bitranger.parknshop.seller.model.PsRecipient;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsRecipient entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bitranger.parknshop.seller.model.PsRecipient
 * @author MyEclipse Persistence Tools
 */
public class PsRecipientDAO extends HibernateDaoSupport implements
		IPsRecipientDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PsRecipientDAO.class);
	// property constants
	public static final String NAME_RECIPIENT = "nameRecipient";
	public static final String ADDRESSS = "addresss";
	public static final String POSTAL_CODE = "postalCode";
	public static final String PHONE_NUMBER = "phoneNumber";


	@Override
	public void save(PsRecipient transientInstance) {
		log.debug("saving PsRecipient instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(PsRecipient persistentInstance) {
		log.debug("deleting PsRecipient instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public void update(PsRecipient detachedInstance) {
		log.debug("updating PsRecipient instance");
		try {
			getHibernateTemplate().update(detachedInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public PsRecipient findByRecipientId(Integer id) {
		log.debug("getting PsRecipient instance with id: " + id);
		try {
			PsRecipient instance = (PsRecipient) getHibernateTemplate().get(
					"com.bitranger.PsRecipient", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsRecipient> findByCustomId(final Integer id) {
		log.debug("findByCustomerId: " + id);
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsRecipient>>() {

						@Override
						public List<PsRecipient> doInHibernate(Session arg0)
								throws HibernateException, SQLException {
							SQLQuery query = arg0
									.createSQLQuery("select * from ps_recipient as P where P.id_customer = ?");
							query.setInteger(0, id);
							query.addEntity(PsRecipient.class);
							return query.list();

						}

					});
		} catch (RuntimeException re) {
			log.error("find by customerId failed", re);
			throw re;
		}
	}


	@Override
	public PsRecipient findById(java.lang.Integer id) {
		log.debug("getting PsRecipient instance with id: " + id);
		try {
			PsRecipient instance = (PsRecipient) getHibernateTemplate().get(
					"com.bitranger.parknshop.seller.model.PsRecipient", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
