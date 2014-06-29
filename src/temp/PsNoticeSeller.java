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
 * PsNoticeSeller entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_notice_seller", catalog = "c1_parknshop")
public class PsNoticeSeller implements java.io.Serializable {

	// Fields

	private Integer idSeller;
	private PsSeller psSeller;
	private Timestamp timeCreated;
	private String source;
	private String message;
	private Short isValid;

	// Constructors

	/** default constructor */
	public PsNoticeSeller() {
	}

	/** minimal constructor */
	public PsNoticeSeller(Integer idSeller, PsSeller psSeller,
			Timestamp timeCreated, Short isValid) {
		this.idSeller = idSeller;
		this.psSeller = psSeller;
		this.timeCreated = timeCreated;
		this.isValid = isValid;
	}

	/** full constructor */
	public PsNoticeSeller(Integer idSeller, PsSeller psSeller,
			Timestamp timeCreated, String source, String message, Short isValid) {
		this.idSeller = idSeller;
		this.psSeller = psSeller;
		this.timeCreated = timeCreated;
		this.source = source;
		this.message = message;
		this.isValid = isValid;
	}

	// Property accessors
	@Id
	@Column(name = "id_seller", unique = true, nullable = false)
	public Integer getIdSeller() {
		return this.idSeller;
	}

	public void setIdSeller(Integer idSeller) {
		this.idSeller = idSeller;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public PsSeller getPsSeller() {
		return this.psSeller;
	}

	public void setPsSeller(PsSeller psSeller) {
		this.psSeller = psSeller;
	}

	@Column(name = "time_created", nullable = false, length = 19)
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