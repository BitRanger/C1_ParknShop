package com.bitranger.parknshop.admin.data;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * PsAdminAcc entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_admin_acc", catalog = "c1_parknshop")
public class PsAdminAcc implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 898021265546066983L;
	private Integer idAdmin;
	private PsAdministrator psAdministrator;
	private Double balance;
	private Timestamp timeCreated;

	// Constructors

	/** default constructor */
	public PsAdminAcc() {
	}

	/** full constructor */
	public PsAdminAcc(Integer idAdmin, PsAdministrator psAdministrator,
			Double balance, Timestamp timeCreated) {
		this.idAdmin = idAdmin;
		this.psAdministrator = psAdministrator;
		this.balance = balance;
		this.timeCreated = timeCreated;
	}

	// Property accessors
	@Id
	@Column(name = "id_admin", unique = true, nullable = false)
	public Integer getIdAdmin() {
		return this.idAdmin;
	}

	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	public PsAdministrator getPsAdministrator() {
		return this.psAdministrator;
	}

	public void setPsAdministrator(PsAdministrator psAdministrator) {
		this.psAdministrator = psAdministrator;
	}

	@Column(name = "balance", nullable = false, precision = 9)
	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Column(name = "time_created", nullable = false, length = 19)
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

}