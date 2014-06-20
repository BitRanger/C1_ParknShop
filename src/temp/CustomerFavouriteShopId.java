package temp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CustomerFavouriteShopId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class CustomerFavouriteShopId implements java.io.Serializable {

	// Fields

	private Integer idShop;
	private Integer idCustomer;

	// Constructors

	/** default constructor */
	public CustomerFavouriteShopId() {
	}

	/** full constructor */
	public CustomerFavouriteShopId(Integer idShop, Integer idCustomer) {
		this.idShop = idShop;
		this.idCustomer = idCustomer;
	}

	// Property accessors

	@Column(name = "id_shop", nullable = false)
	public Integer getIdShop() {
		return this.idShop;
	}

	public void setIdShop(Integer idShop) {
		this.idShop = idShop;
	}

	@Column(name = "id_customer", nullable = false)
	public Integer getIdCustomer() {
		return this.idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CustomerFavouriteShopId))
			return false;
		CustomerFavouriteShopId castOther = (CustomerFavouriteShopId) other;

		return ((this.getIdShop() == castOther.getIdShop()) || (this
				.getIdShop() != null && castOther.getIdShop() != null && this
				.getIdShop().equals(castOther.getIdShop())))
				&& ((this.getIdCustomer() == castOther.getIdCustomer()) || (this
						.getIdCustomer() != null
						&& castOther.getIdCustomer() != null && this
						.getIdCustomer().equals(castOther.getIdCustomer())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getIdShop() == null ? 0 : this.getIdShop().hashCode());
		result = 37
				* result
				+ (getIdCustomer() == null ? 0 : this.getIdCustomer()
						.hashCode());
		return result;
	}

}