package com.fragments.products;



public class Data {
	private static final Product[] products = {
		new Product(1, "Bike", "Toy", 5, 120),
		new Product(2, "Granate", "Weapon", 14, 110),
		new Product(3, "Kolelo", "Toy", 5, 120),
		new Product(4, "Kolelo", "Toy", 5, 120),
		new Product(5, "Kolelo", "Toy", 5, 120),
		new Product(6, "Kolelo", "Toy", 5, 120),
		new Product(7, "Kolelo", "Toy", 5, 120),
		new Product(8, "Kolelo", "Toy", 5, 120),
		new Product(9, "Kolelo", "Toy", 5, 120),
		new Product(10, "Kolelo", "Toy", 5, 120),
		new Product(11, "Kolelo", "Toy", 5, 120),
		new Product(12, "Kolelo", "Toy", 5, 120),
	};
	
	public static String[] getTitles(){
		String[] titles = new String[products.length];
		for (int i = 0; i < products.length; i++) {
			titles[i] = products[i].getName();
		}
		
		return titles;
	}
	
	public static Product[] getProducts(){
		return products;
	}
}
