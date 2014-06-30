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
package com.bitranger.parknshop.task;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.TransactionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bitranger.parknshop.admin.data.PsAdminAcc;
import com.bitranger.parknshop.admin.data.PsAdminAccDAO;
import com.bitranger.parknshop.admin.data.PsAdministrator;
import com.bitranger.parknshop.admin.data.PsAdministratorDAO;
import com.bitranger.parknshop.common.model.OrderStatus;
import com.bitranger.parknshop.seller.dao.IPsOrderDAO;
import com.bitranger.parknshop.seller.dao.IPsSellerDAO;
import com.bitranger.parknshop.seller.model.PsOrder;
import com.bitranger.parknshop.seller.model.PsSeller;

import com.bitranger.parknshop.seller.model.PsSellerAcc;

/**
 * @author Zhang Qinchuan
 * @author Yu Bowen
 * 
 *         Transaction support is REQUIRED!
 * 
 */
@Component
public class OrderChecker implements Runnable {
	
//	@Autowired
	private IPsOrderDAO psOrderDao;
	private PsAdministratorDAO psAdministratorDao;
	private IPsSellerDAO psSellerDao;
	
	public IPsOrderDAO getPsOrderDao() {
		return psOrderDao;
	}

	public void setPsOrderDao(IPsOrderDAO psOrderDao) {
		this.psOrderDao = psOrderDao;
	}

	public PsAdministratorDAO getPsAdministratorDao() {
		return psAdministratorDao;
	}

	public void setPsAdministratorDao(PsAdministratorDAO psAdministratorDao) {
		this.psAdministratorDao = psAdministratorDao;
	}

	public IPsSellerDAO getPsSellerDao() {
		return psSellerDao;
	}

	public void setPsSellerDao(IPsSellerDAO psSellerAccDao) {
		this.psSellerDao = psSellerAccDao;
	}

	private static Timestamp subtract(Timestamp left, Timestamp right) {
		return new Timestamp(left.getTime() - right.getTime());
	}

	private final Timestamp oneDay = new Timestamp(86400000);
	private final Timestamp threeDay = new Timestamp(259200000);
	private final Timestamp sevenDay = new Timestamp(604800000);

	@Override
	public void run() {
		Timestamp now = new Timestamp(System.currentTimeMillis());
		// 1. Check out-of-date unpaid order
		List<PsOrder> unpaidOrders = psOrderDao.findAll(OrderStatus.UNPAID);
		for (PsOrder psOrder : unpaidOrders) {
			Timestamp orderTimestamp = psOrder.getTimeCreated();
			if (subtract(now, orderTimestamp).after(oneDay)) {
				psOrder.setStatus(OrderStatus.CANCELLED);
				psOrderDao.update(psOrder);

			}
		}

		// 2. Check out-of-date paid order
		List<PsOrder> paidOrders = psOrderDao.findAll(OrderStatus.PAID);
		for (PsOrder psOrder : paidOrders) {
			Timestamp paidTimestamp = psOrder.getTimePaid();
			if (subtract(now, paidTimestamp).after(threeDay)) {
				psOrder.setStatus(OrderStatus.CANCELLED);
				psOrderDao.update(psOrder);
				PsAdministrator psAdministrator = psAdministratorDao.findById(1);
				psAdministrator.setBalance(psAdministrator.getBalance()
						- psOrder.getPriceTotal());
				psAdministratorDao.update(psAdministrator);
			}
		}

		// 3. Check out-of-date delivering order
		List<PsOrder> deliveringOrders = psOrderDao
				.findAll(OrderStatus.DELIVERING);
		for (PsOrder psOrder : deliveringOrders) {
			Timestamp deliverTimestamp = psOrder.getTimeBeginDeliver();
			if (subtract(now, deliverTimestamp).after(sevenDay)) {
				psOrder.setStatus(OrderStatus.FINISHED);
				psOrderDao.update(psOrder);
//				@SuppressWarnings("unchecked")
//				List<PsSellerAcc> psSellerAccs = psSellerAccDao.findByProperty(
//						"id_seller", psOrder.getPsShop().getPsSeller().getId());
				
//				PsSellerAcc account = psSellerAccs.get(0);
//				double balance = account.getBalance();
//				account.setBalance(balance + psOrder.getPriceTotal());
//				psSellerAccDao.update(account);
				PsSeller seller = psOrder.getPsShop().getPsSeller();
				seller.setBalance(seller.getBalance() + psOrder.getPriceTotal());
				psSellerDao.update(seller);
				
				PsAdministrator psAdministrator = psAdministratorDao.findById(1);
				psAdministrator.setBalance(psAdministrator.getBalance()
						- psOrder.getPriceTotal());
				psAdministratorDao.update(psAdministrator);
			}
		}
	}
}
