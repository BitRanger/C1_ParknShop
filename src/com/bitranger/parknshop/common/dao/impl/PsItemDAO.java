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

import com.bitranger.parknshop.common.dao.FetchOption;
import com.bitranger.parknshop.common.dao.IPsItemDAO;
import com.bitranger.parknshop.common.dao.SortOption;
import com.bitranger.parknshop.common.model.PsItem;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsItem entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bitranger.parknshop.common.model.PsItem
 * @author MyEclipse Persistence Tools
 */
public class PsItemDAO extends HibernateDaoSupport implements IPsItemDAO {
	private static final Logger log = LoggerFactory.getLogger(PsItemDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String INTRODUCTION = "introduction";
	public static final String PRICE = "price";
	public static final String URL_PICTURE = "urlPicture";
	public static final String EXTRA1 = "extra1";
	public static final String EXTRA2 = "extra2";
	public static final String COUNT_PURCHASE = "countPurchase";
	public static final String COUNT_FAVOURITE = "countFavourite";
	public static final String COUNT_CLICK = "countClick";
	public static final String VOTE = "vote";

	@Override
	public void save(PsItem transientInstance) {
		log.debug("saving PsItem instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(PsItem persistentInstance) {
		log.debug("deleting PsItem instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public PsItem findById(java.lang.Integer id) {
		log.debug("getting PsItem instance with id: " + id);
		try {
			PsItem instance = (PsItem) getHibernateTemplate().get(
					"com.bitranger.parknshop.common.model.PsItem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PsItem> findByExample(PsItem instance) {
		log.debug("finding PsItem instance by example");
		try {
			@SuppressWarnings({ "unchecked", "cast" })
			List<PsItem> results = (List<PsItem>) getHibernateTemplate()
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
	public List<PsItem> findByProperty(String propertyName, Object value) {
		log.debug("finding PsItem instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PsItem as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<PsItem> findAll() {
		log.debug("finding all PsItem instances");
		try {
			String queryString = "from PsItem";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public void update(PsItem detachedInstance) {
		getHibernateTemplate().update(detachedInstance);
	}

	@Override
	public List<PsItem> searchByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsItem> findByPriceInCategory(final Integer psCategoryId,
			final Double priceMin, final Double priceMax,
			final FetchOption option) {
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsItem>>() {
						@Override
						public List<PsItem> doInHibernate(Session session)
								throws HibernateException, SQLException {
							SQLQuery query = session
									.createSQLQuery("select * from ps_item as P where P.id_category = ? "
											+ " and P.price > ? and P.price < ? "
											+ "order by price "
											+ (option.sortOption == SortOption.ASCENDING ? "asc"
													: "desc")
											+ " offset ? limit ?");

							query.setInteger(0, psCategoryId)
									.setDouble(1, priceMin)
									.setDouble(2, priceMax)
									.setInteger(3, option.offset)
									.setInteger(4, option.limit);

							return query.addEntity(PsItem.class).list();
						}
					});
		} catch (RuntimeException re) {
			log.error("find by findByPriceInCategory failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsItem> findByCountPurchaseInCategory(
			final Integer psCategoryId, final FetchOption op) {
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsItem>>() {
						@Override
						public List<PsItem> doInHibernate(Session session)
								throws HibernateException, SQLException {
							SQLQuery query = session
									.createSQLQuery("select * from ps_item as P where P.id_category = ? "
											+ "order by count_purchase "
											+ (op.sortOption == SortOption.ASCENDING ? "asc"
													: "desc")
											+ "offset ? limit ?");

							query.setInteger(0, psCategoryId)
									.setInteger(1, op.offset)
									.setInteger(2, op.limit);
							query.addEntity(PsItem.class);

							return query.list();
						}
					});
		} catch (RuntimeException re) {
			log.error("find by findByCountPurchaseInCategory failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsItem> findByCountFavouriteInCategory(
			final Integer psCategoryId, final FetchOption op) {

		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsItem>>() {

						@Override
						public List<PsItem> doInHibernate(Session session)
								throws HibernateException, SQLException {
							SQLQuery query = session
									.createSQLQuery("select * from ps_item as P where P.id_category = ? "
											+ "order by count_favourite "
											+ (op.sortOption == SortOption.ASCENDING ? "asc"
													: "desc")
											+ "offset ? limit ?");

							query.setInteger(0, psCategoryId)
									.setInteger(1, op.offset)
									.setInteger(2, op.limit);
							query.addEntity(PsItem.class);

							return query.list();
						}
					});
		} catch (RuntimeException re) {
			log.error("find by findByCountFavouriteInCategory failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsItem> findByVoteInCategory(final Integer psCategoryId,
			final FetchOption op) {

		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsItem>>() {

						@Override
						public List<PsItem> doInHibernate(Session session)
								throws HibernateException, SQLException {
							SQLQuery query = session
									.createSQLQuery("select * from ps_item as P where P.id_category = ? "
											+ "order by vote "
											+ (op.sortOption == SortOption.ASCENDING ? "asc"
													: "desc")
											+ "offset ? limit ?");

							query.setInteger(0, psCategoryId)
									.setInteger(1, op.offset)
									.setInteger(2, op.limit);
							query.addEntity(PsItem.class);

							return query.list();
						}
					});
		} catch (RuntimeException re) {
			log.error("find by findByVoteInCategory failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsItem> findByPriceInTag(final Integer psTagId,
			final Double priceMin, final Double priceMax, final FetchOption op) {
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsItem>>() {

						@Override
						public List<PsItem> doInHibernate(Session session)
								throws HibernateException, SQLException {
							SQLQuery query = session
									.createSQLQuery("select P.* from ps_item as P where P.id in (select R.id_item from r_tag_item as R where R.id_tag = ? ) "
											+ " and P.price > ? and P.price < ? "
											+ "order by price "
											+ (op.sortOption == SortOption.ASCENDING ? "asc"
													: "desc")
											+ " offset ? limit ?");

							query.setInteger(0, psTagId).setDouble(1, priceMin)
									.setDouble(2, priceMax)
									.setInteger(3, op.offset)
									.setInteger(4, op.limit);

							return query.addEntity(PsItem.class).list();
						}
					});
		} catch (RuntimeException re) {
			log.error("find by findByPriceInTag failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsItem> findByCountPurchaseInTag(final Integer psTagId,
			final FetchOption op) {
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsItem>>() {

						@Override
						public List<PsItem> doInHibernate(Session session)
								throws HibernateException, SQLException {
							SQLQuery query = session
									.createSQLQuery("select P.* from ps_item as P where P.id in (select R.id_item from r_tag_item as R where R.id_tag = ? ) "
											+ "order by count_purchase "
											+ (op.sortOption == SortOption.ASCENDING ? "asc"
													: "desc")
											+ " offset ? limit ?");

							query.setInteger(0, psTagId)
									.setInteger(1, op.offset)
									.setInteger(2, op.limit);

							return query.addEntity(PsItem.class).list();
						}
					});
		} catch (RuntimeException re) {
			log.error("find by findByCountPurchaseInTag failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsItem> findByCountFavouriteInTag(final Integer psTagId,
			final FetchOption op) {
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsItem>>() {

						@Override
						public List<PsItem> doInHibernate(Session session)
								throws HibernateException, SQLException {
							SQLQuery query = session
									.createSQLQuery("select P.* from ps_item as P where P.id in (select R.id_item from r_tag_item as R where R.id_tag = ? ) "
											+ "order by count_favourite "
											+ (op.sortOption == SortOption.ASCENDING ? "asc"
													: "desc")
											+ " offset ? limit ?");

							query.setInteger(0, psTagId)
									.setInteger(1, op.offset)
									.setInteger(2, op.limit);

							return query.addEntity(PsItem.class).list();
						}
					});
		} catch (RuntimeException re) {
			log.error("find by findByCountFavouriteInTag failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsItem> findByVoteInTag(final Integer psTagId,
			final FetchOption op) {
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsItem>>() {

						@Override
						public List<PsItem> doInHibernate(Session session)
								throws HibernateException, SQLException {
							SQLQuery query = session
									.createSQLQuery("select P.* from ps_item as P where P.id in (select R.id_item from r_tag_item as R where R.id_tag = ? ) "
											+ "order by vote "
											+ (op.sortOption == SortOption.ASCENDING ? "asc"
													: "desc")
											+ " offset ? limit ?");

							query.setInteger(0, psTagId)
									.setInteger(1, op.offset)
									.setInteger(2, op.limit);

							return query.addEntity(PsItem.class).list();
						}
					});
		} catch (RuntimeException re) {
			log.error("find by findByVoteInTag failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsItem> findByOrderId(final Integer id) {
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsItem>>() {

						@Override
						public List<PsItem> doInHibernate(Session session)
								throws HibernateException, SQLException {
							SQLQuery query = session
									.createSQLQuery("select P.* from ps_item as P where P.id in (select R.id_item from r_order_item as R where R.id_order = ? ) ");

							query.setInteger(0, id);
							query.addEntity(PsItem.class);
							return query.list();
						}
					});

		} catch (RuntimeException re) {
			log.error("find by findByOrderId failed", re);
			throw re;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsItem> findBySeller(final Integer sellerId,
			final FetchOption fetchOption) {
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsItem>>() {

						@Override
						public List<PsItem> doInHibernate(Session session)
								throws HibernateException, SQLException {
							SQLQuery query = session
									.createSQLQuery("select P.* from ps_item as P where P.id_shop in (select S.id from ps_shop as S where S.id_seller = ? ) ");

							query.setInteger(0, sellerId);
							query.addEntity(PsItem.class);
							return query.list();
						}
					});

		} catch (RuntimeException re) {
			log.error("find by findBySeller failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsItem> findByShop(final Integer shopId, final FetchOption fetchOption) {
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsItem>>() {

						@Override
						public List<PsItem> doInHibernate(Session session)
								throws HibernateException, SQLException {
							SQLQuery query = session
									.createSQLQuery("select * from ps_item as P where P.id_shop = ? "
											+ "order by name "
											+ (fetchOption.sortOption == SortOption.ASCENDING ? "asc"
													: "desc")
											+ "offset ? limit ?");

							query.setInteger(0, shopId)
									.setInteger(1, fetchOption.offset)
									.setInteger(2, fetchOption.limit);
							query.addEntity(PsItem.class);

							return query.list();
						}
					});
		} catch (RuntimeException re) {
			log.error("find by findByShop failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsItem> findByCountPurchase(final FetchOption op) {
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsItem>>() {

						@Override
						public List<PsItem> doInHibernate(Session session)
								throws HibernateException, SQLException {
							SQLQuery query = session
									.createSQLQuery("select * from ps_item "
											+ "order by count_purchase "
											+ (op.sortOption == SortOption.ASCENDING ? "asc"
													: "desc")
											+ "offset ? limit ?");

							query.setInteger(0, op.offset)
									.setInteger(1, op.limit);
							query.addEntity(PsItem.class);

							return query.list();
						}
					});
		} catch (RuntimeException re) {
			log.error("find by findByCountPurchase failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsItem> findByCountFavourite(final FetchOption op) {
		try {
			return getHibernateTemplate().executeFind(
					new HibernateCallback<List<PsItem>>() {

						@Override
						public List<PsItem> doInHibernate(Session session)
								throws HibernateException, SQLException {
							SQLQuery query = session
									.createSQLQuery("select * from ps_item "
											+ "order by count_favourite "
											+ (op.sortOption == SortOption.ASCENDING ? "asc"
													: "desc")
											+ "offset ? limit ?");

							query.setInteger(0, op.offset)
									.setInteger(1, op.limit);
							query.addEntity(PsItem.class);

							return query.list();
						}
					});
		} catch (RuntimeException re) {
			log.error("find by findByCountFavourite failed", re);
			throw re;
		}
	}

}