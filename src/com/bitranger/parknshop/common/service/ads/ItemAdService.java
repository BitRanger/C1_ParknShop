package com.bitranger.parknshop.common.service.ads;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.Nullable;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.ads.PsAdItemDAO;
import com.bitranger.parknshop.common.ads.PsPromotItem;
import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.common.model.PsTag;

/*
 index page
 select * from ps_promot_item as PM 
inner join ps_ad_item as AD on AD.id_promot = PM.id
where AD.time_start < CURRENT_TIMESTAMP and CURRENT_TIMESTAMP < AD.time_end
order by AD.weight desc
limit 0, 32

Item:

select * from ps_promot_item as PM 
	inner join ps_ad_item as AD on AD.id_promot = PM.id
	inner join ps_item as IT on IT.id = PM.id_item
	inner join r_tag_item as RIT on RIT.id_item = IT.id
where IT.id_category = ?
	and AD.time_start < CURRENT_TIMESTAMP and CURRENT_TIMESTAMP < AD.time_end
	and RIT.id_tag in (???)

order by AD.weight desc
limit 0, 32

 */

/**
 *@author BowenCai
 *@since 9:06:20 PM
 */
public class ItemAdService implements IItemAdService {

	public PsAdItemDAO psAdItemDAO;
	


	@SuppressWarnings("unchecked")
	@Override
	public List<PsPromotItem> forIndexPage(final int limit) {
		return psAdItemDAO.hibernate().executeFind(new HibernateCallback<List<PsPromotItem>>() {

			@Override
			public List<PsPromotItem> doInHibernate(Session session)
					throws HibernateException, SQLException {
				
				SQLQuery query = session.createSQLQuery(
" select * from ps_promot_item as PM "+
" inner join ps_ad_item as AD on AD.id_promot = PM.id " +
" where AD.time_start < CURRENT_TIMESTAMP and CURRENT_TIMESTAMP < AD.time_end " +
" order by AD.weight desc " +
" limit 0, 32 "
				);
				List<PsPromotItem> ls = query.addEntity(PsPromotItem.class).list();
				
				return randomReduce(ls, limit);
			}
		});
	}
	
	/**
	 
select AD.*, count(RTI.id_tag) as TAG_INTER from ps_item as IT
				inner join r_tag_item as RTI on RTI.id_item = IT.id
				inner join ps_promot_item as AD on AD.id_item = IT.id
where IT.id = ? and RTI.id_tag in (???)
order by TAG_INTER desc

	 */

	
	@SuppressWarnings("unchecked")
	@Override
	public List<PsPromotItem> forItemList(@Nullable final List<PsItem> items, 
								final int limit, 
								@Nullable PsCustomer customer) {
									
		final HashSet<PsTag> tags = new HashSet<>(items.size() * 6);
		for (PsItem i : items) {
			tags.addAll(i.getPsTags());
		}
		final StringBuilder b = new StringBuilder(512);
b.append(
" select AD.*, count(RTI.id_tag) as TAG_INTER from ps_item as IT " + 
" inner join r_tag_item as RTI on RTI.id_item = IT.id " + 
" inner join ps_promot_item as AD on AD.id_item = IT.id  ");
		if (tags != null && tags.size() > 1) {
			b.append("  where RTI.id_tag in (  ");
		for (PsTag psTag : tags) {
			b.append(psTag.getId()).append(',');
		}
		b.setCharAt(b.length() - 1, ')');
	}
		
		b.append(" order by TAG_INTER desc  ");
		System.out.println(b.toString());
		return psAdItemDAO.hibernate().executeFind(new HibernateCallback<List<PsPromotItem>>() {
			@Override
			public List<PsPromotItem> doInHibernate(Session session)
					throws HibernateException, SQLException {
				
				return session.createSQLQuery(b.toString()).addEntity(PsPromotItem.class).list();
			}
			
		});
//		Iterator<PsTag> i = tags.iterator();
//		while (tags.size() > limit) {
//			i.remove();
//		}
		
	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PsPromotItem> forItem(@Nullable final List<Integer> tags, 
								final int category,  final int limit, @Nullable PsCustomer customer) {
	
		return psAdItemDAO.hibernate().executeFind(new HibernateCallback<List<PsPromotItem>>() {

			@Override
			public List<PsPromotItem> doInHibernate(Session session)
					throws HibernateException, SQLException {
				
//				session.createSQLQuery(
//				"update ps_ad_item as AD set AD.num_fetched = AD.num_fetched + 1"
//				).executeUpdate();
				StringBuilder b = new StringBuilder(512);
				b.append(
						" select * from ps_promot_item as PM " +
								" inner join ps_ad_item as AD on AD.id_promot = PM.id " +
								" inner join ps_item as IT on IT.id = PM.id_item " +
								" inner join r_tag_item as RIT on RIT.id_item = IT.id " +
								" where IT.id_category = ? " +
								" and AD.time_start < CURRENT_TIMESTAMP and CURRENT_TIMESTAMP < AD.time_end "
				);
				if (tags != null && tags.size() > 0) {
					b.append(" and RIT.id_tag in (");
					for (Integer i : tags) {
						b.append(i).append(',');
					}
					b.setCharAt(b.length() - 1, ')');
				}
				
				b.append(
						" order by AD.weight desc " +
						" limit 0, 32 ");
				
				SQLQuery query = session.createSQLQuery(b.toString());
				query.setInteger(0, category);
				List<PsPromotItem> ls = query.addEntity(PsPromotItem.class).list();
				
				return randomReduce(ls, limit);
			}
		});
	}
	
	public List<PsPromotItem> randomReduce(List<PsPromotItem> src, int limit) {
		if (src.size() > limit) {
			ThreadLocalRandom rand = ThreadLocalRandom.current();
			int idx = rand.nextInt(limit);
			int nidx = rand.nextInt(limit, src.size());
			src.set(idx, src.get(nidx));
			return new ArrayList<>(src.subList(0, limit));
		} else {
			return src;
		}
	}

	/**
	 * @return the psAdItemDAO
	 */
	public PsAdItemDAO getPsAdItemDAO() {
		return psAdItemDAO;
	}

	/**
	 * @param psAdItemDAO the psAdItemDAO to set
	 */
	public void setPsAdItemDAO(PsAdItemDAO psAdItemDAO) {
		this.psAdItemDAO = psAdItemDAO;
	}
}
