package com.bitranger.parknshop.common.ads;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 542651408034196520L;
	private Integer id;
	private PsPromotItem psPromotItem;
	private String key;
	private String value;

	// Constructors

	/** default constructor */
	public PsItemPromotInfo() {
	}

	/** minimal constructor */
	public PsItemPromotInfo(Integer id, PsPromotItem psPromotItem) {
		this.id = id;
		this.psPromotItem = psPromotItem;
	}

	/** full constructor */
	public PsItemPromotInfo(Integer id, PsPromotItem psPromotItem, String key,
			String value) {
		this.id = id;
		this.psPromotItem = psPromotItem;
		this.key = key;
		this.value = value;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_promt", nullable = false)
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