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

import java.util.Date;
import java.util.List;


import com.bitranger.parknshop.seller.model.PsOrder;

public interface IPsOrderDAO {

	public abstract void save(PsOrder transientInstance);
	public abstract void delete(PsOrder persistentInstance);
	public abstract void update(PsOrder detachedInstance);
	
	public abstract PsOrder findByOrderId(Integer id);
	
	public List<PsOrder> findByCustomerId(final Integer id, final Short state);
	public abstract List<PsOrder> findByCustomerId(Integer id, Date from, Date to);
	
	public abstract List<PsOrder> findBySellerId(Integer id);
	

	public List<PsOrder> findByShopId(final Integer id);
	public abstract List<PsOrder> findByShopId(Integer id, Date from, Date to);
	public abstract List<PsOrder> findByShopId(Integer id, Short state);
	
	public List<PsOrder> findAll(Short state);
	public abstract List<PsOrder> findAll(Date from, Date to);

	public double countTnxVolumn();
//
////	public int getAdCount(Date start, Date end);
////	public double getAdAmont(Date start, Date end);
//	public double getAdRevenue(Date start, Date end);
////	
////
////	public int getTnxCount(Date start, Date end);
////	public double getTnxAmont(Date start, Date end);
//	public double getSaleRevenue(Date start, Date end);
	List<PsOrder> findByCustomerId(Integer id);

}
