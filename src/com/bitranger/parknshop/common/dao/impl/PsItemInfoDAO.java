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

import com.bitranger.parknshop.common.dao.IPsItemInfoDAO;
import com.bitranger.parknshop.common.model.PsItemInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsItemInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bitranger.parknshop.common.model.PsItemInfo
 * @author MyEclipse Persistence Tools
 */
public class PsItemInfoDAO extends HibernateDaoSupport implements IPsItemInfoDAO{
	private static final Logger log = LoggerFactory
			.getLogger(PsItemInfoDAO.class);
	
	@Override
	public  void update(PsItemInfo detachedInstance)
	{
		log.debug("updating PsItem instance");
		try {
			getHibernateTemplate().update(detachedInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	
	@Override
	public  void save(PsItemInfo transientInstance)
	{
		log.debug("saving PsItemInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	@Override
	public  void delete(PsItemInfo persistentInstance)
	{
		log.debug("deleting PsItemInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	@Override
	@SuppressWarnings({ "unchecked" })
	public  List<PsItemInfo> findByItemId(final java.lang.Integer id)
	{
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsItemInfo>>() {

						@Override
						public List<PsItemInfo> doInHibernate(Session session)
								throws HibernateException, SQLException {
							SQLQuery query = session
									.createSQLQuery("select * from ps_item_info where id_item = ? ");

							query.setInteger(0, id);
							query.addEntity(PsItemInfo.class);

							return query.list();
						}
					});
		} catch (RuntimeException re) {
			log.error("find by findByItemId failed", re);
			throw re;
		}
	}
	@SuppressWarnings({ "unchecked", "unused" })
	private List<PsItemInfo> findAll() {
		log.debug("finding all PsOrder instances");
		try {
			String queryString = "from PsOrder";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}
