/*******************************************************************************
 * Copyright (c) 2014 BitRangers (Team C1).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      BitRangers (Team C1) - initial API and implementation
 ******************************************************************************/
package com.bitranger.parknshop.common.dao;

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
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.util.Str;
import com.bitranger.parknshop.visitor.view.VisitorView;



/**
 * 鐢ㄦ硶绀轰緥
 * 
 * 
 			List<PsItem> items=	finder.newFind()
					.categoryId(4)
					.tagIDs(3, 4, 5)
					.maxPrice(45.0)
					.minPrice(2.0)
					.orderBy("price").ascending()
					.list();
 * 
 * 娉ㄦ剰 鏈�@Nullable 鐨勬槸鍙�椤�
 * 鏈�@Nonnull 鐨勬槸蹇呭～椤�
 * 瀵逛簬 orderBy 鍙互涓嶅～锛�
 * 濡傛灉orderBy 璁剧疆浜嗙殑璇濓紝鎺掑簭榛樿鏄痙escending
 *@author BowenCai
 *@since 8:36:57 AM
 */
public class ItemFinder extends HibernateDaoSupport {
	
	
	static final Logger LOG = LoggerFactory.getLogger(ItemFinder.class);
			
	public Fetch newFind() {
		// getHibernateTemplate().toString();
		return new Fetch(getHibernateTemplate());
	}
	
	public static final class Fetch {
		
		Fetch(HibernateTemplate t) {
			this.hibernate = t;
		}
		
		@Nonnull
		Integer categoryId = -1;
		
		@Nullable
		List<Integer> tagIds = null;

		@Nullable
		Double maxPrice = Double.MAX_VALUE;
		
		@Nullable
		Double minPrice = 0.0;

		@Nonnull
		Integer pageNumber = 1;

		/**
		 * if null, no order and sort option
		 */
		@Nullable
		String orderBy = null;
		/**
		 * if orderBy is null, this one is null
		 * by default it is descending
		 */
		@Nullable
		boolean asd = false;

		HibernateTemplate hibernate;

		@SuppressWarnings("unchecked")
		public List<PsItem> search(final String q) {
			return hibernate.executeFind(new HibernateCallback<List<PsItem>>() {
				@Override
					public List<PsItem> doInHibernate(Session session)
								throws HibernateException, SQLException {
					
					SQLQuery query = session.createSQLQuery(
" SELECT IT.*, " +
" MATCH (`name`, `introduction`) AGAINST (? IN NATURAL LANGUAGE MODE) AS relevance "  +
" FROM `ps_item` as IT " +
" ORDER BY relevance DESC"
);
						query.setString(0, q);
						query.addEntity(PsItem.class);
						return query.list();
					}
				});
		}
		
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
			builder.append(" limit ? , ?");
			
//			System.out.println("ItemFinder.Fetch.getQuery()");
//			System.out.println(builder.toString());
			
			Integer offset = (this.pageNumber - 1) * VisitorView.itemNumberPerPage;
			SQLQuery query = session.createSQLQuery(builder.toString());
			query.setInteger(0, categoryId)
				.setDouble(1, minPrice)
				.setDouble(2, maxPrice)
				.setInteger(3, offset)
				.setInteger(4, VisitorView.itemNumberPerPage);
			
			System.out.println("ItemFinder.Fetch.getQuery()");
			System.out.println(categoryId + "_" + minPrice + "_" + maxPrice 
					+ "_" + offset + "_" + VisitorView.itemNumberPerPage);
			
			return query;
		}
				
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
//					parameters
		
		@Nonnull
		public Fetch categoryId(Integer categoryId1) {
			this.categoryId = categoryId1;
			return this;
		}

		@Nullable
		public Fetch tagIDs(Integer...tagids) {
			this.tagIds = Arrays.asList(tagids);
			return this;
		}
		@Nullable
		public Fetch tagIDs(List<Integer> tagids) {
			this.tagIds = tagids;
			return this;
		}

		@Nullable
		public Fetch maxPrice(Double max) {
			maxPrice = max;
			return this;
		}

		@Nullable
		public Fetch minPrice(Double min) {
			this.minPrice = min;
			return this;
		}

		@Nonnull
		public Fetch orderBy(String fieldName) {
			this.orderBy = fieldName;
			return this;
		}

		@Nonnull
		public Fetch ascending() {
			this.asd = true;
			return this;
		}

		@Nonnull
		public Fetch descending() {
			this.asd = false;
			return this;
		}
		
		@Check(constraints = "pageNum null and pageNum > 1, the first page is page 1")
		@Nonnull
		public Fetch page(Integer pageNum) {
			this.pageNumber = pageNum;
			return this;
		}

// ----------------------------------------------------

	}

}
