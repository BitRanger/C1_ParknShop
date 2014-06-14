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
 * PsOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_order", catalog = "c1_parknshop")
public class PsOrder implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 6373864068325376498L;
	private Integer id;
	private PsRecipient psRecipient;
	private Integer idCustomer;
	private Integer idShop;
	private Short status;
	private String trackingNumber;
	private Double priceTotal;
	private Timestamp timeCreated;

	// Constructors

	/** default constructor */
	public PsOrder() {
	}

	/** minimal constructor */
	public PsOrder(PsRecipient psRecipient, Integer idCustomer, Integer idShop,
			Short status, Double priceTotal, Timestamp timeCreated) {
		this.psRecipient = psRecipient;
		this.idCustomer = idCustomer;
		this.idShop = idShop;
		this.status = status;
		this.priceTotal = priceTotal;
		this.timeCreated = timeCreated;
	}

	/** full constructor */
	public PsOrder(PsRecipient psRecipient, Integer idCustomer, Integer idShop,
			Short status, String trackingNumber, Double priceTotal,
			Timestamp timeCreated) {
		this.psRecipient = psRecipient;
		this.idCustomer = idCustomer;
		this.idShop = idShop;
		this.status = status;
		this.trackingNumber = trackingNumber;
		this.priceTotal = priceTotal;
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
	@JoinColumn(name = "id_recip_addr", nullable = false)
	public PsRecipient getPsRecipient() {
		return this.psRecipient;
	}

	public void setPsRecipient(PsRecipient psRecipient) {
		this.psRecipient = psRecipient;
	}

	@Column(name = "id_customer", nullable = false)
	public Integer getIdCustomer() {
		return this.idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	@Column(name = "id_shop", nullable = false)
	public Integer getIdShop() {
		return this.idShop;
	}

	public void setIdShop(Integer idShop) {
		this.idShop = idShop;
	}

	@Column(name = "status", nullable = false)
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "tracking_number", length = 65535)
	public String getTrackingNumber() {
		return this.trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	@Column(name = "price_total", nullable = false, precision = 15)
	public Double getPriceTotal() {
		return this.priceTotal;
	}

	public void setPriceTotal(Double priceTotal) {
		this.priceTotal = priceTotal;
	}

	@Column(name = "time_created", nullable = false, length = 19)
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

}