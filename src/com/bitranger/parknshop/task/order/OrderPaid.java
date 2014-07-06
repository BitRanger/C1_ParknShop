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
package com.bitranger.parknshop.task.order;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.scheduling.concurrent.ScheduledExecutorFactoryBean;

import com.bitranger.parknshop.buyer.dao.PsNoticeCustomerDAO;
import com.bitranger.parknshop.buyer.model.PsNoticeCustomer;
import com.bitranger.parknshop.seller.dao.PsNoticeSellerDAO;
import com.bitranger.parknshop.seller.dao.impl.PsOrderDAO;
import com.bitranger.parknshop.seller.model.PsNoticeSeller;
import com.bitranger.parknshop.seller.model.PsOrder;


/**
 *@author BowenCai
 *@since 7:50:10 PM
 */
public class OrderPaid extends PsNoticeCustomerDAO implements Runnable {

	@Autowired
	PsNoticeSellerDAO psNoticeSellerDAO;
	
	@Autowired
	PsOrderDAO psOrderDAO;
	
	@Override
	public void run() {
		
		getHibernateTemplate().execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session arg0) throws HibernateException,
					SQLException {
				
				SQLQuery query = arg0.createSQLQuery(
						"");
				
				@SuppressWarnings("unchecked")
				List<PsOrder> orders = query.list();
				for (PsOrder psOrder : orders) {
					
					PsNoticeCustomer cnotice = new PsNoticeCustomer();
					cnotice.setPsCustomer(psOrder.getPsCustomer());
					cnotice.setMessage("Unpaied order cancled");
					save(cnotice);
					
					PsNoticeSeller nSeller = new PsNoticeSeller();
					nSeller.setPsSeller(psOrder.getPsShop().getPsSeller());
					nSeller.setMessage("Unpaied order cancled");
					psNoticeSellerDAO.save(nSeller);
					
					psOrderDAO.delete(psOrder);
					
				}
				return null;
			}
		});
	}
	
}







