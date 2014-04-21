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
package com.bitranger.parknshop.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PsCategory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_category", catalog = "c1_parknshop")
public class PsCategory implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set<PsItem> psItems = new HashSet<PsItem>(0);

	// Constructors

	/** default constructor */
	public PsCategory() {
	}

	/** minimal constructor */
	public PsCategory(String name) {
		this.name = name;
	}

	/** full constructor */
	public PsCategory(String name, Set<PsItem> psItems) {
		this.name = name;
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

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "psCategory")
	public Set<PsItem> getPsItems() {
		return this.psItems;
	}

	public void setPsItems(Set<PsItem> psItems) {
		this.psItems = psItems;
	}

}
