package com.bitranger.parknshop.task;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.TransactionManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitranger.parknshop.admin.data.PsAdminAcc;
import com.bitranger.parknshop.admin.data.PsAdminAccDAO;
import com.bitranger.parknshop.common.model.OrderStatus;
import com.bitranger.parknshop.seller.OrderState;
import com.bitranger.parknshop.seller.dao.IPsOrderDAO;
import com.bitranger.parknshop.seller.dao.PsSellerAccDAO;
import com.bitranger.parknshop.seller.model.PsOrder;
import com.bitranger.parknshop.seller.model.PsSellerAcc;

/**
 * @author Zhang Qinchuan
 * @author Yu Bowen
 * 
 *         Transaction support is REQUIRED!
 * 
 */
public class OrderChecker implements Runnable {
	
	@Autowired
	IPsOrderDAO psOrderDao;

	@Autowired
	private PsAdminAccDAO psAdminAccDao;

	@Autowired
	private PsSellerAccDAO psSellerAccDao;

	private Timestamp subtract(Timestamp left, Timestamp right) {
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
				PsAdminAcc psAdminAcc = psAdminAccDao.findById(1);
				Double balance = psAdminAcc.getBalance();
				psAdminAcc.setBalance(balance - psOrder.getPriceTotal());
				psAdminAccDao.update(psAdminAcc);
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
				@SuppressWarnings("unchecked")
				List<PsSellerAcc> psSellerAccs = psSellerAccDao.findByProperty(
						"id_seller", psOrder.getPsShop().getPsSeller().getId());
				PsSellerAcc account = psSellerAccs.get(0);
				double balance = account.getBalance();
				account.setBalance(balance + psOrder.getPriceTotal());
				psSellerAccDao.update(account);
				
				PsAdminAcc psAdminAcc = psAdminAccDao.findById(1);
				psAdminAcc.setBalance(psAdminAcc.getBalance() - psOrder.getPriceTotal());
				psAdminAccDao.update(psAdminAcc);
			}
		}
	}
}
