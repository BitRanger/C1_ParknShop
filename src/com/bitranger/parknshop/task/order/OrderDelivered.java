//package com.bitranger.parknshop.task.order;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import org.hibernate.HibernateException;
//import org.hibernate.SQLQuery;
//import org.hibernate.Session;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate3.HibernateCallback;
//
//import com.bitranger.parknshop.buyer.dao.impl.PsNoticeCustomerDAO;
//import com.bitranger.parknshop.buyer.model.PsNoticeCustomer;
//import com.bitranger.parknshop.seller.dao.impl.PsNoticeSellerDAO;
//import com.bitranger.parknshop.seller.model.PsNoticeSeller;
//import com.bitranger.parknshop.seller.model.PsOrder;
//import com.bitranger.parknshop.seller.service.OrderService;
//
//
///**
// * 若干时间内，商品必须送达并签收
// * 
// *@author BowenCai
// *@since 11:50:28 AM
// */
//public class OrderDelivered extends PsNoticeSellerDAO implements Runnable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -3923305424769741328L;
//
//	@Autowired
//	PsNoticeCustomerDAO psNoticeCustomerDAO;
//	
//	OrderService orderService;
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
//				
//				query.addEntity(PsOrder.class);
//				@SuppressWarnings("unchecked")
//				List<PsOrder> orders = query.list();
//				
//				for (PsOrder psOrder : orders) {
//					PsNoticeCustomer cnotice = new PsNoticeCustomer();
//					cnotice.setIdCustomer(psOrder.getPsCustomer().getId());
//					cnotice.
//					cnotice.setMessage("undelivered order finished.");
//					psNoticeCustomerDAO.save(cnotice);
//					
//					orderService.orderFinished(psOrder);
//				}
//				
//				
//				return null;
//			}
//		});
//	}
//
//}
