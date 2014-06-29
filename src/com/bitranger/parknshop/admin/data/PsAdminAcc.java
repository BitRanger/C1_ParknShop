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

import com.bitranger.parknshop.seller.model.PsOrderLog;

/**
 * PsAdminAcc entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_admin_acc", catalog = "c1_parknshop")
public class PsAdminAcc implements java.io.Serializable {

	// Fields

<<<<<<< HEAD
	private Integer id;
	private PsAdministrator psAdministrator;
	private PsOrderLog psOrderLog;
	private Double amount;
=======
	/**
	 * 
	 */
	private static final long serialVersionUID = 898021265546066983L;
	private Integer idAdmin;
	private PsAdministrator psAdministrator;
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
	private Timestamp timeCreated;

	// Constructors

	/** default constructor */
	public PsAdminAcc() {
	}

	/** minimal constructor */
	public PsAdminAcc(PsAdministrator psAdministrator, PsOrderLog psOrderLog,
			Timestamp timeCreated) {
		this.psAdministrator = psAdministrator;
		this.psOrderLog = psOrderLog;
		this.timeCreated = timeCreated;
	}

	/** full constructor */
<<<<<<< HEAD
	public PsAdminAcc(PsAdministrator psAdministrator, PsOrderLog psOrderLog,
			Double amount, Timestamp timeCreated) {
		this.psAdministrator = psAdministrator;
		this.psOrderLog = psOrderLog;
		this.amount = amount;
=======
	public PsAdminAcc(Integer idAdmin, PsAdministrator psAdministrator, Timestamp timeCreated) {
		this.idAdmin = idAdmin;
		this.psAdministrator = psAdministrator;
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_admin", nullable = false)
	public PsAdministrator getPsAdministrator() {
		return this.psAdministrator;
	}

	public void setPsAdministrator(PsAdministrator psAdministrator) {
		this.psAdministrator = psAdministrator;
	}

<<<<<<< HEAD
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_order_log", nullable = false)
	public PsOrderLog getPsOrderLog() {
		return this.psOrderLog;
	}

	public void setPsOrderLog(PsOrderLog psOrderLog) {
		this.psOrderLog = psOrderLog;
	}

	@Column(name = "amount", precision = 9)
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
=======
	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	public PsAdministrator getPsAdministrator() {
		return this.psAdministrator;
	}

	public void setPsAdministrator(PsAdministrator psAdministrator) {
		this.psAdministrator = psAdministrator;
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
	}

	@Column(name = "time_created", nullable = false, length = 19)
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

}