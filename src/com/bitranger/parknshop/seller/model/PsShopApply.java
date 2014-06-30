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
package com.bitranger.parknshop.seller.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bitranger.parknshop.util.Str;

/**
 * PsShopApply entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_shop_apply", catalog = "c1_parknshop")
public class PsShopApply implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6329773371014766023L;
	private Integer id;
	private Integer idSeller;
	private String message;
	private Short approved;
	private Short isValid;
	private Timestamp timeCreated;

	// Constructors

	/** default constructor */
	public PsShopApply() {
	}

	/** minimal constructor */
	public PsShopApply(Integer idSeller, String message) {
		this.idSeller = idSeller;
		this.message = message;
	}

	/** full constructor */
	public PsShopApply(Integer idSeller, String message, Short approved,
			Short isValid, Timestamp timeCreated) {
		this.idSeller = idSeller;
		this.message = message;
		this.approved = approved;
		this.isValid = isValid;
		this.timeCreated = timeCreated;
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

	@Column(name = "id_seller", nullable = false)
	public Integer getIdSeller() {
		return this.idSeller;
	}

	public void setIdSeller(Integer idSeller) {
		this.idSeller = idSeller;
	}

	@Column(name = "message", nullable = false)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "approved")
	public Short getApproved() {
		return this.approved;
	}

	public void setApproved(Short approved) {
		this.approved = approved;
	}

	@Column(name = "is_valid")
	public Short getIsValid() {
		return this.isValid;
	}

	public void setIsValid(Short isValid) {
		this.isValid = isValid;
	}

	@Column(name = "time_created", length = 19)
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

}
