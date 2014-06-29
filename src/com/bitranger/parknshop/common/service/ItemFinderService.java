package com.bitranger.parknshop.common.service;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.bitranger.parknshop.common.dao.ItemFinder;
import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.util.Str;
import com.bitranger.parknshop.visitor.views.Names;



public class ItemFinderService {

	private String sCategoryId = null;
	private String[] stagIds = null;
	private String sMaxPrice = null;
	private String sMinPrice = null;
	private String sPageNumber = null;
	private String sOrderBy = null;
	private String sAsd = null;

	@Autowired
	@Qualifier(value="itemFinder")
	private ItemFinder itemFinder;

	public ItemFinderService categoryId(String id){
		sCategoryId = id;
		return this;
	}
	
	public ItemFinderService tagIds(String[] tagIds){
		stagIds = tagIds;
		return this;
	}
	
	public ItemFinderService maxPrice(String maxPrice){
		sMaxPrice = maxPrice;
		return this;
	}
	
	public ItemFinderService minPrice(String minPrice){
		sMinPrice = minPrice;
		return this;
	}
	
	public ItemFinderService pageNumber(String pageNumber){
		sPageNumber = pageNumber;
		return this;
	}
	
	public ItemFinderService orderBy(String orderBy){
		sOrderBy = orderBy;
		return this;
	}
	
	public ItemFinderService asd(String asd){
		sAsd = asd;
		return this;
	}
	
	
	// return the list of items
	public List<PsItem> list(){
		
		Integer categoryId = -1;
		List<Integer> tagIds = null;
		Double maxPrice = Double.MAX_VALUE;
		Double minPrice = 0.0;
		Integer pageNumber = 1;
		String orderBy = null;
		boolean asd = false;
		
		categoryId = Integer.parseInt(sCategoryId);
		orderBy = sOrderBy;
		
		if(stagIds != null){
			
			Integer[] itagIds = new Integer[stagIds.length];
			
			for(int i = 0; i < stagIds.length; i++){
				itagIds[i] = Integer.parseInt(stagIds[i]);
			}
			tagIds = Arrays.asList(itagIds);
		}
		if(sMaxPrice != null){
			maxPrice = Double.parseDouble(sMaxPrice);
		}
		if(sMinPrice != null){
			minPrice = Double.parseDouble(sMinPrice);
		}
		if(sPageNumber != null){
			pageNumber = Integer.parseInt(sPageNumber);
		}
		if(sAsd != null){
			if(sAsd.equals("asd")){
				asd = true;
			}
		}
		
		List<PsItem> items = null;
		
		if(asd){
			
			items = itemFinder.newFind().categoryId(categoryId)
			   .tagIDs(tagIds)
			   .maxPrice(maxPrice)
			   .minPrice(minPrice)
			   .orderBy(orderBy)
			   .ascending()
			   .page(pageNumber)
			   .list();
			this.clear();
			
		}
		else{
			
			itemFinder.toString();
			
			items = itemFinder.newFind().categoryId(categoryId)
			   .tagIDs(tagIds)
			   .maxPrice(maxPrice)
			   .minPrice(minPrice)
			   .orderBy(orderBy)
			   .descending()
			   .page(pageNumber)
			   .list();
			this.clear();
		}	
		return items;
	}
	
	
	// itemFinder getter and setter!!!!!!!!!!!!!!!!
	public ItemFinder getItemFinder() {
		return itemFinder;
	}

	public void setItemFinder(ItemFinder itemFinder) {
		this.itemFinder = itemFinder;
	}
	
	/**
	 * return the list of the items
	 * @param request
	 * @return
	 */
	
	public List<PsItem> getItems(HttpServletRequest request){

// /itemlist?searchBar=drgsdfsd&searchBtn=Search
// /itemlist?category_id=4&page_number=2&order_by=vote&asd=desc#
		
		String key = request.getParameter("searchBar");
		if (Str.Utils.notBlank(key)) {
System.out.println("ItemFinderService.getItems()" + key);
System.out.println(itemFinder.newFind().search(key).size());
			return itemFinder.newFind().search(key);
		}
		
		return this.categoryId(request.getParameter(Names.params.categoryId))
    	 .tagIds(request.getParameterValues(Names.params.tag))
    	 .maxPrice(request.getParameter(Names.params.maxPrice))
    	 .minPrice(request.getParameter(Names.params.minPrice))
    	 .pageNumber(request.getParameter(Names.params.pageNumber))
    	 .orderBy(request.getParameter(Names.params.orderBy))
    	 .asd(request.getParameter(Names.params.asd))
    	 .list();
		
	}

	/**
	 * clear the attributes
	 */
	public void clear(){
		
		sCategoryId = null;
		stagIds = null;
		sMaxPrice = null;
		sMinPrice = null;
		sPageNumber = null;
		sOrderBy = null;
		sAsd = null;
	}
}
