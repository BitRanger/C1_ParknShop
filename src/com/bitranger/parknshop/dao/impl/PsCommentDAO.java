package com.bitranger.parknshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bitranger.parknshop.dao.FetchOption;
import com.bitranger.parknshop.dao.IPsCommentDAO;
import com.bitranger.parknshop.dao.SortOption;
import com.bitranger.parknshop.model.PsComment;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsComment entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bitranger.PsComment
 * @author MyEclipse Persistence Tools
 */
public class PsCommentDAO extends HibernateDaoSupport implements IPsCommentDAO{
	
	private static final Logger log = LoggerFactory
			.getLogger(PsCommentDAO.class);
	// property constants
	public static final String SCORE = "score";
	public static final String CONTENT = "content";

	@Override
	public void save(PsComment transientInstance) {
		log.debug("saving PsComment instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(PsComment persistentInstance) {
		log.debug("deleting PsComment instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public PsComment findById(java.lang.Integer id) {
		log.debug("getting PsComment instance with id: " + id);
		try {
			PsComment instance = (PsComment) getHibernateTemplate().get(
					"com.bitranger.PsComment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<PsComment> findByExample(PsComment instance) {
		log.debug("finding PsComment instance by example");
		try {
			@SuppressWarnings("cast")
			List<PsComment> results = (List<PsComment>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<PsComment> findByProperty(String propertyName, Object value) {
		log.debug("finding PsComment instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PsComment as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@Override
	public List<PsComment> findByScore(Object score) {
		return findByProperty(SCORE, score);
	}

	@Override
	public List<PsComment> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PsComment> findAll() {
		log.debug("finding all PsComment instances");
		try {
			String queryString = "from PsComment";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<PsComment> findByCustomerId(final Integer customerId, final FetchOption option) {
		log.debug("findByCustomerId: " + customerId);
		try {
			return getHibernateTemplate().executeFind(new HibernateCallback<List<PsComment>>() {

				@Override
				public List<PsComment> doInHibernate(Session arg0)
						throws HibernateException, SQLException {
					SQLQuery query = arg0.createSQLQuery(
					"select * from ps_comment where id_customer = ? " +
					"order by time_created " + (option.sortOption == SortOption.ASCENDING 
												? "asc" : "desc")
					+ " offset ? limit ?");
					query.setInteger(0, customerId);
					query.setInteger(1, option.offset);
					query.setInteger(2, option.limit);
					query.addEntity(PsComment.class);
					return query.list();
				}
			});
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsComment> findByItemId(final Integer itemId, final FetchOption option) {
		
		log.debug("findByItemId: " + itemId);
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsComment>>() {
						@Override
						public List<PsComment> doInHibernate(Session session)
								throws HibernateException, SQLException {
							SQLQuery query = session.createSQLQuery(
							"select * from ps_comment where id_item = ? "
							+ " order by time_created " + (option.sortOption == SortOption.ASCENDING 
														? "asc" : "desc")
							+ " offset ? limit ?");

							query.setInteger(0, itemId);
							query.setInteger(1, option.offset);
							query.setInteger(2, option.limit);
							query.addEntity(PsComment.class);
							return query.list();
						}
					});

		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}