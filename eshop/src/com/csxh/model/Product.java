package com.csxh.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {

	private String id;
	private String name;

	private String smallImg;
	private String bigImg;
	private String description;
	private String author;
	private String supplier;
	private String pubDate;// datetime---->java.sql.Timestamp--->String
	private String addDate;

	private double price;
	private double listPrice;

	private Boolean hotDeal;

	private Category category;

	private SubCategory subCategory;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public void setPubDate(java.sql.Timestamp pubDate) {
		// ½«timestamp-->date
		java.util.Date d = new java.util.Date(pubDate.getTime());
		// date--->string
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		this.pubDate = sdf.format(d);
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setAddDate(java.sql.Timestamp addDate) {
		// ½«timestamp-->date
		java.util.Date d = new java.util.Date(addDate.getTime());
		// date--->string
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		this.addDate = sdf.format(d);

	}

	public String getAddDate() {
		return addDate;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getSmallImg() {
		return smallImg;
	}

	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}

	public String getBigImg() {
		return bigImg;
	}

	public void setBigImg(String bigImg) {
		this.bigImg = bigImg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {

		this.price = price.doubleValue();
	}

	public double getListPrice() {
		return listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice.doubleValue();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getHotDeal() {
		return hotDeal;
	}

	public void setHotDeal(Boolean hotDeal) {
		this.hotDeal = hotDeal;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
