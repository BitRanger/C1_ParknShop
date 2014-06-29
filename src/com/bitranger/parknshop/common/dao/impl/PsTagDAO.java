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

import com.bitranger.parknshop.common.dao.IPsTagDAO;
import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.common.model.PsTag;

/**
 * A data access object (DAO) providing persistence and search support for PsTag
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.bitranger.parknshop.common.model.PsTag
 * @author MyEclipse Persistence Tools
 */
public class PsTagDAO extends HibernateDaoSupport implements IPsTagDAO {
	private static final Logger log = LoggerFactory.getLogger(PsTagDAO.class);
	// property constants
	public static final String NAME = "name";

	@Override
	protected void initDao() {
		// do nothing
	}

	@Override
	public void save(PsTag transientInstance) {
		log.debug("saving PsTag instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(PsTag persistentInstance) {
		log.debug("deleting PsTag instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PsTag> findAll() {
		log.debug("finding all PsTag instances");
		try {
			String queryString = "from PsTag";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public void update(PsTag detachedInstance) {
		log.debug("updating PsTag instance");
		try {
			getHibernateTemplate().update(detachedInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	@SuppressWarnings("null")
	@Override
	public List<PsTag> findTagsOfItems(List<PsItem> items) {
		List<PsTag> retList = null;
		for (int i = 0; i < items.size(); i++) {
			retList.addAll(items.get(i).getPsTags());
		}
		return retList;
	}
	
	/*
select TG.*, sum(TG.id) as TG_C from ps_tag as TG
		inner join r_tag_item	as RTI 	on RTI.id_tag 	= TG.id
		inner join ps_item 		as IT 	on IT.id 		= RTI.id_item
where IT.id_category = 5
group by TG.id
order by TG_C
limit 0, 64
	 */

	@Override
	@SuppressWarnings("unchecked")
	public List<PsTag> selectTopTags(final int category, final int limit) {
		
		return getHibernateTemplate().executeFind(new HibernateCallback<List<PsTag>>() {

			@Override
			public List<PsTag> doInHibernate(Session session)
					throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(
" select TG.*, sum(TG.id) as TG_C from ps_tag as TG "
+"		inner join r_tag_item as RTI on RTI.id_tag 	= TG.id "
+"		inner join ps_item as IT on IT.id = RTI.id_item "
+" where IT.id_category = ? "
+" group by TG.id "
+" order by TG_C "
+" limit 0, ? "
);
				query.addEntity(PsTag.class);
				query.setInteger(0, category);
				query.setInteger(1, limit);
				return query.list();
			}
		});
	}

	@Override
	public List<PsTag> selectTopTags(int category, List<String> items)
	{
		throw new RuntimeException("not implemented yet");
//		return getHibernateTemplate().executeFind(new HibernateCallback<List<PsTag>>() {
//
//			@Override
//			public List<PsTag> doInHibernate(Session session)
//					throws HibernateException, SQLException {
//				StringBuilder b = new StringBuilder(512);
//				b.append("select * from ");
//				SQLQuery q = session.createSQLQuery("");
//				return q.addEntity(PsTag.class).list();
//			}
//		});
		
	}

	public List<PsTag> findTagByIds(String[] tagIds) {
		
		String str = "from PsTag p where ";
		
		for(int i = 0; i < tagIds.length; i++) {
			str += "p.id = " + tagIds[i];
			if(i != tagIds.length - 1) {
				str += " or ";
			}
		}
		
		List<PsTag> tags = getHibernateTemplate().find(str);
		return tags;
	}
}




