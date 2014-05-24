package com.bitranger.parknshop.common.fetch;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


/**
 * 用法示例
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
 * 注意 有 @Nullable 的是可选项
 * 有 @Nonnull 的是必填项
 * 对于 orderBy 可以不填，
 * 如果orderBy 设置了的话，排序默认是descending
 *@author BowenCai
 *@since 8:36:57 AM
 */
public class ItemFinder extends HibernateDaoSupport {
	
	public ItemFetch newFind() {
		return new ItemFetch(getHibernateTemplate());
	}
	
	public ItemFetch findWith(IFetchParamSetter setter) {
		ItemFetch fetch = new ItemFetch(getHibernateTemplate());
		setter.setParams(fetch);
		return fetch;
	}
}
