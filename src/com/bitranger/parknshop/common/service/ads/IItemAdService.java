package com.bitranger.parknshop.common.service.ads;

import java.util.List;

import javax.annotation.Nullable;

import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.ads.PsPromotItem;
import com.bitranger.parknshop.common.model.PsItem;


/**
 * 
 * @author BowenCai
 *
 */
public interface IItemAdService {

	public List<PsPromotItem> forIndexPage(int limit);
	
	public List<PsPromotItem> forItem(@Nullable List<Integer> tags, int category, 
										int limit,
										@Nullable PsCustomer customer);

	List<PsPromotItem> forItemList(List<PsItem> tags, int limit,
			PsCustomer customer);
	
}
