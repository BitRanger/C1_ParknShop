package com.bitranger.parknshop.seller.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bitranger.parknshop.seller.dao.IPsNoticeSellerDAO;
import com.bitranger.parknshop.seller.model.PsNoticeSeller;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsNoticeSeller entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see temp.PsNoticeSeller
 * @author MyEclipse Persistence Tools
 */
public class PsNoticeSellerDAO extends HibernateDaoSupport implements IPsNoticeSellerDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PsNoticeSellerDAO.class);
	// property constants
	public static final String SOURCE = "source";
	public static final String MESSAGE = "message";
	public static final String IS_VALID = "isValid";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.bitranger.parknshop.seller.model.IPsNoticeSellerDAO#save(com.bitranger.parknshop.seller.model.PsNoticeSeller)
	 */
	@Override
	public void save(PsNoticeSeller transientInstance) {
		log.debug("saving PsNoticeSeller instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.bitranger.parknshop.seller.model.IPsNoticeSellerDAO#delete(com.bitranger.parknshop.seller.model.PsNoticeSeller)
	 */
	@Override
	public void delete(PsNoticeSeller persistentInstance) {
		log.debug("deleting PsNoticeSeller instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.bitranger.parknshop.seller.model.IPsNoticeSellerDAO#findById(java.lang.Integer)
	 */
	@Override
	public PsNoticeSeller findById(java.lang.Integer id) {
		log.debug("getting PsNoticeSeller instance with id: " + id);
		try {
			PsNoticeSeller instance = (PsNoticeSeller) getHibernateTemplate()
					.get("temp.PsNoticeSeller", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PsNoticeSeller> findByExample(PsNoticeSeller instance) {
		log.debug("finding PsNoticeSeller instance by example");
		try {
			List<PsNoticeSeller> results = (List<PsNoticeSeller>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.bitranger.parknshop.seller.model.IPsNoticeSellerDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List<PsNoticeSeller> findByProperty(String propertyName, Object value) {
		log.debug("finding PsNoticeSeller instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from PsNoticeSeller as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.bitranger.parknshop.seller.model.IPsNoticeSellerDAO#findBySource(java.lang.Object)
	 */
	@Override
	public List<PsNoticeSeller> findBySource(Object source) {
		return findByProperty(SOURCE, source);
	}

	/* (non-Javadoc)
	 * @see com.bitranger.parknshop.seller.model.IPsNoticeSellerDAO#findByMessage(java.lang.Object)
	 */
	@Override
	public List<PsNoticeSeller> findByMessage(Object message) {
		return findByProperty(MESSAGE, message);
	}

	/* (non-Javadoc)
	 * @see com.bitranger.parknshop.seller.model.IPsNoticeSellerDAO#findByIsValid(java.lang.Object)
	 */
	@Override
	public List<PsNoticeSeller> findByIsValid(Object isValid) {
		return findByProperty(IS_VALID, isValid);
	}

	/* (non-Javadoc)
	 * @see com.bitranger.parknshop.seller.model.IPsNoticeSellerDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all PsNoticeSeller instances");
		try {
			String queryString = "from PsNoticeSeller";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PsNoticeSeller merge(PsNoticeSeller detachedInstance) {
		log.debug("merging PsNoticeSeller instance");
		try {
			PsNoticeSeller result = getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PsNoticeSeller instance) {
		log.debug("attaching dirty PsNoticeSeller instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PsNoticeSeller instance) {
		log.debug("attaching clean PsNoticeSeller instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IPsNoticeSellerDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IPsNoticeSellerDAO) ctx.getBean("PsNoticeSellerDAO");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsNoticeSeller> getLatest(final int sellerID, final int n) {
		
		return getHibernateTemplate().executeFind(new HibernateCallback<List<PsNoticeSeller>>() {

			@Override
			public List<PsNoticeSeller> doInHibernate(Session arg0)
					throws HibernateException, SQLException {
				
				SQLQuery q = arg0.createSQLQuery(
				" select ps_notice_seller as NS "
				+ " where NS.is_valid = 1 and id_seller = ? "
				+ " order by time_created desc limit ?"
				);
				q.setInteger(0, sellerID);
				q.setInteger(1, n);
				q.addEntity(PsNoticeSeller.class);
				return q.list();
			}
			
		});
	}
}

