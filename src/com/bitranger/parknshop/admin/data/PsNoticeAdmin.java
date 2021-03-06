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
package com.bitranger.parknshop.admin.data;

import java.sql.Timestamp;
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
 * PsNoticeAdmin entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_notice_admin", catalog = "c1_parknshop")
public class PsNoticeAdmin implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5648796209275448763L;
	private Integer id;
	private PsAdministrator psAdministrator;
	private Timestamp timeCreated;
	private String message;
	private String source = "SYSTEM";
	private Short isValid;

	// Constructors

	/** default constructor */
	public PsNoticeAdmin() {
	}

	/** minimal constructor */
	public PsNoticeAdmin(PsAdministrator psAdministrator, Timestamp timeCreated) {
		this.psAdministrator = psAdministrator;
		this.timeCreated = timeCreated;
	}

	/** full constructor */
	public PsNoticeAdmin(PsAdministrator psAdministrator,
			Timestamp timeCreated, String message, String source, Short isValid) {
		this.psAdministrator = psAdministrator;
		this.timeCreated = timeCreated;
		this.message = message;
		this.source = source;
		this.isValid = isValid;
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
	@JoinColumn(name = "id_admin", nullable = false)
	public PsAdministrator getPsAdministrator() {
		return this.psAdministrator;
	}

	public void setPsAdministrator(PsAdministrator psAdministrator) {
		this.psAdministrator = psAdministrator;
	}

	@Column(name = "time_created", nullable = false, length = 19)
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

	@Column(name = "message", length = 65535)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "source")
	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Column(name = "is_valid")
	public Short getIsValid() {
		return this.isValid;
	}

	public void setIsValid(Short isValid) {
		this.isValid = isValid;
	}

}
