package com.bitranger.parknshop.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PsItemInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_item_info", catalog = "c1_parknshop")
public class PsItemInfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private PsItem psItem;
	private String description;
	private String urlPic;

	// Constructors

	/** default constructor */
	public PsItemInfo() {
	}

	/** minimal constructor */
	public PsItemInfo(Integer id, PsItem psItem) {
		this.id = id;
		this.psItem = psItem;
	}

	/** full constructor */
	public PsItemInfo(Integer id, PsItem psItem, String description,
			String urlPic) {
		this.id = id;
		this.psItem = psItem;
		this.description = description;
		this.urlPic = urlPic;
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
	@JoinColumn(name = "id_item", nullable = false)
	public PsItem getPsItem() {
		return this.psItem;
	}

	public void setPsItem(PsItem psItem) {
		this.psItem = psItem;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "url_pic", length = 65535)
	public String getUrlPic() {
		return this.urlPic;
	}

	public void setUrlPic(String urlPic) {
		this.urlPic = urlPic;
	}

}