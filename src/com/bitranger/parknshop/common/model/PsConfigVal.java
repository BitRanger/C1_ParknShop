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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PsConfigVal entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_config_val", catalog = "c1_parknshop")
public class PsConfigVal implements java.io.Serializable {

	// Fields

	private Integer id;
	private PsConfigKey psConfigKey;
	private String val;

	// Constructors

	/** default constructor */
	public PsConfigVal() {
	}

	/** minimal constructor */
	public PsConfigVal(PsConfigKey psConfigKey) {
		this.psConfigKey = psConfigKey;
	}

	/** full constructor */
	public PsConfigVal(PsConfigKey psConfigKey, String val) {
		this.psConfigKey = psConfigKey;
		this.val = val;
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
	@JoinColumn(name = "id_key", nullable = false)
	public PsConfigKey getPsConfigKey() {
		return this.psConfigKey;
	}

	public void setPsConfigKey(PsConfigKey psConfigKey) {
		this.psConfigKey = psConfigKey;
	}

	@Column(name = "val", length = 65535)
	public String getVal() {
		return this.val;
	}

	public void setVal(String val) {
		this.val = val;
	}

}
