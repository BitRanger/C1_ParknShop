package com.bitranger.parknshop.task;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


/**
 * 
 * clear out dated Advertisment
 * 
 *@author BowenCai
 *@since 7:34:28 PM
 */
public class ClearOutdated extends HibernateDaoSupport implements Runnable{

	/**
	 delete out dated advertisements, notice
	 
	 
delete from ps_promot_item as P inner join ps_ad_item as AD
 where AD.time_end < CURRENT_TIMESTAMP
	 
	 */
	@Override
	public void run() {
		getHibernateTemplate().execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session)
					throws HibernateException, SQLException {
				Transaction tnx = session.beginTransaction();
				SQLQuery query = session.createSQLQuery(
" delete from ps_promot_item as P inner join ps_ad_item as AD " +
" where AD.time_end < CURRENT_TIMESTAMP " 
);
				query.executeUpdate();
				
				/**
delete from ps_notice_seller as NS 
	where NS.is_valid = 0
	and DATE_ADD(NS.time_created, INTERVAL 60 DAY) < CURRENT_TIMESTAMP 
				
				 */
				query = session.createSQLQuery(
"delete from ps_notice_seller as NS " +
"	where NS.is_valid = 0 " +
"	and DATE_ADD(NS.time_created, INTERVAL 60 DAY) < CURRENT_TIMESTAMP "
);
				query.executeUpdate();
				
				
				query = session.createSQLQuery(
"delete from ps_notice_customer as NS " +
"	where NS.is_valid = 0 " +
"	and DATE_ADD(NS.time_created, INTERVAL 60 DAY) < CURRENT_TIMESTAMP "
);
				query.executeUpdate();
				
				
//				query = session.createSQLQuery(
//"delete from ps_notice_admin as NS " +
//"	where NS.is_valid = 0 " +
//"	and DATE_ADD(NS.time_created, INTERVAL 60 DAY) < CURRENT_TIMESTAMP "
//);
//				query.executeUpdate();
				
				tnx.commit();
				return null;
			}
		});
	}

}






