package com.fragments.products;

public class Product {
	private int id;
	private String name;
	private String category;
	private double quantity;
	private double price;
	
	public Product(int id, String name, String category, double quantity, double price){
		this.setId(id);
		this.setName(name);
		this.setCategory(category);
		this.setQuantity(quantity);
		this.setPrice(price);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
