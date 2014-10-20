import java.util.ArrayList;

public class Tests {
	
	public static void main(String[] args) {
		
		Product apples = new Product(1, 5, 20);
		Product orange = new Product(2, 6, 15);
		Product banana = new Product(3, 8, 25);
		
		ArrayList<Product> listOfProducts = new ArrayList<Product>();
		listOfProducts.add(apples);
		listOfProducts.add(orange);
		listOfProducts.add(banana);
				
		Inventory sklad = new Inventory(listOfProducts);
		System.out.println("Value of products in inventory = " + sklad.SumProductValue(listOfProducts));		
	}
}