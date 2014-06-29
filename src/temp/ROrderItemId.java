package temp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ROrderItemId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class ROrderItemId implements java.io.Serializable {

	// Fields

	private Integer idItem;
	private Integer idOrder;

	// Constructors

	/** default constructor */
	public ROrderItemId() {
	}

	/** full constructor */
	public ROrderItemId(Integer idItem, Integer idOrder) {
		this.idItem = idItem;
		this.idOrder = idOrder;
	}

	// Property accessors

	@Column(name = "id_item", nullable = false)
	public Integer getIdItem() {
		return this.idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	@Column(name = "id_order", nullable = false)
	public Integer getIdOrder() {
		return this.idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ROrderItemId))
			return false;
		ROrderItemId castOther = (ROrderItemId) other;

		return ((this.getIdItem() == castOther.getIdItem()) || (this
				.getIdItem() != null && castOther.getIdItem() != null && this
				.getIdItem().equals(castOther.getIdItem())))
				&& ((this.getIdOrder() == castOther.getIdOrder()) || (this
						.getIdOrder() != null && castOther.getIdOrder() != null && this
						.getIdOrder().equals(castOther.getIdOrder())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getIdItem() == null ? 0 : this.getIdItem().hashCode());
		result = 37 * result
				+ (getIdOrder() == null ? 0 : this.getIdOrder().hashCode());
		return result;
	}

}