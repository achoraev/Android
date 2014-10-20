package inventory;
public class Product {
	
	static int nextId = 1; 
	
	private int id;
	
	private float price;
	
	private float quantity;
	
	public Product(float price, float quantity) {
		this.id = nextId++;
		this.price = price;
		this.quantity = quantity;
	}

	public float getTotalValue(){
		return (this.price * this.quantity);
	}

}
