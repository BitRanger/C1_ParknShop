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
package test.admin;

import static org.junit.Assert.*;

import java.util.Map;

import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bitranger.parknshop.common.dao.impl.PsItemDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestDB {

	@Autowired
	PsItemDAO psItemDAO;
	@Test
	public void test() {
		System.out.println("TestDB.test()");
		Map<String, SingleTableEntityPersister> map = psItemDAO.getSessionFactory().getAllClassMetadata();
		for (Map.Entry<String, SingleTableEntityPersister> e : map.entrySet()) {
			System.out.println(e.getKey() + "   " + e.getValue().getRootTableName());
			System.out.println("analyze table " + e.getValue().getTableName());
		}
//		for (Map.Entry<String, String> e : map.entrySet()) {
//			System.out.println(e.getKey() + "   " + e.getValue());
//		}
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


}
