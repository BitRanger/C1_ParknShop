package com.bitranger.parknshop.seller.model;

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
 * PsSellerAcc entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_seller_acc", catalog = "c1_parknshop")
public class PsSellerAcc implements java.io.Serializable {

	// Fields

	private Integer id;
	private PsSeller psSeller;
	private PsOrderLog psOrderLog;
	private Timestamp timeCreated;
	private Double amount;

	// Constructors

	/** default constructor */
	public PsSellerAcc() {
	}

	/** full constructor */
	public PsSellerAcc(PsSeller psSeller, PsOrderLog psOrderLog,
			Timestamp timeCreated, Double amount) {
		this.psSeller = psSeller;
		this.psOrderLog = psOrderLog;
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
	@JoinColumn(name = "id_seller", nullable = false)
	public PsSeller getPsSeller() {
		return this.psSeller;
	}

	public void setPsSeller(PsSeller psSeller) {
		this.psSeller = psSeller;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_order_log", nullable = false)
	public PsOrderLog getPsOrderLog() {
		return this.psOrderLog;
	}

	public void setPsOrderLog(PsOrderLog psOrderLog) {
		this.psOrderLog = psOrderLog;
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