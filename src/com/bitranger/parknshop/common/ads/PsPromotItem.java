package com.bitranger.parknshop.common.ads;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bitranger.parknshop.common.model.PsItem;

/**
 * PsPromotItem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_promot_item", catalog = "c1_parknshop")
public class PsPromotItem implements java.io.Serializable {

	// Fields

	private Integer id;
	private PsItem psItem;
	private Timestamp timeCreated;
	private String itemInfo;
	private String description;
	private String picUrl;
	private Set<PsItemPromotInfo> psItemPromotInfos = new HashSet<PsItemPromotInfo>(
			0);
	private PsAdItem psAdItem;

	// Constructors

	/** default constructor */
	public PsPromotItem() {
	}

	/** minimal constructor */
	public PsPromotItem(PsItem psItem, Timestamp timeCreated) {
		this.psItem = psItem;
		this.timeCreated = timeCreated;
	}

	/** full constructor */
<<<<<<< HEAD
	public PsPromotItem(PsItem psItem, Timestamp timeCreated, String itemInfo,
			String description, String picUrl,
			Set<PsItemPromotInfo> psItemPromotInfos, PsAdItem psAdItem) {
=======
	public PsPromotItem(Integer id, PsItem psItem, Timestamp timeCreated,
			String itemInfo, String description, String picUrl,
			Set<PsItemPromotInfo> psItemPromotInfos, PsAdItem psAdItem) {
		this.id = id;
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
		this.psItem = psItem;
		this.timeCreated = timeCreated;
		this.itemInfo = itemInfo;
		this.description = description;
		this.picUrl = picUrl;
		this.psItemPromotInfos = psItemPromotInfos;
		this.psAdItem = psAdItem;
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

	@Column(name = "time_created", nullable = false, length = 19)
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

	@Column(name = "item_info", length = 65535)
	public String getItemInfo() {
		return this.itemInfo;
	}

	public void setItemInfo(String itemInfo) {
		this.itemInfo = itemInfo;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "pic_url")
	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "psPromotItem")
	public Set<PsItemPromotInfo> getPsItemPromotInfos() {
		return this.psItemPromotInfos;
	}

	public void setPsItemPromotInfos(Set<PsItemPromotInfo> psItemPromotInfos) {
		this.psItemPromotInfos = psItemPromotInfos;
	}

<<<<<<< HEAD
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "psPromotItem")
=======
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "psPromotItem")
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
	public PsAdItem getPsAdItem() {
		return this.psAdItem;
	}

	public void setPsAdItem(PsAdItem psAdItem) {
		this.psAdItem = psAdItem;
	}

}