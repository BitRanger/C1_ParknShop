package temp;

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

/**
 * CustomerFavouriteItem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "customer_favourite_item", catalog = "c1_parknshop")
public class CustomerFavouriteItem implements java.io.Serializable {

	// Fields

	private CustomerFavouriteItemId id;
	private PsItem psItem;
	private PsCustomer psCustomer;
	private Timestamp timeCreated;

	// Constructors

	/** default constructor */
	public CustomerFavouriteItem() {
	}

	/** full constructor */
	public CustomerFavouriteItem(CustomerFavouriteItemId id, PsItem psItem,
			PsCustomer psCustomer, Timestamp timeCreated) {
		this.id = id;
		this.psItem = psItem;
		this.psCustomer = psCustomer;
		this.timeCreated = timeCreated;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idCustomer", column = @Column(name = "id_customer", nullable = false)),
			@AttributeOverride(name = "idItem", column = @Column(name = "id_item", nullable = false)) })
	public CustomerFavouriteItemId getId() {
		return this.id;
	}

	public void setId(CustomerFavouriteItemId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_item", nullable = false, insertable = false, updatable = false)
	public PsItem getPsItem() {
		return this.psItem;
	}

	public void setPsItem(PsItem psItem) {
		this.psItem = psItem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_customer", nullable = false, insertable = false, updatable = false)
	public PsCustomer getPsCustomer() {
		return this.psCustomer;
	}

	public void setPsCustomer(PsCustomer psCustomer) {
		this.psCustomer = psCustomer;
	}

	@Column(name = "time_created", nullable = false, length = 19)
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

}