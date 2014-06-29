package com.bitranger.parknshop.common.ads;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PsItemPromotInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_item_promot_info", catalog = "c1_parknshop")
public class PsItemPromotInfo implements java.io.Serializable {

	// Fields

	private PsItemPromotInfoId id;
	private PsPromotItem psPromotItem;
	private String key;
	private String value;

	// Constructors

	/** default constructor */
	public PsItemPromotInfo() {
	}

	/** minimal constructor */
	public PsItemPromotInfo(PsItemPromotInfoId id, PsPromotItem psPromotItem) {
		this.id = id;
		this.psPromotItem = psPromotItem;
	}

	/** full constructor */
	public PsItemPromotInfo(PsItemPromotInfoId id, PsPromotItem psPromotItem,
			String key, String value) {
		this.id = id;
		this.psPromotItem = psPromotItem;
		this.key = key;
		this.value = value;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
			@AttributeOverride(name = "idPromt", column = @Column(name = "id_promt", nullable = false)) })
	public PsItemPromotInfoId getId() {
		return this.id;
	}

	public void setId(PsItemPromotInfoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_promt", nullable = false, insertable = false, updatable = false)
	public PsPromotItem getPsPromotItem() {
		return this.psPromotItem;
	}

	public void setPsPromotItem(PsPromotItem psPromotItem) {
		this.psPromotItem = psPromotItem;
	}

	@Column(name = "key", length = 65535)
	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Column(name = "value", length = 65535)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}