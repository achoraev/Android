import java.util.ArrayList;

public class Inventory {

	private ArrayList<Product> listOfProducts;
	
	public Inventory(Product product) {
		this.setListOfProducts(new ArrayList<Product>());
	}
	
	public Inventory(ArrayList<Product> products) {
		this.setListOfProducts(new ArrayList<Product>());
	}

	public double SumProductValue(ArrayList<Product> products) {
		double sum = 0;
		
		for (Product product : products) {
			sum += product.getQuantity() * product.getPrice();
		}
		
		return sum;
	}

	public ArrayList<Product> getListOfProducts() {
		return listOfProducts;
	}

	public void setListOfProducts(ArrayList<Product> listOfProducts) {
		this.listOfProducts = listOfProducts;
	}

}