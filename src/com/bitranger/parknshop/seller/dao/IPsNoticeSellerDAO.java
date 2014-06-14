package com.bitranger.parknshop.seller.dao;

import java.util.List;

import com.bitranger.parknshop.seller.model.PsNoticeSeller;

public interface IPsNoticeSellerDAO {

	public List<PsNoticeSeller> getLatest(final int sellerID, final int n);
	
	public abstract void save(PsNoticeSeller transientInstance);

	public abstract void delete(PsNoticeSeller persistentInstance);

	public abstract PsNoticeSeller findById(java.lang.Integer id);

	public abstract List<PsNoticeSeller> findByProperty(String propertyName, Object value);

	public abstract List<PsNoticeSeller> findBySource(Object source);

	public abstract List<PsNoticeSeller> findByMessage(Object message);

	public abstract List<PsNoticeSeller> findByIsValid(Object isValid);

	public abstract List<PsNoticeSeller> findAll();

}