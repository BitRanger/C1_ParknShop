package com.bitranger.parknshop.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PsAdministator entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_administator", catalog = "c1_parknshop")
public class PsAdministator implements java.io.Serializable {

	// Fields

	private Integer id;
	private String email;
	private String name;
	private String password;
	private Timestamp timeCreated;

	// Constructors

	/** default constructor */
	public PsAdministator() {
	}

	/** full constructor */
	public PsAdministator(String email, String name, String password,
			Timestamp timeCreated) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.timeCreated = timeCreated;
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

	@Column(name = "email", nullable = false, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "time_created", nullable = false, length = 19)
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

}