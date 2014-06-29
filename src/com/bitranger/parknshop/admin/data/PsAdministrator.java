package com.bitranger.parknshop.admin.data;

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
 * PsAdministrator entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_administrator", catalog = "c1_parknshop")
public class PsAdministrator implements java.io.Serializable {

	// Fields

	private Integer id;
	private String email;
	private String name;
	private String password;
	private Timestamp timeCreated;
	private Double psAdministatorcol;
	private Double balance;
	private Set<PsNoticeAdmin> psNoticeAdmins = new HashSet<PsNoticeAdmin>(0);
	// Constructors

	/** default constructor */
	public PsAdministrator() {
	}

	/** minimal constructor */
	public PsAdministrator(String email, String name, String password,
			Timestamp timeCreated) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.timeCreated = timeCreated;
	}

	/** full constructor */
	public PsAdministrator(String email, String name, String password,
			Timestamp timeCreated, Double psAdministatorcol, Double balance,
			Set<PsNoticeAdmin> psNoticeAdmins) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.timeCreated = timeCreated;
		this.psAdministatorcol = psAdministatorcol;
		this.balance = balance;
		this.psNoticeAdmins = psNoticeAdmins;
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

	@Column(name = "ps_administatorcol", precision = 9)
	public Double getPsAdministatorcol() {
		return this.psAdministatorcol;
	}

	public void setPsAdministatorcol(Double psAdministatorcol) {
		this.psAdministatorcol = psAdministatorcol;
	}

	@Column(name = "balance", precision = 9)
	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "psAdministrator")
	public Set<PsNoticeAdmin> getPsNoticeAdmins() {
		return this.psNoticeAdmins;
	}

	public void setPsNoticeAdmins(Set<PsNoticeAdmin> psNoticeAdmins) {
		this.psNoticeAdmins = psNoticeAdmins;
	}


}