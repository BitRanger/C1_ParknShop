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
package com.bitranger.parknshop.seller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bitranger.parknshop.buyer.model.PsCustomer;


/**
 * PsRecipient entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_recipient", catalog = "c1_parknshop")
public class PsRecipient implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -6623732588341787931L;
	private Integer id;
	private PsCustomer psCustomer;
	private String nameRecipient;
	private String addresss;
	private String postalCode;
	private String phoneNumber;

	// Constructors

	/** default constructor */
	public PsRecipient() {
	}

	/** full constructor */
	public PsRecipient(PsCustomer psCustomer, String nameRecipient,
			String addresss, String postalCode, String phoneNumber) {
		this.psCustomer = psCustomer;
		this.nameRecipient = nameRecipient;
		this.addresss = addresss;
		this.postalCode = postalCode;
		this.phoneNumber = phoneNumber;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_customer", nullable = false)
	public PsCustomer getPsCustomer() {
		return this.psCustomer;
	}

	public void setPsCustomer(PsCustomer psCustomer) {
		this.psCustomer = psCustomer;
	}

	@Column(name = "name_recipient", nullable = false, length = 45)
	public String getNameRecipient() {
		return this.nameRecipient;
	}

	public void setNameRecipient(String nameRecipient) {
		this.nameRecipient = nameRecipient;
	}

	@Column(name = "addresss", nullable = false, length = 100)
	public String getAddresss() {
		return this.addresss;
	}

	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}

	@Column(name = "postal_code", nullable = false, length = 20)
	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Column(name = "phone_number", nullable = false, length = 45)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
