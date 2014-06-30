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

import java.sql.SQLException;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *@author BowenCai
 *@since 4:16:21 PM
 */
public class MaintainDB extends HibernateDaoSupport implements Runnable{

	@Override
	public void run() {
//		SessionFactory sessionFactory = factory.getBean("");
		@SuppressWarnings("unchecked")
		final Map<String, SingleTableEntityPersister> map 
			= getHibernateTemplate().getSessionFactory().getAllClassMetadata();
		
		getHibernateTemplate().execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session)
					throws HibernateException, SQLException {
				Transaction tnx = null;
				try {
					tnx = session.beginTransaction();
					
					for (SingleTableEntityPersister v : map.values()) {
						session.createSQLQuery("analyze table " + v.getTableName()).executeUpdate();
						session.createSQLQuery("optimize table " + v.getTableName()).executeUpdate();
					}
					tnx.commit();
				} catch (Exception e) {
					throw new RuntimeException(e);
				} finally{
					if (tnx != null && tnx.isActive()) {
						tnx.rollback();
					}
				}
				return null;
			}
		});
	}
	

}
