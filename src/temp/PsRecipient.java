package temp;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PsRecipient entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_recipient", catalog = "c1_parknshop")
public class PsRecipient implements java.io.Serializable {

	// Fields

	private Integer id;
	private PsCustomer psCustomer;
	private String nameRecipient;
	private String addresss;
	private String postalCode;
	private String phoneNumber;
	private String country;
	private String province;
	private String city;
	private String detailedAddr;
	private Set<PsOrder> psOrders = new HashSet<PsOrder>(0);

	// Constructors

	/** default constructor */
	public PsRecipient() {
	}

	/** minimal constructor */
	public PsRecipient(PsCustomer psCustomer, String nameRecipient,
			String addresss, String postalCode, String phoneNumber,
			String city, String detailedAddr) {
		this.psCustomer = psCustomer;
		this.nameRecipient = nameRecipient;
		this.addresss = addresss;
		this.postalCode = postalCode;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.detailedAddr = detailedAddr;
	}

	/** full constructor */
	public PsRecipient(PsCustomer psCustomer, String nameRecipient,
			String addresss, String postalCode, String phoneNumber,
			String country, String province, String city, String detailedAddr,
			Set<PsOrder> psOrders) {
		this.psCustomer = psCustomer;
		this.nameRecipient = nameRecipient;
		this.addresss = addresss;
		this.postalCode = postalCode;
		this.phoneNumber = phoneNumber;
		this.country = country;
		this.province = province;
		this.city = city;
		this.detailedAddr = detailedAddr;
		this.psOrders = psOrders;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_customer", nullable = false)
	public PsCustomer getPsCustomer() {
		return this.psCustomer;
	}

	public void setPsCustomer(PsCustomer psCustomer) {
		this.psCustomer = psCustomer;
	}

	@Column(name = "name_recipient", nullable = false, length = 65535)
	public String getNameRecipient() {
		return this.nameRecipient;
	}

	public void setNameRecipient(String nameRecipient) {
		this.nameRecipient = nameRecipient;
	}

	@Column(name = "addresss", nullable = false, length = 65535)
	public String getAddresss() {
		return this.addresss;
	}

	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}

	@Column(name = "postal_code", nullable = false, length = 65535)
	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Column(name = "phone_number", nullable = false, length = 65535)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "country", length = 32)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "province", length = 65535)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "city", nullable = false, length = 65535)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "detailed_addr", nullable = false, length = 65535)
	public String getDetailedAddr() {
		return this.detailedAddr;
	}

	public void setDetailedAddr(String detailedAddr) {
		this.detailedAddr = detailedAddr;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "psRecipient")
	public Set<PsOrder> getPsOrders() {
		return this.psOrders;
	}

	public void setPsOrders(Set<PsOrder> psOrders) {
		this.psOrders = psOrders;
	}

}