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
 * CartCustomerItem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cart_customer_item", catalog = "c1_parknshop")
public class CartCustomerItem implements java.io.Serializable {

	// Fields

	private CartCustomerItemId id;
	private PsItem psItem;
	private PsCustomer psCustomer;
	private Integer quantity;
	private String extra1;
	private String extra2;
	private Timestamp timeCreated;

	// Constructors

	/** default constructor */
	public CartCustomerItem() {
	}

	/** minimal constructor */
	public CartCustomerItem(CartCustomerItemId id, PsItem psItem,
			PsCustomer psCustomer, Integer quantity, Timestamp timeCreated) {
		this.id = id;
		this.psItem = psItem;
		this.psCustomer = psCustomer;
		this.quantity = quantity;
		this.timeCreated = timeCreated;
	}

	/** full constructor */
	public CartCustomerItem(CartCustomerItemId id, PsItem psItem,
			PsCustomer psCustomer, Integer quantity, String extra1,
			String extra2, Timestamp timeCreated) {
		this.id = id;
		this.psItem = psItem;
		this.psCustomer = psCustomer;
		this.quantity = quantity;
		this.extra1 = extra1;
		this.extra2 = extra2;
		this.timeCreated = timeCreated;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idCustomer", column = @Column(name = "id_customer", nullable = false)),
			@AttributeOverride(name = "idItem", column = @Column(name = "id_item", nullable = false)) })
	public CartCustomerItemId getId() {
		return this.id;
	}

	public void setId(CartCustomerItemId id) {
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

	@Column(name = "quantity", nullable = false)
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name = "extra_1", length = 65535)
	public String getExtra1() {
		return this.extra1;
	}

	public void setExtra1(String extra1) {
		this.extra1 = extra1;
	}

	@Column(name = "extra_2", length = 65535)
	public String getExtra2() {
		return this.extra2;
	}

	public void setExtra2(String extra2) {
		this.extra2 = extra2;
	}

	@Column(name = "time_created", nullable = false, length = 19)
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

}