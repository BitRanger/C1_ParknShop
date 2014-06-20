package temp;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PsConfigKey entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_config_key", catalog = "c1_parknshop")
public class PsConfigKey implements java.io.Serializable {

	// Fields

	private Integer id;
	private Timestamp timeCreated;
	private Short isValid;
	private String name;
	private Set<PsConfigVal> psConfigVals = new HashSet<PsConfigVal>(0);

	// Constructors

	/** default constructor */
	public PsConfigKey() {
	}

	/** minimal constructor */
	public PsConfigKey(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

	/** full constructor */
	public PsConfigKey(Timestamp timeCreated, Short isValid, String name,
			Set<PsConfigVal> psConfigVals) {
		this.timeCreated = timeCreated;
		this.isValid = isValid;
		this.name = name;
		this.psConfigVals = psConfigVals;
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

	@Column(name = "time_created", nullable = false, length = 19)
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

	@Column(name = "is_valid")
	public Short getIsValid() {
		return this.isValid;
	}

	public void setIsValid(Short isValid) {
		this.isValid = isValid;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "psConfigKey")
	public Set<PsConfigVal> getPsConfigVals() {
		return this.psConfigVals;
	}

	public void setPsConfigVals(Set<PsConfigVal> psConfigVals) {
		this.psConfigVals = psConfigVals;
	}

}