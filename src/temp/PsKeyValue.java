package temp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PsKeyValue entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_key_value", catalog = "c1_parknshop")
public class PsKeyValue implements java.io.Serializable {

	// Fields

	private String key;
	private String val;

	// Constructors

	/** default constructor */
	public PsKeyValue() {
	}

	/** full constructor */
	public PsKeyValue(String key, String val) {
		this.key = key;
		this.val = val;
	}

	// Property accessors
	@Id
	@Column(name = "key", unique = true, nullable = false, length = 128)
	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Column(name = "val", nullable = false)
	public String getVal() {
		return this.val;
	}

	public void setVal(String val) {
		this.val = val;
	}

}