package test.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitranger.parknshop.dao.PsAdministatorDAO;
import com.bitranger.parknshop.dao.PsCategoryDAO;
import com.bitranger.parknshop.dao.PsItemDAO;
import com.bitranger.parknshop.dao.PsSellerDAO;
import com.bitranger.parknshop.dao.PsShopDAO;
import com.bitranger.parknshop.dao.PsTagDAO;
import com.bitranger.parknshop.model.PsItem;

public class TestSupport {
	@Autowired
	PsAdministatorDAO psAdministatorDAO;

	@Autowired
	PsSellerDAO psSellerDAO;
	
	@Autowired
	PsShopDAO psShopDAO; 

	@Autowired
	PsItemDAO	psItemDAO;

	@Autowired
	PsTagDAO	psTagDAO;
	
	@Autowired
	PsCategoryDAO	psCategoryDAO;
}
