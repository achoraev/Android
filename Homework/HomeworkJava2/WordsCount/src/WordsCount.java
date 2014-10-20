import java.util.Scanner;
import java.io.*;

public class WordsCount {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/text.txt");
		Scanner input = new Scanner(file);
		StringBuilder text = new StringBuilder();
		while(input.hasNextLine()){
			text.append(input.nextLine());
		}
		
		input.close();
		splitWords(text.toString());
	}
	
	static void splitWords(String input){
		String[] splittedText = input.split("[\\s-]+"); 
		System.out.println(splittedText.length);
		for(String sourse : splittedText){
			System.out.println(sourse);
		}
	}
}