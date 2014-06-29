/*******************************************************************************
 * Copyright (c) 2014 BitRanger.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v2.1
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     BitRanger - initial API and implementation
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
	public List<PsOrder> findByCustomerId(final Integer id);
	
	public abstract List<PsOrder> findBySellerId(Integer id);
	

	public List<PsOrder> findByShopId(final Integer id);
	public abstract List<PsOrder> findByShopId(Integer id, Date from, Date to);
<<<<<<< HEAD
	public abstract List<PsOrder> findByShopId(Integer id, Short state);
	
	public List<PsOrder> findAll(Short state);
=======
	public abstract List<PsOrder> findByShopId(Integer id, OrderState state);
	public abstract List<PsOrder> findByCustomerId(Integer id);
	
	public abstract List<PsOrder> findAll(Short state);
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
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

}
