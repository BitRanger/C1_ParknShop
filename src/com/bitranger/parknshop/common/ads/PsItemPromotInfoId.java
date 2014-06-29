package com.bitranger.parknshop.common.ads;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PsItemPromotInfoId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class PsItemPromotInfoId implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer idPromt;

	// Constructors

	/** default constructor */
	public PsItemPromotInfoId() {
	}

	/** full constructor */
	public PsItemPromotInfoId(Integer id, Integer idPromt) {
		this.id = id;
		this.idPromt = idPromt;
	}

	// Property accessors

	@Column(name = "id", nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "id_promt", nullable = false)
	public Integer getIdPromt() {
		return this.idPromt;
	}

	public void setIdPromt(Integer idPromt) {
		this.idPromt = idPromt;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PsItemPromotInfoId))
			return false;
		PsItemPromotInfoId castOther = (PsItemPromotInfoId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getIdPromt() == castOther.getIdPromt()) || (this
						.getIdPromt() != null && castOther.getIdPromt() != null && this
						.getIdPromt().equals(castOther.getIdPromt())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getIdPromt() == null ? 0 : this.getIdPromt().hashCode());
		return result;
	}

}