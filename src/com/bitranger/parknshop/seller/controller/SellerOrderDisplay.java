package com.bitranger.parknshop.seller.controller;

import java.sql.Timestamp;
import java.util.Set;

public class SellerOrderDisplay {

	private Integer id;
	private String itemPic;
	private String itemName;
	private Timestamp soldTime;
	private Double price;
	private Integer quantity;
	private String buyerName;
	private Short state;
	private String address;
	private String phone;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getItemPic() {
		return itemPic;
	}
	public void setItemPic(String itemPic) {
		this.itemPic = itemPic;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Timestamp getSoldTime() {
		return soldTime;
	}
	public void setSoldTime(Timestamp soldTime) {
		this.soldTime = soldTime;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public Short getState() {
		return state;
	}
	public void setState(Short state) {
		this.state = state;
	}
	
	
	/**
	 * this is a javabean
	 * @author Administrator
	 *
	 */
	public static class ModifyItem {
		
		private Integer id;
		private ModifyCategoty modifyCategory;
		private Set<ModifyTag> tags;
		private String name;
		private Double price;
		private String description;
		private String urlPictuere;
		private String extra1;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public ModifyCategoty getModifyCategory() {
			return modifyCategory;
		}
		public void setModifyCategory(ModifyCategoty modifyCategory) {
			this.modifyCategory = modifyCategory;
		}
		public Set<ModifyTag> getTags() {
			return tags;
		}
		public void setTags(Set<ModifyTag> tags) {
			this.tags = tags;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getUrlPictuere() {
			return urlPictuere;
		}
		public void setUrlPictuere(String urlPictuere) {
			this.urlPictuere = urlPictuere;
		}
		public String getExtra1() {
			return extra1;
		}
		public void setExtra1(String extra1) {
			this.extra1 = extra1;
		}
	}
	
	
	public static class ModifyCategoty {
		
		private Integer id;
		private String description;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	}
	
	public static class ModifyTag {
		
		private Integer id;
		private String name;
		 
		public Integer getId() {
			return id;
		}
		
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
}
