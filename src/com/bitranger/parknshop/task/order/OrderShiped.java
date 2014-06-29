//package com.bitranger.parknshop.task.order;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import org.hibernate.HibernateException;
//import org.hibernate.SQLQuery;
//import org.hibernate.Session;
//import org.springframework.orm.hibernate3.HibernateCallback;
//
//import com.bitranger.parknshop.buyer.model.PsNoticeCustomer;
//import com.bitranger.parknshop.seller.dao.impl.PsNoticeSellerDAO;
//import com.bitranger.parknshop.seller.model.PsNoticeSeller;
//import com.bitranger.parknshop.seller.model.PsOrder;
//
//
///**
// * 
// * 规定时间 内， 要发货，
// * 			否则给通知，
// * 				否则取消订单，发警告
// *@author BowenCai
// *@since 11:50:03 AM
// */
//public class OrderShiped extends PsNoticeSellerDAO implements Runnable {
//	
//	@Override
//	public void run() {
//		
//		getHibernateTemplate().execute(new HibernateCallback<Void>() {
//
//			@Override
//			public Void doInHibernate(Session arg0) throws HibernateException,
//					SQLException {
//				
//				SQLQuery query = arg0.createSQLQuery(
//						"");
//				@SuppressWarnings("unchecked")
//				List<PsOrder> orders = query.list();
//				for (PsOrder psOrder : orders) {
//					
//					PsNoticeSeller nSeller = new PsNoticeSeller();
//					nSeller.setIdSeller(psOrder.getPsShop().getPsSeller().getId());
//					nSeller.setMessage("Unpaied order cancled");
//					save(nSeller);
//					
////					psOrderDAO.delete(psOrder);
//					
//				}
//				return null;
//			}
//		});
//	}
//
//}
