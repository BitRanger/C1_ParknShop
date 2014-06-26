package com.bitranger.parknshop.common.model;

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

import com.bitranger.parknshop.buyer.model.PsCustomer;

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
	private Integer scoreItem;
	private Integer scoreShop;
	private String content;
	private Timestamp timeCreated;

	// Constructors

	/** default constructor */
	public PsComment() {
	}

	/** minimal constructor */
	public PsComment(PsItem psItem, PsCustomer psCustomer, Integer scoreItem,
			Integer scoreShop) {
		this.psItem = psItem;
		this.psCustomer = psCustomer;
		this.scoreItem = scoreItem;
		this.scoreShop = scoreShop;
	}

	/** full constructor */
	public PsComment(PsItem psItem, PsCustomer psCustomer, Integer scoreItem,
			Integer scoreShop, String content, Timestamp timeCreated) {
		this.psItem = psItem;
		this.psCustomer = psCustomer;
		this.scoreItem = scoreItem;
		this.scoreShop = scoreShop;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_item", nullable = false)
	public PsItem getPsItem() {
		return this.psItem;
	}

	public void setPsItem(PsItem psItem) {
		this.psItem = psItem;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_customer", nullable = false)
	public PsCustomer getPsCustomer() {
		return this.psCustomer;
	}

	public void setPsCustomer(PsCustomer psCustomer) {
		this.psCustomer = psCustomer;
	}

	@Column(name = "score_item", nullable = false)
	public Integer getScoreItem() {
		return this.scoreItem;
	}

	public void setScoreItem(Integer scoreItem) {
		this.scoreItem = scoreItem;
	}

	@Column(name = "score_shop", nullable = false)
	public Integer getScoreShop() {
		return this.scoreShop;
	}

	public void setScoreShop(Integer scoreShop) {
		this.scoreShop = scoreShop;
	}

	@Column(name = "content", length = 65535)
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