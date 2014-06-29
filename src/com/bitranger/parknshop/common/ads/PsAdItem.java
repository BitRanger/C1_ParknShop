package com.bitranger.parknshop.common.ads;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * PsAdItem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_ad_item", catalog = "c1_parknshop", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class PsAdItem implements java.io.Serializable {

	// Fields

	private Integer idPromot;
	private PsPromotItem psPromotItem;
	private Timestamp timeStart;
	private Timestamp timeEnd;
	private Double weight = 0.0;
	private Double price = 0.0;
	private Integer numFetched = 0;
	private Integer id;

	// Constructors

	/** default constructor */
	public PsAdItem() {
	}

	/** minimal constructor */
	public PsAdItem(Integer idPromot, PsPromotItem psPromotItem,
			Timestamp timeStart, Timestamp timeEnd, Double weight,
			Double price, Integer numFetched) {
		this.idPromot = idPromot;
		this.psPromotItem = psPromotItem;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.weight = weight;
		this.price = price;
		this.numFetched = numFetched;
	}

	/** full constructor */
	public PsAdItem(Integer idPromot, PsPromotItem psPromotItem,
			Timestamp timeStart, Timestamp timeEnd, Double weight,
			Double price, Integer numFetched, Integer id) {
		this.idPromot = idPromot;
		this.psPromotItem = psPromotItem;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.weight = weight;
		this.price = price;
		this.numFetched = numFetched;
		this.id = id;
	}

	// Property accessors
	@Id
	@Column(name = "id_promot", unique = true, nullable = false)
	public Integer getIdPromot() {
		return this.idPromot;
	}

	public void setIdPromot(Integer idPromot) {
		this.idPromot = idPromot;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public PsPromotItem getPsPromotItem() {
		return this.psPromotItem;
	}

	public void setPsPromotItem(PsPromotItem psPromotItem) {
		this.psPromotItem = psPromotItem;
	}

	@Column(name = "time_start", nullable = false, length = 19)
	public Timestamp getTimeStart() {
		return this.timeStart;
	}

	public void setTimeStart(Timestamp timeStart) {
		this.timeStart = timeStart;
	}

	@Column(name = "time_end", nullable = false, length = 19)
	public Timestamp getTimeEnd() {
		return this.timeEnd;
	}

	public void setTimeEnd(Timestamp timeEnd) {
		this.timeEnd = timeEnd;
	}

	@Column(name = "weight", nullable = false, precision = 22, scale = 0)
	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Column(name = "price", nullable = false, precision = 9)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "num_fetched", nullable = false)
	public Integer getNumFetched() {
		return this.numFetched;
	}

	public void setNumFetched(Integer numFetched) {
		this.numFetched = numFetched;
	}

	@Column(name = "id", unique = true)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}