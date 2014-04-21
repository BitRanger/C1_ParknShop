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
