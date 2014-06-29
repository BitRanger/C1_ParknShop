package com.bitranger.parknshop.seller.model;

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
 * PsOrderLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_order_log", catalog = "c1_parknshop")
public class PsOrderLog implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4502204941675950239L;
	private Integer id;
	private Integer idRecipAddr;
	private String strAddr;
	private Integer idCustomer;
	private Integer idShop;
	private Short status;
	private String trackingNumber;
	private Double priceTotal;
	private Timestamp timeCreated;
	private Timestamp timePaid;
	private Timestamp timeDelivered;
	private String nameBuyer;
	private String nameShop;

	// Constructors

	/** default constructor */
	public PsOrderLog() {
	}

	/** minimal constructor */
	public PsOrderLog(Integer idRecipAddr, Integer idCustomer, Integer idShop,
			Short status, Double priceTotal, Timestamp timeCreated) {
		this.idRecipAddr = idRecipAddr;
		this.idCustomer = idCustomer;
		this.idShop = idShop;
		this.status = status;
		this.priceTotal = priceTotal;
		this.timeCreated = timeCreated;
	}

	/** full constructor */
	public PsOrderLog(Integer idRecipAddr, String strAddr, Integer idCustomer,
			Integer idShop, Short status, String trackingNumber,
			Double priceTotal, Timestamp timeCreated, Timestamp timePaid,
			Timestamp timeDelivered, String nameBuyer, String nameShop) {
		this.idRecipAddr = idRecipAddr;
		this.strAddr = strAddr;
		this.idCustomer = idCustomer;
		this.idShop = idShop;
		this.status = status;
		this.trackingNumber = trackingNumber;
		this.priceTotal = priceTotal;
		this.timeCreated = timeCreated;
		this.timePaid = timePaid;
		this.timeDelivered = timeDelivered;
		this.nameBuyer = nameBuyer;
		this.nameShop = nameShop;
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

	@Column(name = "id_recip_addr", nullable = false)
	public Integer getIdRecipAddr() {
		return this.idRecipAddr;
	}

	public void setIdRecipAddr(Integer idRecipAddr) {
		this.idRecipAddr = idRecipAddr;
	}

	@Column(name = "str_addr", length = 65535)
	public String getStrAddr() {
		return this.strAddr;
	}

	public void setStrAddr(String strAddr) {
		this.strAddr = strAddr;
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

	@Column(name = "time_paid", length = 19)
	public Timestamp getTimePaid() {
		return this.timePaid;
	}

	public void setTimePaid(Timestamp timePaid) {
		this.timePaid = timePaid;
	}

	@Column(name = "time_delivered", length = 19)
	public Timestamp getTimeDelivered() {
		return this.timeDelivered;
	}

	public void setTimeDelivered(Timestamp timeDelivered) {
		this.timeDelivered = timeDelivered;
	}

	@Column(name = "name_buyer", length = 65535)
	public String getNameBuyer() {
		return this.nameBuyer;
	}

	public void setNameBuyer(String nameBuyer) {
		this.nameBuyer = nameBuyer;
	}

	@Column(name = "name_shop", length = 65535)
	public String getNameShop() {
		return this.nameShop;
	}

	public void setNameShop(String nameShop) {
		this.nameShop = nameShop;
	}

}