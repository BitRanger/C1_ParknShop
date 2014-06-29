package temp;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * PsTag entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_tag", catalog = "c1_parknshop")
public class PsTag implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set<PsItem> psItems = new HashSet<PsItem>(0);

	// Constructors

	/** default constructor */
	public PsTag() {
	}

	/** minimal constructor */
	public PsTag(String name) {
		this.name = name;
	}

	/** full constructor */
	public PsTag(String name, Set<PsItem> psItems) {
		this.name = name;
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

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "r_tag_item", catalog = "c1_parknshop", joinColumns = { @JoinColumn(name = "id_tag", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_item", nullable = false, updatable = false) })
	public Set<PsItem> getPsItems() {
		return this.psItems;
	}

	public void setPsItems(Set<PsItem> psItems) {
		this.psItems = psItems;
	}

}