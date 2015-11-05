package com.csxh.model;

public class CartItem {

	private String productId;
	private String productName;
	private double productPrice=0;
	private int productCount=0;
	private float productWeight=0;
	
	public void setProductWeight(float productWeight) {
		this.productWeight = productWeight;
	}
	
	public float getProductWeight() {
		return productWeight;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
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
		CartItem other = (CartItem) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CartItem [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productCount=" + productCount + "]";
	}
	
	
	
}
