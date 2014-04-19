package test.dao;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bitranger.parknshop.dao.PsAdministatorDAO;
import com.bitranger.parknshop.dao.PsCategoryDAO;
import com.bitranger.parknshop.dao.PsItemDAO;
import com.bitranger.parknshop.dao.PsSellerDAO;
import com.bitranger.parknshop.dao.PsTagDAO;
import com.bitranger.parknshop.model.PsCategory;
import com.bitranger.parknshop.model.PsItem;
import com.bitranger.parknshop.model.PsSeller;
import com.bitranger.parknshop.model.PsShop;
import com.bitranger.parknshop.model.PsTag;

/**
 * 
 * 
 * @author BowenCai
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestItemDAO extends TestSupport{
	
	@Before
	public void setUp() throws Exception {
		
		PsCategory category = new PsCategory("test category 1");
		psCategoryDAO.save(category);
		
		PsTag tag = new PsTag("test_tag 1");
		psTagDAO.save(tag);
		
		PsSeller seller = new PsSeller("test nick name", "test 123", "psw123456", "test name");
		psSellerDAO.save(seller);
		
		PsShop shop = new PsShop(seller, "test shop name", (short)1);
		psShopDAO.save(shop);
		
		PsItem item = new PsItem(
				shop, category, 
				"test item 1", 
				9.99D, 
				"extral 1");
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
	}
}
