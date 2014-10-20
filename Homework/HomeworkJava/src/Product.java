
public class Product {

	private int id;
	
	private double price;
	
	private int quantity;
	
	public Product() {
		
	}
	
	public Product(int id, int price, int quantity){
		this.setId(id);
		this.setPrice(price);
		this.setQuantity(quantity);
	}

 	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}