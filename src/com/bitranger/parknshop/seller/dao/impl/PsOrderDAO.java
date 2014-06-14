package com.bitranger.parknshop.seller.dao.impl;

import java.sql.SQLException;
import java.util.Date;
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

import com.bitranger.parknshop.seller.OrderState;
import com.bitranger.parknshop.seller.dao.IPsOrderDAO;
import com.bitranger.parknshop.seller.model.PsOrder;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsOrder entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bitranger.parknshop.seller.model.PsOrder
 * @author MyEclipse Persistence Tools
 */
public class PsOrderDAO extends HibernateDaoSupport implements IPsOrderDAO {
	private static final Logger log = LoggerFactory.getLogger(PsOrderDAO.class);

	@Override
	public void update(PsOrder detachedInstance) {
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
	public PsOrder findByOrderId(Integer id) {
		log.debug("getting PsOrder instance with id: " + id);
		try {
			PsOrder instance = (PsOrder) getHibernateTemplate().get(
					"com.bitranger.PsOrder", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PsOrder> findByCustomerId(final Integer id, final Date from, final Date to) {
		log.debug("findByCustomerId: " + id);
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsOrder>>() {

						@Override
						public List<PsOrder> doInHibernate(Session arg0)
								throws HibernateException, SQLException {
							SQLQuery query = arg0
									.createSQLQuery("select * from ps_order as P where P.id_customer = ? and P.time_created > ? and P.time_created < ?");
							query.setInteger(0, id)
									.setDate(1, from)
									.setDate(2, to);
							query.addEntity(PsOrder.class);
							return query.list();

						}

					});
		} catch (RuntimeException re) {
			log.error("find by customerId failed", re);
			throw re;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PsOrder> findByCustomerId(final Integer id, final OrderState state) {
		log.debug("findByCustomerId: " + id);
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsOrder>>() {

						@Override
						public List<PsOrder> doInHibernate(Session arg0)
								throws HibernateException, SQLException {
							SQLQuery query = arg0
									.createSQLQuery("select * from ps_order as P where P.id_customer = ? and P.status = ?");
							query.setInteger(0, id)
								.setString(1, state.toString());
							query.addEntity(PsOrder.class);
							return query.list();

						}

					});
		} catch (RuntimeException re) {
			log.error("find by customerId failed", re);
			throw re;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PsOrder> findByShopId(final Integer id,final Date from,final Date to) {
		log.debug("find by shop_id: " + id);
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsOrder>>() {

						@Override
						public List<PsOrder> doInHibernate(Session arg0)
								throws HibernateException, SQLException {
							SQLQuery query = arg0
									.createSQLQuery("select * from ps_order as P where P.id_shop = ? and P.time_created > ? and P.time_created < ?");
							query.setInteger(0, id)
									.setDate(1, from)
									.setDate(2, to);
							query.addEntity(PsOrder.class);
							return query.list();

						}

					});
		} catch (RuntimeException re) {
			log.error("find by shop id failed", re);
			throw re;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PsOrder> findByShopId(final Integer id,final OrderState state) {
		log.debug("findByCustomerId: " + id);
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsOrder>>() {

						@Override
						public List<PsOrder> doInHibernate(Session arg0)
								throws HibernateException, SQLException {
							SQLQuery query = arg0
									.createSQLQuery("select * from ps_order as P where P.id_shop = ? and P.status = ?");
							query.setInteger(0, id)
								.setString(1, state.toString());
							query.addEntity(PsOrder.class);
							return query.list();

						}

					});
		} catch (RuntimeException re) {
			log.error("find by shop id  failed", re);
			throw re;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PsOrder> findAll(OrderState state) {
		log.debug("finding all PsOrder instances by state");
		try {
			String queryString = "from PsOrder p where p.status=?";
			String para = state.toString();
			return getHibernateTemplate().find(queryString, para);
		} catch (RuntimeException re) {
			log.error("find all by state failed", re);
			throw re;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PsOrder> findAll(Date from, Date to) {
		log.debug("finding all PsOrder instances by time_created");
		try {
			String queryString = "from PsOrder p where p.time_created>? and p.time_created<?";
			Object[] params = new Object[]{from, to};
			return getHibernateTemplate().find(queryString, params);
		} catch (RuntimeException re) {
			log.error("find all by state failed", re);
			throw re;
		}
	}

//=============================================================================
	// property constants
	public static final String ID_CUSTOMER = "idCustomer";
	public static final String ID_SHOP = "idShop";
	public static final String STATUS = "status";
	public static final String TRACKING_NUMBER = "trackingNumber";
	public static final String PRICE_TOTAL = "priceTotal";

	protected void initDao() {
		// do nothing
	}

	public void save(PsOrder transientInstance) {
		log.debug("saving PsOrder instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PsOrder persistentInstance) {
		log.debug("deleting PsOrder instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PsOrder findById(java.lang.Integer id) {
		log.debug("getting PsOrder instance with id: " + id);
		try {
			PsOrder instance = (PsOrder) getHibernateTemplate().get(
					"temp.PsOrder", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PsOrder> findByExample(PsOrder instance) {
		log.debug("finding PsOrder instance by example");
		try {
			List<PsOrder> results = (List<PsOrder>) getHibernateTemplate()
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
		log.debug("finding PsOrder instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PsOrder as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PsOrder> findByIdCustomer(Object idCustomer) {
		return findByProperty(ID_CUSTOMER, idCustomer);
	}

	public List<PsOrder> findByIdShop(Object idShop) {
		return findByProperty(ID_SHOP, idShop);
	}

	public List<PsOrder> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List<PsOrder> findByTrackingNumber(Object trackingNumber) {
		return findByProperty(TRACKING_NUMBER, trackingNumber);
	}

	public List<PsOrder> findByPriceTotal(Object priceTotal) {
		return findByProperty(PRICE_TOTAL, priceTotal);
	}

	public List findAll() {
		log.debug("finding all PsOrder instances");
		try {
			String queryString = "from PsOrder";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PsOrder merge(PsOrder detachedInstance) {
		log.debug("merging PsOrder instance");
		try {
			PsOrder result = (PsOrder) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PsOrder instance) {
		log.debug("attaching dirty PsOrder instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PsOrder instance) {
		log.debug("attaching clean PsOrder instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PsOrderDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PsOrderDAO) ctx.getBean("PsOrderDAO");
	}
	
}