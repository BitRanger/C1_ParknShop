package com.bitranger.parknshop.seller.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bitranger.parknshop.seller.dao.IPsRecipientDAO;
import com.bitranger.parknshop.seller.model.PsRecipient;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsRecipient entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see PsRecipient
 * @author MyEclipse Persistence Tools
 */
public class PsRecipientDAO extends HibernateDaoSupport implements IPsRecipientDAO  {
	private static final Logger log = LoggerFactory
			.getLogger(PsRecipientDAO.class);
	// property constants
	public static final String NAME_RECIPIENT = "nameRecipient";
	public static final String ADDRESSS = "addresss";
	public static final String POSTAL_CODE = "postalCode";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String COUNTRY = "country";
	public static final String PROVINCE = "province";
	public static final String CITY = "city";
	public static final String DETAILED_ADDR = "detailedAddr";

	protected void initDao() {
		// do nothing
	}

	public void save(PsRecipient transientInstance) {
		log.debug("saving PsRecipient instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PsRecipient persistentInstance) {
		log.debug("deleting PsRecipient instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PsRecipient findById(Integer id) {
		log.debug("getting PsRecipient instance with id: " + id);
		try {
			PsRecipient instance = (PsRecipient) getHibernateTemplate().get(
					"com.bitranger.parknshop.seller.model.PsRecipient", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PsRecipient> findByExample(PsRecipient instance) {
		log.debug("finding PsRecipient instance by example");
		try {
			List<PsRecipient> results = (List<PsRecipient>) getHibernateTemplate()
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
		log.debug("finding PsRecipient instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PsRecipient as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PsRecipient> findByNameRecipient(Object nameRecipient) {
		return findByProperty(NAME_RECIPIENT, nameRecipient);
	}

	public List<PsRecipient> findByAddresss(Object addresss) {
		return findByProperty(ADDRESSS, addresss);
	}

	public List<PsRecipient> findByPostalCode(Object postalCode) {
		return findByProperty(POSTAL_CODE, postalCode);
	}

	public List<PsRecipient> findByPhoneNumber(Object phoneNumber) {
		return findByProperty(PHONE_NUMBER, phoneNumber);
	}

	public List<PsRecipient> findByCountry(Object country) {
		return findByProperty(COUNTRY, country);
	}

	public List<PsRecipient> findByProvince(Object province) {
		return findByProperty(PROVINCE, province);
	}

	public List<PsRecipient> findByCity(Object city) {
		return findByProperty(CITY, city);
	}

	public List<PsRecipient> findByDetailedAddr(Object detailedAddr) {
		return findByProperty(DETAILED_ADDR, detailedAddr);
	}

	public List findAll() {
		log.debug("finding all PsRecipient instances");
		try {
			String queryString = "from PsRecipient";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PsRecipient merge(PsRecipient detachedInstance) {
		log.debug("merging PsRecipient instance");
		try {
			PsRecipient result = (PsRecipient) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PsRecipient instance) {
		log.debug("attaching dirty PsRecipient instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PsRecipient instance) {
		log.debug("attaching clean PsRecipient instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PsRecipientDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (PsRecipientDAO) ctx.getBean("PsRecipientDAO");
	}

	@Override
	public void update(PsRecipient detachedInstance) {
		getHibernateTemplate().update(detachedInstance);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsRecipient> findByCustomId(final Integer id) {
		return getHibernateTemplate().executeFind(new HibernateCallback<List<PsRecipient>>() {

			@Override
			public List<PsRecipient> doInHibernate(Session session)
					throws HibernateException, SQLException {
				SQLQuery q = session.createSQLQuery(
				"select * from ps_recipient as RP where RP.id_customer = ?");
				q.setInteger(0, id);
				q.addEntity(PsRecipient.class);
				return q.list();
			}
		});
	}
}