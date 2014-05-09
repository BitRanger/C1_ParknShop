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
package com.bitranger.parknshop.buyer.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bitranger.parknshop.common.model.PsItem;

/**
 * CartCustomerItem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cart_customer_item", catalog = "c1_parknshop")
public class CartCustomerItem implements java.io.Serializable {

	private static final long serialVersionUID = 2446583376142994050L;
	// Fields

	private CartCustomerItemId id;

	private PsItem psItem;
	private PsCustomer psCustomer;
	private Integer quantity;
	private String extra1;
	private String extra2;

	// Constructors

	/** default constructor */
	public CartCustomerItem() {
	}

	/** minimal constructor */
	public CartCustomerItem(CartCustomerItemId id, PsItem psItem,
			PsCustomer psCustomer, Integer quantity) {
		this.id = id;
		this.psItem = psItem;
		this.psCustomer = psCustomer;
		this.quantity = quantity;
	}

	/** full constructor */
	public CartCustomerItem(CartCustomerItemId id, PsItem psItem,
			PsCustomer psCustomer, Integer quantity, String extra1,
			String extra2) {
		this.id = id;
		this.psItem = psItem;
		this.psCustomer = psCustomer;
		this.quantity = quantity;
		this.extra1 = extra1;
		this.extra2 = extra2;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idCustomer", column = @Column(name = "id_customer", nullable = false)),
			@AttributeOverride(name = "idItem", column = @Column(name = "id_item", nullable = false)) })
	public CartCustomerItemId getId() {
		return this.id;
	}

	public void setId(CartCustomerItemId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_item", nullable = false, insertable = false, updatable = false)
	public PsItem getPsItem() {
		return this.psItem;
	}

	public void setPsItem(PsItem psItem) {
		this.psItem = psItem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_customer", nullable = false, insertable = false, updatable = false)
	public PsCustomer getPsCustomer() {
		return this.psCustomer;
	}

	public void setPsCustomer(PsCustomer psCustomer) {
		this.psCustomer = psCustomer;
	}

	@Column(name = "quantity", nullable = false)
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CartCustomerItem)) {
			return false;
		}
		CartCustomerItem other = (CartCustomerItem) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
