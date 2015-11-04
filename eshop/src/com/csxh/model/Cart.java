package com.csxh.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<CartItem> itemList = new ArrayList<CartItem>();

	public List<CartItem> getItemList() {
		return itemList;
	}

	public void add(CartItem item) {

		for (CartItem item2 : this.itemList) {
			if (item.getProductId().equals(item2.getProductId())) {
				item2.setProductCount(item2.getProductCount() + 1);
				return;
			}
		}
		this.itemList.add(item);

	}

	public void delete(CartItem item) {

		for (int i = 0; i < this.itemList.size(); i++) {

			if (item.getProductId().equals(itemList.get(i).getProductId())) {
				this.itemList.remove(i);
				return;
			}
		}

	}

	public void update(CartItem item, int count) {

		for (CartItem item2 : this.itemList) {
			if (item.getProductId().equals(item2.getProductId())) {
				item2.setProductCount(count);
				return;
			}
		}

	}
	
	public void clean(){
		this.itemList.clear();
	}

	public double getTotalWeight() {

		double total = 0.0;
		for (CartItem item : this.itemList) {
			total += item.getProductWeight() * item.getProductCount();
		}
		return total;

	}

	public double getTotalPrice() {
		
		double total = 0.0;
		for (CartItem item : this.itemList) {
			total += item.getProductPrice() * item.getProductCount();
		}
		return total;
		
	}

}
