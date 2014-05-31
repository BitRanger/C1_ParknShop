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

import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.dao.FetchOption;
import com.bitranger.parknshop.common.dao.SortOption;
import com.bitranger.parknshop.seller.dao.IPsSellerDAO;
import com.bitranger.parknshop.seller.model.PsSeller;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsSeller entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bitranger.parknshop.seller.model.PsSeller
 * @author MyEclipse Persistence Tools
 */
public class PsSellerDAO extends HibernateDaoSupport implements IPsSellerDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PsSellerDAO.class);
	// property constants
	public static final String NICKNAME = "nickname";
	public static final String PERSON_ID_NUM = "personIdNum";
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";
	public static final String STATUS = "status";

	@Override
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

	@Override
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

	@Override
	public void update(PsSeller detachedInstance) {
		log.debug("updating PsSeller instance");
		try {
			getHibernateTemplate().update(detachedInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	@Override
	public PsSeller findByEmail(String email) {
		log.debug("getting PsSeller instance with email: " + email);
		try {
			PsSeller instance = 
					(PsSeller) getHibernateTemplate()
						.find(
					"FROM com.bitranger.PsSeller WHERE email = ?"
					, email)
					.get(0);
			
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsCustomer> findAll(final FetchOption fetchOption) {
		log.debug("find all PsSeller");
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsSeller>>() {

						@Override
						public List<PsSeller> doInHibernate(Session arg0)
								throws HibernateException, SQLException {
							SQLQuery query = arg0
									.createSQLQuery("select * from ps_seller as P order by P.id  "+
											(fetchOption.sortOption == SortOption.ASCENDING ? "asc"
													: "desc"));
							query.addEntity(PsCustomer.class);
							return query.list();
						}

					});
		} catch (RuntimeException re) {
			log.error("find all PsSeller failed", re);
			throw re;
		}

	}
}