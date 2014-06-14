package com.bitranger.parknshop.common.fetch;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.annotations.Check;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.util.Str;
import com.bitranger.parknshop.visitor.views.VisitorViews;

/**
 *@author BowenCai
 *@since 8:01:43 PM
 */
public final class ItemFetch {

	static final Logger LOG = LoggerFactory.getLogger(ItemFetch.class);
	
	ItemFetch(HibernateTemplate t) {
		this.hibernate = t;
	}
	
	@Nonnull public
	Integer categoryId = -1;
	
	@Nullable public
	List<Integer> tagIds = null;

	@Nullable public
	Double maxPrice = Double.MAX_VALUE;
	
	@Nullable public
	Double minPrice = 0.0;

	@Nonnull public
	Integer pageNumber = 1;

	/**
	 * if null, no order and sort option
	 */
	@Nullable public
	String orderBy = null;
	/**
	 * if orderBy is null, this one is null
	 * by default it is descending
	 */
	@Nullable public
	boolean asd = false;

	HibernateTemplate hibernate;
	
	@SuppressWarnings("unchecked")
	public List<PsItem> list() {
		return hibernate.executeFind(new HibernateCallback<List<PsItem>>() {
				@Override
					public List<PsItem> doInHibernate(Session arg0)
								throws HibernateException, SQLException {
						return getQuery(arg0)
								.addEntity(PsItem.class)
								.list();
					}
				});
	}
	
	final SQLQuery getQuery(Session session) {
		
		boolean withTags = tagIds != null && tagIds.size() > 0;
		
		StringBuilder builder = new StringBuilder(256);
		builder.append(
		"select * from ps_item as I "
		+ " where I.id_category = ? and I.price > ? and I.price < ? ");
		if (withTags) {
			builder.append(
			" and not exists ( select T.id from ps_tag as T where T.id in (");
			for (Integer i : tagIds) {
				builder.append(i).append(',');
			}
			builder.setCharAt(builder.length() - 1, ' ');
			builder.append(") except ( select R.id_tag from r_tag_item as R where R.id_item = I.id)"
			+ ")");
		}
		
		if (Str.Utils.notBlank(orderBy)) {
			builder.append(" order by ").append(orderBy)
			.append(asd ? " asc " : " desc ");
		}
		builder.append("limit ?, ?");
		
System.out.println("ItemFinder.Fetch.getQuery()");
System.out.println(builder.toString());

		Integer offset = (this.pageNumber - 1) * VisitorViews.itemNumberPerPage;
		SQLQuery query = session.createSQLQuery(builder.toString());
		query.setInteger(0, categoryId)
			.setDouble(1, minPrice)
			.setDouble(2, maxPrice)
			.setInteger(3, offset)
			.setInteger(4, VisitorViews.itemNumberPerPage);
		
		return query;
	}
	
//	public static void main(String...a) {
//		new Fetch(null)
//			.categoryId(4)
//			.tagIDs(3, 4, 5, 6, 7)
//			.maxPrice(45.0)
//			.minPrice(2.0)
//			.orderBy("price").descending()
//			.getQuery(null);
//	}
	
	
	public PsItem id(Integer itemId) {
		return hibernate.get(PsItem.class, itemId);
	}
	
	public PsItem unique() throws NullPointerException {
		List<PsItem> items = list();
		if (items.size() > 1) {
			LOG.warn("require unique PsItem, get[" + items.size() + "]", this);
		}
		return items.get(0);
	}

//-----------------------------------------------------------------------------
//				parameters
	
	@Nonnull
	public ItemFetch categoryId(Integer categoryId1) {
		this.categoryId = categoryId1;
		return this;
	}

	@Nullable
	public ItemFetch tagIDs(Integer...tagids) {
		this.tagIds = Arrays.asList(tagids);
		return this;
	}
	@Nullable
	public ItemFetch tagIDs(List<Integer> tagids) {
		this.tagIds = tagids;
		return this;
	}

	@Nullable
	public ItemFetch maxPrice(Double max) {
		maxPrice = max;
		return this;
	}

	@Nullable
	public ItemFetch minPrice(Double min) {
		this.minPrice = min;
		return this;
	}

	@Nonnull
	public ItemFetch orderBy(String fieldName) {
		this.orderBy = fieldName;
		return this;
	}

	@Nonnull
	public ItemFetch ascending() {
		this.asd = true;
		return this;
	}

	@Nonnull
	public ItemFetch descending() {
		this.asd = false;
		return this;
	}
	
	@Check(constraints = "pageNum null and pageNum > 1, the first page is page 1")
	@Nonnull
	public ItemFetch page(Integer pageNum) {
		this.pageNumber = pageNum;
		return this;
	}

//----------------------------------------------------

}