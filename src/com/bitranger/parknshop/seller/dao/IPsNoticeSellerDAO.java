/*******************************************************************************
 * Copyright (c) 2014 BitRangers (Team C1).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      BitRangers (Team C1) - initial API and implementation
 ******************************************************************************/
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
