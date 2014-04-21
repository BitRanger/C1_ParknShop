package com.bitranger.parknshop.model;

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
 * PsRecipient entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_recipient", catalog = "c1_parknshop")
public class PsRecipient implements java.io.Serializable {

	// Fields

	private Integer id;
	private PsCustomer psCustomer;
	private String nameRecipient;
	private String addresss;
	private String postalCode;
	private String phoneNumber;

	// Constructors

	/** default constructor */
	public PsRecipient() {
	}

	/** full constructor */
	public PsRecipient(PsCustomer psCustomer, String nameRecipient,
			String addresss, String postalCode, String phoneNumber) {
		this.psCustomer = psCustomer;
		this.nameRecipient = nameRecipient;
		this.addresss = addresss;
		this.postalCode = postalCode;
		this.phoneNumber = phoneNumber;
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

	@Column(name = "name_recipient", nullable = false, length = 45)
	public String getNameRecipient() {
		return this.nameRecipient;
	}

	public void setNameRecipient(String nameRecipient) {
		this.nameRecipient = nameRecipient;
	}

	@Column(name = "addresss", nullable = false, length = 100)
	public String getAddresss() {
		return this.addresss;
	}

	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}

	@Column(name = "postal_code", nullable = false, length = 20)
	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Column(name = "phone_number", nullable = false, length = 45)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}