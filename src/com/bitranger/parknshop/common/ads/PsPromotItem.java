package com.bitranger.parknshop.common.ads;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.bitranger.parknshop.common.model.PsItem;

/**
 * PsPromotItem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_promot_item", catalog = "c1_parknshop")
public class PsPromotItem implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4105089983549286039L;
	private Integer id;
	private PsItem psItem;
	private Timestamp timeCreated;
	private String itemInfo;
	private String description;
	private Set<PsItemPromotInfo> psItemPromotInfos = 
			new HashSet<PsItemPromotInfo>(32);
	private Set<PsAdItem> psAdItems = new HashSet<PsAdItem>(16);

	// Constructors


	
	/** default constructor */
	public PsPromotItem() {
	}

	/** minimal constructor */
	public PsPromotItem(Integer id, PsItem psItem, Timestamp timeCreated) {
		this.id = id;
		this.psItem = psItem;
		this.timeCreated = timeCreated;
	}

	/** full constructor */
	public PsPromotItem(Integer id, PsItem psItem, Timestamp timeCreated,
			String itemInfo, String description,
			Set<PsItemPromotInfo> psItemPromotInfos, Set<PsAdItem> psAdItems) {
		this.id = id;
		this.psItem = psItem;
		this.timeCreated = timeCreated;
		this.itemInfo = itemInfo;
		this.description = description;
		this.psItemPromotInfos = psItemPromotInfos;
		this.psAdItems = psAdItems;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "psPromotItem")
	public Set<PsItemPromotInfo> getPsItemPromotInfos() {
		return this.psItemPromotInfos;
	}

	public void setPsItemPromotInfos(Set<PsItemPromotInfo> psItemPromotInfos) {
		this.psItemPromotInfos = psItemPromotInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "psPromotItem")
	public Set<PsAdItem> getPsAdItems() {
		return this.psAdItems;
	}

	public void setPsAdItems(Set<PsAdItem> psAdItems) {
		this.psAdItems = psAdItems;
	}

}