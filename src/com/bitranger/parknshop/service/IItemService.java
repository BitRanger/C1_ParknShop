package com.bitranger.parknshop.service;

import java.util.List;

import javax.servlet.jsp.tagext.Tag;

import com.bitranger.parknshop.model.PSItem;
import com.bitranger.parknshop.model.PSTag;


/**
 * 
 * @author BowenCai
 *
 */
public interface IItemService {
	
	PSItem		 		getItemById(int id);
	
	List<PSItem>		getItemsByTag(PSTag tag);

	List<PSItem>		getItemsByTags(List<Tag> tags);
	
	List<Tag>			getTagsOfItem(PSItem item);
	
}
