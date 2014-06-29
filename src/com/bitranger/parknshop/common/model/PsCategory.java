package com.bitranger.parknshop.common.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PsCategory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_category", catalog = "c1_parknshop")
public class PsCategory implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String description;
	private String extral1;
	private String extral2;
	private Set<PsItem> psItems = new HashSet<PsItem>(0);

	// Constructors

	/** default constructor */
	public PsCategory() {
	}

	/** minimal constructor */
	public PsCategory(String name) {
		this.name = name;
	}

	/** full constructor */
	public PsCategory(String name, String description, String extral1,
			String extral2, Set<PsItem> psItems) {
		this.name = name;
		this.description = description;
		this.extral1 = extral1;
		this.extral2 = extral2;
		this.psItems = psItems;
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

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "extral_1", length = 65535)
	public String getExtral1() {
		return this.extral1;
	}

	public void setExtral1(String extral1) {
		this.extral1 = extral1;
	}

	@Column(name = "extral_2", length = 65535)
	public String getExtral2() {
		return this.extral2;
	}

	public void setExtral2(String extral2) {
		this.extral2 = extral2;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "psCategory")
	public Set<PsItem> getPsItems() {
		return this.psItems;
	}

	public void setPsItems(Set<PsItem> psItems) {
		this.psItems = psItems;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PsCategory)) {
			return false;
		}
		PsCategory other = (PsCategory) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (extral1 == null) {
			if (other.extral1 != null) {
				return false;
			}
		} else if (!extral1.equals(other.extral1)) {
			return false;
		}
		if (extral2 == null) {
			if (other.extral2 != null) {
				return false;
			}
		} else if (!extral2.equals(other.extral2)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (psItems == null) {
			if (other.psItems != null) {
				return false;
			}
		} else if (!psItems.equals(other.psItems)) {
			return false;
		}
		return true;
	}

}