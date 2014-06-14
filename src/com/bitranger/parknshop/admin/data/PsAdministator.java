package com.bitranger.parknshop.admin.data;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * PsAdministator entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_administator", catalog = "c1_parknshop")
public class PsAdministator implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 177234981803364623L;
	
	private Integer id;
	private String email;
	private String name;
	private String password;
	private Timestamp timeCreated;
	private PsNoticeAdmin psNoticeAdmin;
	private PsAdminAcc psAdminAcc;

	// Constructors

	/** default constructor */
	public PsAdministator() {
	}

	/** minimal constructor */
	public PsAdministator(String email, String name, String password,
			Timestamp timeCreated) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.timeCreated = timeCreated;
	}

	/** full constructor */
	public PsAdministator(String email, String name, String password,
			Timestamp timeCreated, PsNoticeAdmin psNoticeAdmin,
			PsAdminAcc psAdminAcc) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.timeCreated = timeCreated;
		this.psNoticeAdmin = psNoticeAdmin;
		this.psAdminAcc = psAdminAcc;
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

	@Column(name = "email", nullable = false, length = 65535)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "name", nullable = false, length = 65535)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", nullable = false, length = 65535)
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

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "psAdministator")
	public PsNoticeAdmin getPsNoticeAdmin() {
		return this.psNoticeAdmin;
	}

	public void setPsNoticeAdmin(PsNoticeAdmin psNoticeAdmin) {
		this.psNoticeAdmin = psNoticeAdmin;
	}

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "psAdministator")
	public PsAdminAcc getPsAdminAcc() {
		return this.psAdminAcc;
	}

	public void setPsAdminAcc(PsAdminAcc psAdminAcc) {
		this.psAdminAcc = psAdminAcc;
	}

}