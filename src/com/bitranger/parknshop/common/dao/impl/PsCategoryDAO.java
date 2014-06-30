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
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bitranger.parknshop.common.dao.FetchOption;
import com.bitranger.parknshop.common.dao.IPsCategoryDAO;
import com.bitranger.parknshop.common.dao.SortOption;
import com.bitranger.parknshop.common.model.PsCategory;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsCategory entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bitranger.parknshop.common.model.PsCategory
 * @author MyEclipse Persistence Tools
 */
public class PsCategoryDAO extends HibernateDaoSupport implements IPsCategoryDAO{
	
	private static final Logger log = LoggerFactory
			.getLogger(PsCategoryDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String EXTRAL1 = "extral1";
	public static final String EXTRAL2 = "extral2";

	@Override
	protected void initDao() {
		// do nothing
	}

	@Override
	public void save(PsCategory transientInstance) {
		log.debug("saving PsCategory instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(PsCategory persistentInstance) {
		log.debug("deleting PsCategory instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PsCategory findById(java.lang.Integer id) {
		log.debug("getting PsCategory instance with id: " + id);
		try {
			PsCategory instance = (PsCategory) getHibernateTemplate().get(
					"com.bitranger.parknshop.common.model.PsCategory", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PsCategory> findByExample(PsCategory instance) {
		log.debug("finding PsCategory instance by example");
		try {
			List<PsCategory> results = (List<PsCategory>) getHibernateTemplate()
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
		log.debug("finding PsCategory instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PsCategory as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PsCategory> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<PsCategory> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List<PsCategory> findByExtral1(Object extral1) {
		return findByProperty(EXTRAL1, extral1);
	}

	public List<PsCategory> findByExtral2(Object extral2) {
		return findByProperty(EXTRAL2, extral2);
	}

	@Override
	public List<PsCategory> findAll() {
		log.debug("finding all PsCategory instances");
		try {
			String queryString = "from PsCategory";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PsCategory merge(PsCategory detachedInstance) {
		log.debug("merging PsCategory instance");
		try {
			PsCategory result = (PsCategory) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PsCategory instance) {
		log.debug("attaching dirty PsCategory instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PsCategory instance) {
		log.debug("attaching clean PsCategory instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PsCategoryDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PsCategoryDAO) ctx.getBean("PsCategoryDAO");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsCategory> findAll(final FetchOption option) {
		log.debug("finding all PsCategory instances");
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsCategory>>() {
						@Override
						public List<PsCategory> doInHibernate(Session session)
								throws HibernateException, SQLException {
							String hql = "FROM PsCategory ORDER BY id "
									+ (option.sortOption == SortOption.ASCENDING 
										? " ASC " : " DESC ");

							return session.createQuery(hql)
									.setFirstResult(option.offset)
									.setMaxResults(option.limit)
									.list();
						}
					});
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	
	}
	@Override
	public void update(PsCategory detachedInstance) {
		getHibernateTemplate().update(detachedInstance);
	}
//	private static final Logger log = LoggerFactory
//			.getLogger(PsCategoryDAO.class);
//	// property constants
//	public static final String NAME = "name";
//
//
//	@Override
//	public void save(PsCategory transientInstance) {
//		log.debug("saving PsCategory instance");
//		try {
//			getHibernateTemplate().save(transientInstance);
//			log.debug("save successful");
//		} catch (RuntimeException re) {
//			log.error("save failed", re);
//			throw re;
//		}
//	}
//
//	@Override
//	public void delete(PsCategory persistentInstance) {
//		log.debug("deleting PsCategory instance");
//		try {
//			getHibernateTemplate().delete(persistentInstance);
//			log.debug("delete successful");
//		} catch (RuntimeException re) {
//			log.error("delete failed", re);
//			throw re;
//		}
//	}
//
//
//	@Override
//	@SuppressWarnings({ "unchecked" })
//	public List<PsCategory> findAll() {
//		log.debug("finding all PsCategory instances");
//		try {
//			String queryString = "from PsCategory";
//			return getHibernateTemplate().find(queryString);
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		}
//	}
//
//
//	//������ڲ����fetchoption����Щ��������壬����Ҳû�и����Ӧ��get����������û��ʵ��
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<PsCategory> findAll(final FetchOption option) {
//		// TODO Auto-generated method stub
//		log.debug("finding all PsCategory instances");
//		try {
//			return getHibernateTemplate().executeFind(
//					new HibernateCallback<List<PsCategory>>() {
//						@Override
//						public List<PsCategory> doInHibernate(Session session)
//								throws HibernateException, SQLException {
//							String hql = "FROM PsCategory ORDER BY id "
//									+ (option.sortOption == SortOption.ASCENDING 
//										? " ASC " : " DESC ");
//
//							return session.createQuery(hql)
//									.setFirstResult(option.offset)
//									.setMaxResults(option.limit)
//									.list();
//						}
//					});
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		}
//	}
//
//	@Override
//	public void update(PsCategory detachedInstance) {
//		getHibernateTemplate().update(detachedInstance);
//	}
}



