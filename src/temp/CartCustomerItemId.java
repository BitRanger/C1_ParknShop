package temp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CartCustomerItemId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class CartCustomerItemId implements java.io.Serializable {

	// Fields

	private Integer idCustomer;
	private Integer idItem;

	// Constructors

	/** default constructor */
	public CartCustomerItemId() {
	}

	/** full constructor */
	public CartCustomerItemId(Integer idCustomer, Integer idItem) {
		this.idCustomer = idCustomer;
		this.idItem = idItem;
	}

	// Property accessors

	@Column(name = "id_customer", nullable = false)
	public Integer getIdCustomer() {
		return this.idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	@Column(name = "id_item", nullable = false)
	public Integer getIdItem() {
		return this.idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CartCustomerItemId))
			return false;
		CartCustomerItemId castOther = (CartCustomerItemId) other;

		return ((this.getIdCustomer() == castOther.getIdCustomer()) || (this
				.getIdCustomer() != null && castOther.getIdCustomer() != null && this
				.getIdCustomer().equals(castOther.getIdCustomer())))
				&& ((this.getIdItem() == castOther.getIdItem()) || (this
						.getIdItem() != null && castOther.getIdItem() != null && this
						.getIdItem().equals(castOther.getIdItem())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getIdCustomer() == null ? 0 : this.getIdCustomer()
						.hashCode());
		result = 37 * result
				+ (getIdItem() == null ? 0 : this.getIdItem().hashCode());
		return result;
	}

}