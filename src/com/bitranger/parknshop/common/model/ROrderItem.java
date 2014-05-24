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
package com.bitranger.parknshop.common.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bitranger.parknshop.seller.model.PsOrder;

/**
 * ROrderItem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "r_order_item", catalog = "c1_parknshop")
public class ROrderItem implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3025193995178003078L;
	private ROrderItemId id;
	private PsItem psItem;
	private PsOrder psOrder;
	private Integer quantity;
	private String extra1;
	private String extra2;

	// Constructors

	/** default constructor */
	public ROrderItem() {
	}

	/** minimal constructor */
	public ROrderItem(ROrderItemId id, PsItem psItem, PsOrder psOrder,
			Integer quantity) {
		this.id = id;
		this.psItem = psItem;
		this.psOrder = psOrder;
		this.quantity = quantity;
	}

	/** full constructor */
	public ROrderItem(ROrderItemId id, PsItem psItem, PsOrder psOrder,
			Integer quantity, String extra1, String extra2) {
		this.id = id;
		this.psItem = psItem;
		this.psOrder = psOrder;
		this.quantity = quantity;
		this.extra1 = extra1;
		this.extra2 = extra2;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idItem", column = @Column(name = "id_item", nullable = false)),
			@AttributeOverride(name = "idOrder", column = @Column(name = "id_order", nullable = false)) })
	public ROrderItemId getId() {
		return this.id;
	}

	public void setId(ROrderItemId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_item", nullable = false, insertable = false, updatable = false)
	public PsItem getPsItem() {
		return this.psItem;
	}

	public void setPsItem(PsItem psItem) {
		this.psItem = psItem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_order", nullable = false, insertable = false, updatable = false)
	public PsOrder getPsOrder() {
		return this.psOrder;
	}

	public void setPsOrder(PsOrder psOrder) {
		this.psOrder = psOrder;
	}

	@Column(name = "quantitiy", nullable = false)
	public Integer getQuantitiy() {
		return this.quantity;
	}

	public void setQuantitiy(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name = "extra_1", length = 120)
	public String getExtra1() {
		return this.extra1;
	}

	public void setExtra1(String extra1) {
		this.extra1 = extra1;
	}

	@Column(name = "extra_2", length = 120)
	public String getExtra2() {
		return this.extra2;
	}

	public void setExtra2(String extra2) {
		this.extra2 = extra2;
	}

}
