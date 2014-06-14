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

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bitranger.parknshop.common.model.PsComment;
import com.bitranger.parknshop.common.model.PsItem;
import com.bitranger.parknshop.seller.model.PsOrder;
import com.bitranger.parknshop.seller.model.PsRecipient;

/**
 * PsCustomer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_customer", catalog = "c1_parknshop")
public class PsCustomer implements java.io.Serializable {

	// Fields
	private Integer id;
	private String nickname;
	private String email;
	private String password;
	private Short gender;
	private String name;
	private Date birthday;
	private Timestamp timeCreated;
	private Set<CartCustomerItem> cartCustomerItems = new HashSet<CartCustomerItem>(
			0);
	private Set<PsOrder> psOrders = new HashSet<PsOrder>(0);
	private Set<PsItem> psItems = new HashSet<PsItem>(0);
	private Set<PsRecipient> psRecipients = new HashSet<PsRecipient>(0);
	private Set<PsComment> psComments = new HashSet<PsComment>(0);

	// Constructors

	/** default constructor */
	public PsCustomer() {
	}

	/** minimal constructor */
	public PsCustomer(String nickname, String email, String password,
			Short gender, Timestamp timeCreated) {
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.timeCreated = timeCreated;
	}

	/** full constructor */
	public PsCustomer(String nickname, String email, String password,
			Short gender, String name, Date birthday, Timestamp timeCreated,
			Set<CartCustomerItem> cartCustomerItems, Set<PsOrder> psOrders,
			Set<PsItem> psItems, Set<PsRecipient> psRecipients,
			Set<PsComment> psComments) {
				
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.name = name;
		this.birthday = birthday;
		this.timeCreated = timeCreated;
		this.cartCustomerItems = cartCustomerItems;
		this.psOrders = psOrders;
		this.psItems = psItems;
		this.psRecipients = psRecipients;
		this.psComments = psComments;
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

	@Column(name = "email", nullable = false, length = 45)
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

	@Column(name = "gender", nullable = false)
	public Short getGender() {
		return this.gender;
	}

	public void setGender(Short gender) {
		this.gender = gender;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", length = 10)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "time_created", nullable = false, length = 19)
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "psCustomer")
	public Set<CartCustomerItem> getCartCustomerItems() {
		return this.cartCustomerItems;
	}

	public void setCartCustomerItems(Set<CartCustomerItem> cartCustomerItems) {
		this.cartCustomerItems = cartCustomerItems;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "psCustomer")
	public Set<PsOrder> getPsOrders() {
		return this.psOrders;
	}

	public void setPsOrders(Set<PsOrder> psOrders) {
		this.psOrders = psOrders;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "psCustomers")
	public Set<PsItem> getPsItems() {
		return this.psItems;
	}

	public void setPsItems(Set<PsItem> psItems) {
		this.psItems = psItems;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "psCustomer")
	public Set<PsRecipient> getPsRecipients() {
		return this.psRecipients;
	}

	public void setPsRecipients(Set<PsRecipient> psRecipients) {
		this.psRecipients = psRecipients;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "psCustomer")
	public Set<PsComment> getPsComments() {
		return this.psComments;
	}

	public void setPsComments(Set<PsComment> psComments) {
		this.psComments = psComments;
	}

}
