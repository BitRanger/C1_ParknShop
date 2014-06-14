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

	/**
	 * 
	 */
	private static final long serialVersionUID = -5726230087612097832L;
	private Integer id;
	private PsSeller psSeller;
	private Timestamp timeCreated;
	private Double balance;

	// Constructors

	/** default constructor */
	public PsSellerAcc() {
	}

	/** full constructor */
	public PsSellerAcc(PsSeller psSeller, Timestamp timeCreated, Double balance) {
		this.psSeller = psSeller;
		this.timeCreated = timeCreated;
		this.balance = balance;
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

	@Column(name = "time_created", nullable = false, length = 19)
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

	@Column(name = "balance", nullable = false, precision = 9)
	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}