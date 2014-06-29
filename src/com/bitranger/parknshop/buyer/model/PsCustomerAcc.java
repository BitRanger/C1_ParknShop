package com.bitranger.parknshop.buyer.model;

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
 * PsCustomerAcc entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_customer_acc", catalog = "c1_parknshop")
public class PsCustomerAcc implements java.io.Serializable {

	// Fields

	private Integer id;
	private PsCustomer psCustomer;
	private Timestamp timeCreated;
	private Double amount;

	// Constructors

	/** default constructor */
	public PsCustomerAcc() {
	}

	/** full constructor */
	public PsCustomerAcc(PsCustomer psCustomer, Timestamp timeCreated,
			Double amount) {
		this.psCustomer = psCustomer;
		this.timeCreated = timeCreated;
		this.amount = amount;
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
	@JoinColumn(name = "id_customer", nullable = false)
	public PsCustomer getPsCustomer() {
		return this.psCustomer;
	}

	public void setPsCustomer(PsCustomer psCustomer) {
		this.psCustomer = psCustomer;
	}

	@Column(name = "time_created", nullable = false, length = 19)
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

	@Column(name = "amount", nullable = false, precision = 9)
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}