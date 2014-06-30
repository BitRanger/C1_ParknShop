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
package com.bitranger.parknshop.buyer.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CartCustomerItemId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class CartCustomerItemId implements java.io.Serializable {

	private static final long serialVersionUID = -1410063537205251303L;
	// Fields

	private Integer idCustomer;
	private Integer idItem;

	// Constructors

	/** default constructor */
	public CartCustomerItemId() {
	}

	/** full constructor */
	public CartCustomerItemId(Integer idCustomer, Integer idItem) {
		this.idCustomer = idCustomer;
		this.idItem = idItem;
	}

	// Property accessors

	@Column(name = "id_customer", nullable = false)
	public Integer getIdCustomer() {
		return this.idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	@Column(name = "id_item", nullable = false)
	public Integer getIdItem() {
		return this.idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CartCustomerItemId))
			return false;
		CartCustomerItemId castOther = (CartCustomerItemId) other;

		return ((this.getIdCustomer() == castOther.getIdCustomer()) || (this
				.getIdCustomer() != null && castOther.getIdCustomer() != null && this
				.getIdCustomer().equals(castOther.getIdCustomer())))
				&& ((this.getIdItem() == castOther.getIdItem()) || (this
						.getIdItem() != null && castOther.getIdItem() != null && this
						.getIdItem().equals(castOther.getIdItem())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getIdCustomer() == null ? 0 : this.getIdCustomer()
						.hashCode());
		result = 37 * result
				+ (getIdItem() == null ? 0 : this.getIdItem().hashCode());
		return result;
	}

}
