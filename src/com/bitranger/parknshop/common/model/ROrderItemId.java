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
package com.bitranger.parknshop.common.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ROrderItemId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class ROrderItemId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -957261655329848045L;
	private Integer idItem;
	private Integer idOrder;

	// Constructors

	/** default constructor */
	public ROrderItemId() {
	}

	/** full constructor */
	public ROrderItemId(Integer idItem, Integer idOrder) {
		this.idItem = idItem;
		this.idOrder = idOrder;
	}

	// Property accessors

	@Column(name = "id_item", nullable = false)
	public Integer getIdItem() {
		return this.idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	@Column(name = "id_order", nullable = false)
	public Integer getIdOrder() {
		return this.idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ROrderItemId))
			return false;
		ROrderItemId castOther = (ROrderItemId) other;

		return ((this.getIdItem() == castOther.getIdItem()) || (this
				.getIdItem() != null && castOther.getIdItem() != null && this
				.getIdItem().equals(castOther.getIdItem())))
				&& ((this.getIdOrder() == castOther.getIdOrder()) || (this
						.getIdOrder() != null && castOther.getIdOrder() != null && this
						.getIdOrder().equals(castOther.getIdOrder())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getIdItem() == null ? 0 : this.getIdItem().hashCode());
		result = 37 * result
				+ (getIdOrder() == null ? 0 : this.getIdOrder().hashCode());
		return result;
	}

}
