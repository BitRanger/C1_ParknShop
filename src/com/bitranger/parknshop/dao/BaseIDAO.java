package com.bitranger.parknshop.dao;

import java.util.List;

/**
 * common operations for each entity
 * 
 * 
 * @author BowenCai
 *
 * @param <T>
 */
public interface BaseIDAO<T> {

	
	public T 		getById(int id);
	public int 		save(T onj);
	public void 	bulkSave(List<T> objs);
	public void 	update(T obj);
	public void		delete(T obj);
	public void 	bulkDelete(List<T> objs);
	
}
