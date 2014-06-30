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
package com.bitranger.parknshop.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.bitranger.parknshop.admin.data.PsAdministratorDAO;
import com.bitranger.parknshop.admin.data.PsNoticeAdminDAO;
import com.bitranger.parknshop.buyer.dao.IPsCustomerDAO;
import com.bitranger.parknshop.common.ads.PsAdItemDAO;
import com.bitranger.parknshop.common.ads.PsItemPromotInfoDAO;
import com.bitranger.parknshop.common.ads.PsPromotItemDAO;
import com.bitranger.parknshop.common.dao.IPsItemDAO;
import com.bitranger.parknshop.common.service.ads.AdCenter;
import com.bitranger.parknshop.seller.dao.IPsOrderDAO;
import com.bitranger.parknshop.seller.dao.IPsSellerDAO;
import com.bitranger.parknshop.seller.dao.IPsShopDAO;
import com.bitranger.parknshop.seller.dao.PsOrderLogDAO;
import com.bitranger.parknshop.seller.dao.PsShopApplyDAO;


/**
 * 
 * 
 *@author BowenCai
 *@since 10:11:39 PM
 */
public class PropHolder {

	public @Autowired PsAdministratorDAO psAdministratorDAO;
	
	public @Autowired	IPsItemDAO psItemDAO;
	public @Autowired	IPsCustomerDAO psCustomerDAO;
	public @Autowired	IPsOrderDAO psOrderDAO;
//	public @Autowired  PsOrderLogDAO psOrderLogDAO;
	public @Autowired	IPsSellerDAO psSellerDAO;
	public @Autowired	IPsShopDAO psShopDAO;
	public @Autowired	PsNoticeAdminDAO psNoticeAdminDAO;
	public @Autowired	PsAdItemDAO psAdItemDAO;
	public @Autowired	PsItemPromotInfoDAO psItemPromotInfoDAO;
	public @Autowired   PsPromotItemDAO psPromotItemDAO;
	
	@Autowired
	public PsShopApplyDAO  psShopApplyDAO;

	@Autowired
	public 	AdCenter adCenter;

	public void inject(ModelAndView mv) {
		mv.addObject("psItemDAO", psItemDAO);
		mv.addObject("psCustomerDAO", psCustomerDAO);
		mv.addObject("psOrderDAO", psOrderDAO);
		mv.addObject("psSellerDAO", psSellerDAO);
		mv.addObject("psShopDAO", psShopDAO);
		
		mv.addObject("psNoticeAdminDAO", psNoticeAdminDAO);
		
		mv.addObject("psAdItemDAO", psAdItemDAO);
		mv.addObject("psPromotItemDAO", psPromotItemDAO);
	}
	
	public void inject(HttpServletRequest request) {
		request.setAttribute("psItemDAO", psItemDAO);
		request.setAttribute("psCustomerDAO", psCustomerDAO);
		request.setAttribute("psOrderDAO", psOrderDAO);
		request.setAttribute("psSellerDAO", psSellerDAO);
		request.setAttribute("psShopDAO", psShopDAO);
		
		request.setAttribute("psNoticeAdminDAO", psNoticeAdminDAO);
		
		request.setAttribute("psAdItemDAO", psAdItemDAO);
		request.setAttribute("psPromotItemDAO", psPromotItemDAO);
	}
	/**
	 * @return the psItemDAO
	 */
	public IPsItemDAO getPsItemDAO() {
		return psItemDAO;
	}

	/**
	 * @param psItemDAO the psItemDAO to set
	 */
	public void setPsItemDAO(IPsItemDAO psItemDAO) {
		this.psItemDAO = psItemDAO;
	}

	/**
	 * @return the psCustomerDAO
	 */
	public IPsCustomerDAO getPsCustomerDAO() {
		return psCustomerDAO;
	}

	/**
	 * @param psCustomerDAO the psCustomerDAO to set
	 */
	public void setPsCustomerDAO(IPsCustomerDAO psCustomerDAO) {
		this.psCustomerDAO = psCustomerDAO;
	}

	/**
	 * @return the psOrderDAO
	 */
	public IPsOrderDAO getPsOrderDAO() {
		return psOrderDAO;
	}

	/**
	 * @param psOrderDAO the psOrderDAO to set
	 */
	public void setPsOrderDAO(IPsOrderDAO psOrderDAO) {
		this.psOrderDAO = psOrderDAO;
	}

	/**
	 * @return the psSellerDAO
	 */
	public IPsSellerDAO getPsSellerDAO() {
		return psSellerDAO;
	}

	/**
	 * @param psSellerDAO the psSellerDAO to set
	 */
	public void setPsSellerDAO(IPsSellerDAO psSellerDAO) {
		this.psSellerDAO = psSellerDAO;
	}

	/**
	 * @return the psShopDAO
	 */
	public IPsShopDAO getPsShopDAO() {
		return psShopDAO;
	}

	/**
	 * @param psShopDAO the psShopDAO to set
	 */
	public void setPsShopDAO(IPsShopDAO psShopDAO) {
		this.psShopDAO = psShopDAO;
	}

	/**
	 * @return the psNoticeAdminDAO
	 */
	public PsNoticeAdminDAO getPsNoticeAdminDAO() {
		return psNoticeAdminDAO;
	}

	/**
	 * @param psNoticeAdminDAO the psNoticeAdminDAO to set
	 */
	public void setPsNoticeAdminDAO(PsNoticeAdminDAO psNoticeAdminDAO) {
		this.psNoticeAdminDAO = psNoticeAdminDAO;
	}

	/**
	 * @return the psAdItemDAO
	 */
	public PsAdItemDAO getPsAdItemDAO() {
		return psAdItemDAO;
	}

	/**
	 * @param psAdItemDAO the psAdItemDAO to set
	 */
	public void setPsAdItemDAO(PsAdItemDAO psAdItemDAO) {
		this.psAdItemDAO = psAdItemDAO;
	}

	/**
	 * @return the psItemPromotInfoDAO
	 */
	public PsItemPromotInfoDAO getPsItemPromotInfoDAO() {
		return psItemPromotInfoDAO;
	}

	/**
	 * @param psItemPromotInfoDAO the psItemPromotInfoDAO to set
	 */
	public void setPsItemPromotInfoDAO(PsItemPromotInfoDAO psItemPromotInfoDAO) {
		this.psItemPromotInfoDAO = psItemPromotInfoDAO;
	}

	/**
	 * @return the psPromotItemDAO
	 */
	public PsPromotItemDAO getPsPromotItemDAO() {
		return psPromotItemDAO;
	}

	/**
	 * @param psPromotItemDAO the psPromotItemDAO to set
	 */
	public void setPsPromotItemDAO(PsPromotItemDAO psPromotItemDAO) {
		this.psPromotItemDAO = psPromotItemDAO;
	}

	/**
	 * @return the adCenter
	 */
	public AdCenter getAdCenter() {
		return adCenter;
	}

	/**
	 * @param adCenter the adCenter to set
	 */
	public void setAdCenter(AdCenter adCenter) {
		this.adCenter = adCenter;
	}

//	/**
//	 * @return the psOrderLogDAO
//	 */
//	public PsOrderLogDAO getPsOrderLogDAO() {
//		return psOrderLogDAO;
//	}
//
//	/**
//	 * @param psOrderLogDAO the psOrderLogDAO to set
//	 */
//	public void setPsOrderLogDAO(PsOrderLogDAO psOrderLogDAO) {
//		this.psOrderLogDAO = psOrderLogDAO;
//	}
	
}
