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

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bitranger.parknshop.common.model.PsItem;

/**
 * PsShop entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_shop", catalog = "c1_parknshop")
public class PsShop implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = -8591005934559485070L;
	private Integer id;
	private PsSeller psSeller;
	private String name;
	private Short status;
	private String introduction;
	private Timestamp timeCreated = new Timestamp(System.currentTimeMillis());;
	private Double vote;
	private Set<PsItem> psItems = new HashSet<PsItem>(0);

	// Constructors

	/** default constructor */
	public PsShop() {
	}

	/** minimal constructor */
	public PsShop(PsSeller psSeller, String name, Short status) {
		this.psSeller = psSeller;
		this.name = name;
		this.status = status;
	}

	/** full constructor */
	public PsShop(PsSeller psSeller, String name, Short status,
			String introduction, Timestamp timeCreated, Double vote,
			Set<PsItem> psItems) {
		this.psSeller = psSeller;
		this.name = name;
		this.status = status;
		this.introduction = introduction;
		this.timeCreated = timeCreated;
		this.vote = vote;
		this.psItems = psItems;
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
	@JoinColumn(name = "id_seller", nullable = false)
	public PsSeller getPsSeller() {
		return this.psSeller;
	}

	public void setPsSeller(PsSeller psSeller) {
		this.psSeller = psSeller;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "status", nullable = false)
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "introduction", length = 200)
	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Column(name = "time_created", nullable = false, length = 19)
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

	@Column(name = "vote", precision = 22, scale = 0)
	public Double getVote() {
		return this.vote;
	}

	public void setVote(Double vote) {
		this.vote = vote;
	}

	@OneToMany(cascade = CascadeType.ALL, 
				fetch = FetchType.EAGER, 
				mappedBy = "psShop")
	public Set<PsItem> getPsItems() {
		return this.psItems;
	}

	public void setPsItems(Set<PsItem> psItems) {
		this.psItems = psItems;
	}

}
