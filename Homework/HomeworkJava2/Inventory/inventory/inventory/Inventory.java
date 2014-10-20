package inventory;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Inventory {
	public static void main(String[] args){
		ArrayList<Product> inventory = new ArrayList<Product>();
		inventory.add(new Product(2.45f, 6.30f));
		inventory.add(new Product(0.75f, 68f));
		inventory.add(new Product(6.50f, 12f));
		inventory.add(new Product(24.34f, 3f));
		
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println(df.format(getInventoryTotalValue(inventory)));
	}
	
	public static float getInventoryTotalValue(ArrayList<Product> inventory){
		float result = 0;
		for(Product item : inventory){
			result += item.getTotalValue();
		}
		
		return result;
	}
}