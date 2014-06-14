package com.bitranger.parknshop.buyer.dao;

import java.util.List;

import com.bitranger.parknshop.buyer.model.PsNoticeCustomer;
import com.bitranger.parknshop.seller.model.PsNoticeSeller;


/**
 * 
 * @author BowenCai
 *
 */
public interface IPsNoticeCustomerDAO {

	/**
	 * 
	 * @return n latest valid message
	 */
	public List<PsNoticeCustomer> getLatest(int customerID, int n);
	
	public abstract void save(PsNoticeCustomer transientInstance);

	public abstract void delete(PsNoticeCustomer persistentInstance);

	public abstract PsNoticeCustomer findById(java.lang.Integer id);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List<PsNoticeCustomer> findBySource(Object source);

	public abstract List<PsNoticeCustomer> findByMessage(Object message);

	public abstract List<PsNoticeCustomer> findByIsValid(Object isValid);

	public abstract List findAll();

	public abstract PsNoticeCustomer merge(PsNoticeCustomer detachedInstance);

}