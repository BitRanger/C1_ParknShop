package temp;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * PsAdminAcc entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_admin_acc", catalog = "c1_parknshop")
public class PsAdminAcc implements java.io.Serializable {

	// Fields

	private Integer idAdmin;
	private PsAdministrator psAdministrator;
	private PsOrderLog psOrderLog;
	private Double amount;
	private Timestamp timeCreated;

	// Constructors

	/** default constructor */
	public PsAdminAcc() {
	}

	/** minimal constructor */
	public PsAdminAcc(Integer idAdmin, PsAdministrator psAdministrator,
			PsOrderLog psOrderLog, Timestamp timeCreated) {
		this.idAdmin = idAdmin;
		this.psAdministrator = psAdministrator;
		this.psOrderLog = psOrderLog;
		this.timeCreated = timeCreated;
	}

	/** full constructor */
	public PsAdminAcc(Integer idAdmin, PsAdministrator psAdministrator,
			PsOrderLog psOrderLog, Double amount, Timestamp timeCreated) {
		this.idAdmin = idAdmin;
		this.psAdministrator = psAdministrator;
		this.psOrderLog = psOrderLog;
		this.amount = amount;
		this.timeCreated = timeCreated;
	}

	// Property accessors
	@Id
	@Column(name = "id_admin", unique = true, nullable = false)
	public Integer getIdAdmin() {
		return this.idAdmin;
	}

	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public PsAdministrator getPsAdministrator() {
		return this.psAdministrator;
	}

	public void setPsAdministrator(PsAdministrator psAdministrator) {
		this.psAdministrator = psAdministrator;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_order_log", nullable = false)
	public PsOrderLog getPsOrderLog() {
		return this.psOrderLog;
	}

	public void setPsOrderLog(PsOrderLog psOrderLog) {
		this.psOrderLog = psOrderLog;
	}

	@Column(name = "amount", precision = 9)
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Column(name = "time_created", nullable = false, length = 19)
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

}