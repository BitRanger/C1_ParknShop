package temp;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PsCustomer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_customer", catalog = "c1_parknshop")
public class PsCustomer implements java.io.Serializable {

	// Fields

	private Integer id;
	private String nickname;
	private String email;
	private String password;
	private Short gender;
	private String name;
	private Date birthday;
	private Timestamp timeCreated;
	private Set<PsOrder> psOrders = new HashSet<PsOrder>(0);
	private Set<CartCustomerItem> cartCustomerItems = new HashSet<CartCustomerItem>(
			0);
	private Set<CustomerFavouriteItem> customerFavouriteItems = new HashSet<CustomerFavouriteItem>(
			0);
	private PsNoticeCustomer psNoticeCustomer;
	private Set<CustomerFavouriteShop> customerFavouriteShops = new HashSet<CustomerFavouriteShop>(
			0);
	private Set<PsRecipient> psRecipients = new HashSet<PsRecipient>(0);
	private Set<PsComment> psComments = new HashSet<PsComment>(0);

	// Constructors

	/** default constructor */
	public PsCustomer() {
	}

	/** minimal constructor */
	public PsCustomer(String nickname, String email, String password,
			Short gender, Timestamp timeCreated) {
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.timeCreated = timeCreated;
	}

	/** full constructor */
	public PsCustomer(String nickname, String email, String password,
			Short gender, String name, Date birthday, Timestamp timeCreated,
			Set<PsOrder> psOrders, Set<CartCustomerItem> cartCustomerItems,
			Set<CustomerFavouriteItem> customerFavouriteItems,
			PsNoticeCustomer psNoticeCustomer,
			Set<CustomerFavouriteShop> customerFavouriteShops,
			Set<PsRecipient> psRecipients, Set<PsComment> psComments) {
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.name = name;
		this.birthday = birthday;
		this.timeCreated = timeCreated;
		this.psOrders = psOrders;
		this.cartCustomerItems = cartCustomerItems;
		this.customerFavouriteItems = customerFavouriteItems;
		this.psNoticeCustomer = psNoticeCustomer;
		this.customerFavouriteShops = customerFavouriteShops;
		this.psRecipients = psRecipients;
		this.psComments = psComments;
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

	@Column(name = "nickname", nullable = false, length = 65535)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "email", nullable = false, length = 65535)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 65535)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "gender", nullable = false)
	public Short getGender() {
		return this.gender;
	}

	public void setGender(Short gender) {
		this.gender = gender;
	}

	@Column(name = "name", length = 65535)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", length = 10)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "time_created", nullable = false, length = 19)
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "psCustomer")
	public Set<PsOrder> getPsOrders() {
		return this.psOrders;
	}

	public void setPsOrders(Set<PsOrder> psOrders) {
		this.psOrders = psOrders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "psCustomer")
	public Set<CartCustomerItem> getCartCustomerItems() {
		return this.cartCustomerItems;
	}

	public void setCartCustomerItems(Set<CartCustomerItem> cartCustomerItems) {
		this.cartCustomerItems = cartCustomerItems;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "psCustomer")
	public Set<CustomerFavouriteItem> getCustomerFavouriteItems() {
		return this.customerFavouriteItems;
	}

	public void setCustomerFavouriteItems(
			Set<CustomerFavouriteItem> customerFavouriteItems) {
		this.customerFavouriteItems = customerFavouriteItems;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "psCustomer")
	public PsNoticeCustomer getPsNoticeCustomer() {
		return this.psNoticeCustomer;
	}

	public void setPsNoticeCustomer(PsNoticeCustomer psNoticeCustomer) {
		this.psNoticeCustomer = psNoticeCustomer;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "psCustomer")
	public Set<CustomerFavouriteShop> getCustomerFavouriteShops() {
		return this.customerFavouriteShops;
	}

	public void setCustomerFavouriteShops(
			Set<CustomerFavouriteShop> customerFavouriteShops) {
		this.customerFavouriteShops = customerFavouriteShops;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "psCustomer")
	public Set<PsRecipient> getPsRecipients() {
		return this.psRecipients;
	}

	public void setPsRecipients(Set<PsRecipient> psRecipients) {
		this.psRecipients = psRecipients;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "psCustomer")
	public Set<PsComment> getPsComments() {
		return this.psComments;
	}

	public void setPsComments(Set<PsComment> psComments) {
		this.psComments = psComments;
	}

}