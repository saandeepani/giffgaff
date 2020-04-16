package com.giffgaff.jackson.model;

public class Products {
	
	private String name;
	private int price;
	private int quantity;
	
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Products [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}

}
