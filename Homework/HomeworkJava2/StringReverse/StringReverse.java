import java.util.Arrays;
import java.util.Scanner;

public class HelloWorld {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a random string: ");
		String initialStr = input.nextLine();
		
		StringBuilder finalStr = new StringBuilder();
		for(int i=initialStr.length()-1; i >= 0; i--){
			finalStr.append(initialStr.charAt(i));
		}
			
		System.out.println(finalStr.toString());		
		input.close();
	}
}