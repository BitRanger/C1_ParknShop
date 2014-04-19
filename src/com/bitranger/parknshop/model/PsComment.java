package com.bitranger.parknshop.model;

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
 * PsComment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_comment", catalog = "c1_parknshop")
public class PsComment implements java.io.Serializable {

	// Fields

	private Integer id;
	private PsItem psItem;
	private PsCustomer psCustomer;
	private Short score;
	private String content;
	private Timestamp timeCreated;

	// Constructors

	/** default constructor */
	public PsComment() {
	}

	/** minimal constructor */
	public PsComment(PsItem psItem, PsCustomer psCustomer) {
		this.psItem = psItem;
		this.psCustomer = psCustomer;
	}

	/** full constructor */
	public PsComment(PsItem psItem, PsCustomer psCustomer, Short score,
			String content, Timestamp timeCreated) {
		this.psItem = psItem;
		this.psCustomer = psCustomer;
		this.score = score;
		this.content = content;
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
	@JoinColumn(name = "id_item", nullable = false)
	public PsItem getPsItem() {
		return this.psItem;
	}

	public void setPsItem(PsItem psItem) {
		this.psItem = psItem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_customer", nullable = false)
	public PsCustomer getPsCustomer() {
		return this.psCustomer;
	}

	public void setPsCustomer(PsCustomer psCustomer) {
		this.psCustomer = psCustomer;
	}

	@Column(name = "score")
	public Short getScore() {
		return this.score;
	}

	public void setScore(Short score) {
		this.score = score;
	}

	@Column(name = "content", length = 45)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "time_created", length = 19)
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

}