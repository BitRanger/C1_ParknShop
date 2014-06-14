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
package test.dao;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import javax.inject.Inject;

import junit.framework.TestSuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bitranger.parknshop.common.dao.impl.PsCategoryDAO;
import com.bitranger.parknshop.common.dao.impl.PsItemDAO;
import com.bitranger.parknshop.common.dao.impl.PsTagDAO;
import com.bitranger.parknshop.common.model.PsCategory;
import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.common.model.PsTag;
import com.bitranger.parknshop.seller.dao.impl.PsSellerDAO;
import com.bitranger.parknshop.seller.dao.impl.PsShopDAO;
import com.bitranger.parknshop.seller.model.PsSeller;
import com.bitranger.parknshop.seller.model.PsShop;

/**
 * 
 * 
 * @author BowenCai
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestItemDAO extends TestSuite {
	
/*	@Inject
	PsCategoryDAO psCategoryDAO;
	
	
	@Inject
	PsShopDAO psShopDAO;

	@Inject
	PsSellerDAO psSellerDAO;
	
	@Inject
	PsTagDAO psTagDAO;
	
	@Inject
	PsItemDAO psItemDAO;
	

	@Before
	public void setUp() throws Exception {
		
		PsCategory category = new PsCategory("test category 3");
		psCategoryDAO.save(category);
		
		PsTag tag = new PsTag("test_tag 2");
		psTagDAO.save(tag);
		
		PsSeller seller = new PsSeller("test nick name", 
										"test id number wetervet", 
										"psw123456", 
										"test@test.com");
		psSellerDAO.save(seller);
		
		PsShop shop = new PsShop(seller, "test shop name", (short)1);
		psShopDAO.save(shop);
		
		PsItem item = new PsItem(
				shop, category, 
				"test item 1", 
				9.99D);
		
		psItemDAO.save(item);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		for (PsItem i : psItemDAO.findAll()) {
			System.out.println(i.getName());
		}
	}*/
}
