package com.bitranger.parknshop.buyer.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bitranger.parknshop.buyer.dao.IPsCustomerDAO;
import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.dao.FetchOption;
import com.bitranger.parknshop.common.dao.SortOption;
import com.bitranger.parknshop.common.model.PsCategory;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsCustomer entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bitranger.parknshop.buyer.model.PsCustomer
 * @author MyEclipse Persistence Tools
 */
public class PsCustomerDAO extends HibernateDaoSupport implements IPsCustomerDAO{
	private static final Logger log = LoggerFactory
			.getLogger(PsCustomerDAO.class);
	// property constants
	public static final String NICKNAME = "nickname";
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";
	public static final String GENDER = "gender";
	public static final String NAME = "name";


	@Override
	public void save(PsCustomer transientInstance) {
		log.debug("saving PsCustomer instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(PsCustomer persistentInstance) {
		log.debug("deleting PsCustomer instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PsCustomer findById(java.lang.Integer id) {
		log.debug("getting PsCustomer instance with id: " + id);
		try {
			PsCustomer instance = (PsCustomer) getHibernateTemplate().get(
					"com.bitranger.PsCustomer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<PsCustomer> findAll() {
		log.debug("finding all PsCustomer instances");
		try {
			String queryString = "from PsCustomer";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}


	@Override
	public void update(PsCustomer detachedInstance) {
		getHibernateTemplate().update(detachedInstance);
	}

	@Override
	public PsCustomer findByEmail(String email) {
		log.debug("finding PsCustomer instance with email: " + email);
		try {
			String queryString = "from PsComment as model where model."
					+ email + "= ?";
			return (PsCustomer) getHibernateTemplate().find(queryString, email).get(0);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsCustomer> findAll(final FetchOption option) {
		log.debug("finding all PsCustomer instances");
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsCategory>>() {
						@Override
						public List<PsCategory> doInHibernate(Session session)
								throws HibernateException, SQLException {
							String hql = "FROM PsCustomer ORDER BY id "
									+ (option.sortOption == SortOption.ASCENDING 
										? "ASC" : "DESC");

							return session.createQuery(hql)
									.setFirstResult(option.offset)
									.setMaxResults(option.limit).list();
						}
					});
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}