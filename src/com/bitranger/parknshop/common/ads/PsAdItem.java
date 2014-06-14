package com.bitranger.parknshop.common.ads;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PsAdItem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_ad_item", catalog = "c1_parknshop")
public class PsAdItem implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7193757448686415312L;
	private Integer id;
	private PsPromotItem psPromotItem;
	private Timestamp timeStart;
	private Timestamp timeEnd;
	private Double weight;
	private Double price;
	private Integer numFetched;

	// Constructors

	/** default constructor */
	public PsAdItem() {}

	/** full constructor */
	public PsAdItem(Integer id, PsPromotItem psPromotItem, Timestamp timeStart,
			Timestamp timeEnd, Double weight, Double price, Integer numFetched) {
		this.id = id;
		this.psPromotItem = psPromotItem;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.weight = weight;
		this.price = price;
		this.numFetched = numFetched;
	}
	
	
//	public boolean isValid() {
//		Date date = new Date();
//		return timeStart.before(date) && timeEnd.after(date);
//	}

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
	@JoinColumn(name = "id_promot", nullable = false)
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

}