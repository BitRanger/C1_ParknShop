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
package com.bitranger.parknshop.seller.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bitranger.parknshop.common.dao.FetchOption;
import com.bitranger.parknshop.common.dao.SortOption;
import com.bitranger.parknshop.seller.dao.IPsShopDAO;
import com.bitranger.parknshop.seller.model.PsOrder;
import com.bitranger.parknshop.seller.model.PsShop;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsShop entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bitranger.parknshop.seller.model.PsShop
 * @author MyEclipse Persistence Tools
 */
public class PsShopDAO extends HibernateDaoSupport implements IPsShopDAO {
	private static final Logger log = LoggerFactory.getLogger(PsShopDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String STATUS = "status";
	public static final String INTRODUCTION = "introduction";
	public static final String VOTE = "vote";

	protected void initDao() {
		// do nothing
	}

	public void save(PsShop transientInstance) {
		log.debug("saving PsShop instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PsShop persistentInstance) {
		log.debug("deleting PsShop instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}


	@Override
	public void update(PsShop detachedInstance) {
		log.debug("updating PsShop instance");
		try {
			getHibernateTemplate().update(detachedInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	@Override
	public PsShop findByShopId(Integer id) {
		log.debug("getting PsShop instance with id: " + id);
		try {
			PsShop instance = (PsShop) getHibernateTemplate().get(
					"com.bitranger.parknshop.seller.model.PsShop", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsShop> findBySellerId(final Integer id) {

		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsShop>>() {
						@Override
						public List<PsShop> doInHibernate(Session session)
								throws HibernateException, SQLException {
							SQLQuery query = session
									.createSQLQuery("select * from ps_shop as P where P.id_seller = ?");

							query.setInteger(0, id);

							return query.addEntity(PsShop.class).list();
						}
					});
		} catch (RuntimeException re) {
			log.error("find by seller id failed", re);
			throw re;
		}
	}

	@Override
	public List<PsShop> searchByKeyword(String name) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsShop> findAllSortByVote(final FetchOption op) {
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsShop>>() {
						@Override
						public List<PsShop> doInHibernate(Session session)
								throws HibernateException, SQLException {
							SQLQuery query = session
									.createSQLQuery("select * from ps_shop order by vote "+
											(op.sortOption == SortOption.ASCENDING ? "asc"
													: "desc"));

							return query.addEntity(PsShop.class).list();
						}
					});
		} catch (RuntimeException re) {
			log.error("find all seller failed", re);
			throw re;
		}
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<PsShop> findAll() {
		try {
			String queryString = "com.bitranger.parknshop.seller.model.PsShop";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all by state failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsShop> findAllSortByName(final FetchOption op) {
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsShop>>() {
						@Override
						public List<PsShop> doInHibernate(Session session)
								throws HibernateException, SQLException {
							SQLQuery query = session
									.createSQLQuery("select * from ps_shop order by name "+
											(op.sortOption == SortOption.ASCENDING ? "asc"
													: "desc"));

							return query.addEntity(PsShop.class).list();
						}
					});
		} catch (RuntimeException re) {
			log.error("find all seller failed", re);
			throw re;
		}
	}
}
