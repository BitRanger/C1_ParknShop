package test.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bitranger.parknshop.common.dao.impl.PersistantMap;


/**
 *@author BowenCai
 *@since 9:43:06 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestPersistantMap {

	@Before
	public void setUp() throws Exception {
	}


	@After
	public void tearDown() throws Exception {
	}

	@Autowired
	public PersistantMap persistantMap;
	
	@Test
	public void test() {
		System.out.println("PersistantMapTest.test()");
		ArrayList<String> as = new ArrayList<String>();
		as.add("1234");
		as.add("ret43w7cjm2398yrx");
		as.add("456s7t68we74g6s4g564gw6er4g6e5r4gw864ryg");
		persistantMap.put("kkk4", as);
		List<String> o = persistantMap.get("kkk3");
		for (String string : o) {
			System.err.println(string);
		}
		persistantMap.remove("kkk4");
		o = persistantMap.keys();
		for (String string : o) {
			System.err.println(string);
		}
		System.out.println(persistantMap.containsKey("kkk3"));
//		System.out.println(persistantMap.get("key2 hahaha"));
//		PersistantMapTest t = (PersistantMapTest) map.get("key1 hahaha");
//		System.out.println(t.xxString);
//		System.out.println("PersistantMapTest.test()");
	}

}













