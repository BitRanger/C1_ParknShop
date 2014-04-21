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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PsSeller entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_seller", catalog = "c1_parknshop")
public class PsSeller implements java.io.Serializable {

	// Fields

	private Integer id;
	private String nickname;
	private String personIdNum;
	private String email;
	private String password;
	private Short status;
	private Timestamp timeCreated;
	private Set<PsShop> psShops = new HashSet<PsShop>(0);

	// Constructors

	/** default constructor */
	public PsSeller() {
	}

	/** minimal constructor */
	public PsSeller(String nickname, String personIdNum, String password,
			Timestamp timeCreated) {
		this.nickname = nickname;
		this.personIdNum = personIdNum;
		this.password = password;
		this.timeCreated = timeCreated;
	}

	/** full constructor */
	public PsSeller(String nickname, String personIdNum, String email,
			String password, Short status, Timestamp timeCreated,
			Set<PsShop> psShops) {
		this.nickname = nickname;
		this.personIdNum = personIdNum;
		this.email = email;
		this.password = password;
		this.status = status;
		this.timeCreated = timeCreated;
		this.psShops = psShops;
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

	@Column(name = "nickname", nullable = false, length = 45)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "person_id_num", nullable = false, length = 45)
	public String getPersonIdNum() {
		return this.personIdNum;
	}

	public void setPersonIdNum(String personIdNum) {
		this.personIdNum = personIdNum;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "status")
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "time_created", nullable = false, length = 19)
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "psSeller")
	public Set<PsShop> getPsShops() {
		return this.psShops;
	}

	public void setPsShops(Set<PsShop> psShops) {
		this.psShops = psShops;
	}

}
