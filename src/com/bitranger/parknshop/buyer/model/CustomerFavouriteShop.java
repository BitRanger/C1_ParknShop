package com.bitranger.parknshop.buyer.model;

import java.sql.Timestamp;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bitranger.parknshop.seller.model.PsShop;

/**
 * CustomerFavouriteShop entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "customer_favourite_shop", catalog = "c1_parknshop")
public class CustomerFavouriteShop implements java.io.Serializable {

	// Fields

	private CustomerFavouriteShopId id;
	private PsCustomer psCustomer;
	private PsShop psShop;
	private Timestamp timeCreated;

	// Constructors

	/** default constructor */
	public CustomerFavouriteShop() {
	}

	/** full constructor */
	public CustomerFavouriteShop(CustomerFavouriteShopId id,
			PsCustomer psCustomer, PsShop psShop, Timestamp timeCreated) {
		this.id = id;
		this.psCustomer = psCustomer;
		this.psShop = psShop;
		this.timeCreated = timeCreated;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idShop", column = @Column(name = "id_shop", nullable = false)),
			@AttributeOverride(name = "idCustomer", column = @Column(name = "id_customer", nullable = false)) })
	public CustomerFavouriteShopId getId() {
		return this.id;
	}

	public void setId(CustomerFavouriteShopId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_customer", nullable = false, insertable = false, updatable = false)
	public PsCustomer getPsCustomer() {
		return this.psCustomer;
	}

	public void setPsCustomer(PsCustomer psCustomer) {
		this.psCustomer = psCustomer;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_shop", nullable = false, insertable = false, updatable = false)
	public PsShop getPsShop() {
		return this.psShop;
	}

	public void setPsShop(PsShop psShop) {
		this.psShop = psShop;
	}

	@Column(name = "time_created", nullable = false, length = 19)
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

}