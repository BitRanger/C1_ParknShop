package com.bitranger.parknshop.common.recommend.basic;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitranger.parknshop.buyer.dao.impl.PsCustomerDAO;
import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.ads.PsAdItemDAO;
import com.bitranger.parknshop.common.ads.PsPromotItem;
import com.bitranger.parknshop.common.ads.PsPromotItemDAO;
import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.common.model.PsTag;
import com.bitranger.parknshop.common.model.ROrderItem;
import com.bitranger.parknshop.seller.model.PsOrder;

public class CFilter {

	@Autowired
	public PsAdItemDAO psAdItemDAO;

	@Autowired
	public PsCustomerDAO psCustomerDAO;
	@Autowired
	PsPromotItemDAO psPromotItemDAO;
	
	@Autowired
	ItemRecommender recommender;
	
	@SuppressWarnings("unchecked")
	public List<PsPromotItem> filter(final List<PsItem> items, final int limit,
			final int id) {
		List<Integer> itemIds1 = new ArrayList<>(items.size());
		for (PsItem p : items) {
			itemIds1.add(p.getId());
		}
		
		List<Integer> itemIds2 = new ArrayList<>(128);
		for(PsOrder order : psCustomerDAO.findById(id).getPsOrders()) {
			for (ROrderItem ro : order.getROrderItems()) {
				itemIds2.add(ro.getPsItem().getId());
			}
		}
		List<Long> ls = recommender.recommend(new Feature(itemIds1, -1, itemIds2));
		List<PsPromotItem> rec = new ArrayList<>(ls.size());
		for (Long l : ls) {
			rec.addAll((psPromotItemDAO.findByProperty("id_item", l.intValue()));
		}
		return rec;
	}
	

	@SuppressWarnings("unchecked")
	public List<PsPromotItem> filter(List<Integer> tags, int category,
			int limit, Integer id) {
		
		List<Integer> itemIds = new ArrayList<>(128);
		for(PsOrder order : psCustomerDAO.findById(id).getPsOrders()) {
			for (ROrderItem ro : order.getROrderItems()) {
				itemIds.add(ro.getPsItem().getId());
			}
		}
		List<Long> ls = recommender.recommend(new Feature(tags, category, itemIds));
		List<PsPromotItem> rec = new ArrayList<>(ls.size());
		for (Long l : ls) {
			rec.addAll((psPromotItemDAO.findByProperty("id_item", l.intValue()));
		}
		return rec;
	}

}
