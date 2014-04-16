package com.bitranger.parknshop.dao;

import java.util.List;

import com.bitranger.parknshop.model.PSTag;


public interface IDAOTag extends BaseIDAO<PSTag> {

	public List<PSTag> 		getAll();
	public List<PSTag> 		getForItem();
	public List<PSTag> 		getForItems();
}
