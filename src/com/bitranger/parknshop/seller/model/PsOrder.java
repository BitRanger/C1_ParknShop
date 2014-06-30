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

import com.bitranger.parknshop.buyer.model.PsCustomer;
import com.bitranger.parknshop.common.model.ROrderItem;

/**
 * PsOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_order", catalog = "c1_parknshop")
public class PsOrder implements java.io.Serializable {

	// Fields

	private Integer id;
	private PsRecipient psRecipient;
	private PsCustomer psCustomer;
	private PsShop psShop;
	private Short status;
	private String trackingNumber;
	private Double priceTotal;
	private Timestamp timeCreated;
	private Timestamp timePaid;
	private Timestamp timeBeginDeliver;
	private Timestamp timeFinished;
	private Set<ROrderItem> ROrderItems = new HashSet<ROrderItem>(0);

	// Constructors

	/** default constructor */
	public PsOrder() {
	}

	/** minimal constructor */
	public PsOrder(PsRecipient psRecipient, PsCustomer psCustomer,
			PsShop psShop, Short status, Double priceTotal,
			Timestamp timeCreated) {
		this.psRecipient = psRecipient;
		this.psCustomer = psCustomer;
		this.psShop = psShop;
		this.status = status;
		this.priceTotal = priceTotal;
		this.timeCreated = timeCreated;
	}

	/** full constructor */
	public PsOrder(PsRecipient psRecipient, PsCustomer psCustomer,
			PsShop psShop, Short status, String trackingNumber,
			Double priceTotal, Timestamp timeCreated,
			Set<ROrderItem> ROrderItems) {
		this.psRecipient = psRecipient;
		this.psCustomer = psCustomer;
		this.psShop = psShop;
		this.status = status;
		this.trackingNumber = trackingNumber;
		this.priceTotal = priceTotal;
		this.timeCreated = timeCreated;
		this.ROrderItems = ROrderItems;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_recip_addr", nullable = false)
	public PsRecipient getPsRecipient() {
		return this.psRecipient;
	}

	public void setPsRecipient(PsRecipient psRecipient) {
		this.psRecipient = psRecipient;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_customer", nullable = false)
	public PsCustomer getPsCustomer() {
		return this.psCustomer;
	}

	public void setPsCustomer(PsCustomer psCustomer) {
		this.psCustomer = psCustomer;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_shop", nullable = false)
	public PsShop getPsShop() {
		return this.psShop;
	}

	public void setPsShop(PsShop psShop) {
		this.psShop = psShop;
	}

	@Column(name = "status", nullable = false)
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "tracking_number", length = 65535)
	public String getTrackingNumber() {
		return this.trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	@Column(name = "price_total", nullable = false, precision = 15)
	public Double getPriceTotal() {
		return this.priceTotal;
	}

	public void setPriceTotal(Double priceTotal) {
		this.priceTotal = priceTotal;
	}

	@Column(name = "time_created", nullable = false, length = 19)
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "psOrder")
	public Set<ROrderItem> getROrderItems() {
		return this.ROrderItems;
	}

	public void setROrderItems(Set<ROrderItem> ROrderItems) {
		this.ROrderItems = ROrderItems;
	}
	
	@Column(name = "time_paid", nullable = true, length = 19)
	public Timestamp getTimePaid() {
		return timePaid;
	}

	public void setTimePaid(Timestamp timePaid) {
		this.timePaid = timePaid;
	}

	@Column(name = "time_begindeliver", nullable = true, length = 19)
	public Timestamp getTimeBeginDeliver() {
		return timeBeginDeliver;
	}

	public void setTimeBeginDeliver(Timestamp timeBeginDeliver) {
		this.timeBeginDeliver = timeBeginDeliver;
	}

	@Column(name = "time_finished", nullable = true, length = 19)
	public Timestamp getTimeFinished() {
		return timeFinished;
	}

	public void setTimeFinished(Timestamp timeFinished) {
		this.timeFinished = timeFinished;
	}
}
