package com.bitranger.parknshop.common.recommend.basic;

import java.util.List;

public class Feature {
	
	List<Integer> groupIds;
	int category;
	public Feature(List<Integer> groupIds, int category, List<Integer> buyIds) {
		super();
		this.groupIds = groupIds;
		this.category = category;
		this.buyIds = buyIds;
	}
	List<Integer> buyIds;
	
}
