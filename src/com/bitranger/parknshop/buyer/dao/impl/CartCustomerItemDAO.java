package com.bitranger.parknshop.buyer.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bitranger.parknshop.buyer.dao.ICartCustomerItemDAO;
import com.bitranger.parknshop.buyer.model.CartCustomerItem;
import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.dao.FetchOption;
import com.bitranger.parknshop.common.dao.SortOption;

/**
 * A data access object (DAO) providing persistence and search support for
 * CartCustomerItem entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bitranger.parknshop.buyer.model.CartCustomerItem
 * @author MyEclipse Persistence Tools
 */
public class CartCustomerItemDAO extends HibernateDaoSupport implements
		ICartCustomerItemDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CartCustomerItemDAO.class);
	// property constants
	public static final String QUANTITY = "quantity";
	public static final String EXTRA1 = "extra1";
	public static final String EXTRA2 = "extra2";

	@Override
	public void save(CartCustomerItem transientInstance) {
		log.debug("saving CartCustomerItem instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	@Override
	public void delete(CartCustomerItem persistentInstance) {
		log.debug("deleting CartCustomerItem instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public CartCustomerItem findById(
			com.bitranger.parknshop.buyer.model.CartCustomerItemId id) {
		log.debug("getting CartCustomerItem instance with id: " + id);
		try {
			CartCustomerItem instance = (CartCustomerItem) getHibernateTemplate()
					.get("com.bitranger.parknshop.buyer.model.CartCustomerItem",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CartCustomerItem> findByCustomerId(final Integer psCustomerId,
			final FetchOption option) {

		log.debug("getting CartCustomerItem instance with psCustomerId: "
				+ psCustomerId);
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<CartCustomerItem>>() {

						@Override
						public List<CartCustomerItem> doInHibernate(
								Session session) throws HibernateException,
								SQLException {

							SQLQuery query = session
									.createSQLQuery("select * from cart_customer_item as C where C.id_customer = ?"
											+ " order by C.time_created "
											+ (option.sortOption == SortOption.ASCENDING ? "asc"
													: "desc")
											+ " limit ? offset ?");
							query.setInteger(0, psCustomerId);
							query.setInteger(1, option.limit);
							query.setInteger(2, option.offset);
							query.addEntity(CartCustomerItem.class);
							return query.list();
						}
					});
		} catch (RuntimeException e) {
			log.error("get failed", e);
			throw e;
		}
	}

	@Override
	public void update(CartCustomerItem detachedInstance) {
		getHibernateTemplate().update(detachedInstance);
	}




	@Override
	public void deleteAll(List<CartCustomerItem> items) {
		getHibernateTemplate().deleteAll(items);
	}

}