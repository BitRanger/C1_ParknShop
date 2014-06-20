package temp;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * PsNoticeCustomer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_notice_customer", catalog = "c1_parknshop")
public class PsNoticeCustomer implements java.io.Serializable {

	// Fields

	private Integer idCustomer;
	private PsCustomer psCustomer;
	private Timestamp timeCreated;
	private String source;
	private String message;
	private Short isValid;

	// Constructors

	/** default constructor */
	public PsNoticeCustomer() {
	}

	/** minimal constructor */
	public PsNoticeCustomer(Integer idCustomer, PsCustomer psCustomer,
			Short isValid) {
		this.idCustomer = idCustomer;
		this.psCustomer = psCustomer;
		this.isValid = isValid;
	}

	/** full constructor */
	public PsNoticeCustomer(Integer idCustomer, PsCustomer psCustomer,
			Timestamp timeCreated, String source, String message, Short isValid) {
		this.idCustomer = idCustomer;
		this.psCustomer = psCustomer;
		this.timeCreated = timeCreated;
		this.source = source;
		this.message = message;
		this.isValid = isValid;
	}

	// Property accessors
	@Id
	@Column(name = "id_customer", unique = true, nullable = false)
	public Integer getIdCustomer() {
		return this.idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public PsCustomer getPsCustomer() {
		return this.psCustomer;
	}

	public void setPsCustomer(PsCustomer psCustomer) {
		this.psCustomer = psCustomer;
	}

	@Column(name = "time_created", length = 19)
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

	@Column(name = "source")
	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Column(name = "message", length = 65535)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "is_valid", nullable = false)
	public Short getIsValid() {
		return this.isValid;
	}

	public void setIsValid(Short isValid) {
		this.isValid = isValid;
	}

}