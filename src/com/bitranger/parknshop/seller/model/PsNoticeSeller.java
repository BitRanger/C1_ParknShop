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
 * PsNoticeSeller entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_notice_seller", catalog = "c1_parknshop")
public class PsNoticeSeller implements java.io.Serializable {

	// Fields

	private Integer id;
	private PsSeller psSeller;
	private Timestamp timeCreated;
	private String source;
	private String message;
	private Short isValid;

	// Constructors

	/** default constructor */
	public PsNoticeSeller() {
	}

	/** minimal constructor */
	public PsNoticeSeller(PsSeller psSeller, Timestamp timeCreated,
			Short isValid) {
		this.psSeller = psSeller;
		this.timeCreated = timeCreated;
		this.isValid = isValid;
	}

	/** full constructor */
	public PsNoticeSeller(PsSeller psSeller, Timestamp timeCreated,
			String source, String message, Short isValid) {
		this.psSeller = psSeller;
		this.timeCreated = timeCreated;
		this.source = source;
		this.message = message;
		this.isValid = isValid;
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

	@Column(name = "source")
	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Column(name = "message", length = 65535)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "is_valid", nullable = false)
	public Short getIsValid() {
		return this.isValid;
	}

	public void setIsValid(Short isValid) {
		this.isValid = isValid;
	}

}