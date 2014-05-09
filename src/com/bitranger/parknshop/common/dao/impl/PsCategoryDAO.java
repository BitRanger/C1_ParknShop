package com.bitranger.parknshop.common.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


	@Override
	@SuppressWarnings({ "unchecked" })
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


	//������ڲ����fetchoption����Щ��������壬����Ҳû�и����Ӧ��get����������û��ʵ��
	@SuppressWarnings("unchecked")
	@Override
	public List<PsCategory> findAll(final FetchOption option) {
		// TODO Auto-generated method stub
		log.debug("finding all PsCategory instances");
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsCategory>>() {
						@Override
						public List<PsCategory> doInHibernate(Session session)
								throws HibernateException, SQLException {
							String hql = "FROM PsCategory ORDER BY id "
									+ (option.sortOption == SortOption.ASCENDING 
										? "ASC" : "DESC");

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
}



