import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// reverse string
		String input = "ANGEL";
		System.out.print(ReverseString(input));

		// count words
		String filePath = "D:\\Drive\\EclipseProjects\\Homework\\text.txt";
		ReadAndCount(filePath);
	}
	
	public static String ReverseString(String input) {		
		StringBuilder result = new StringBuilder();
		
		for (int i = input.length()-1; i >= 0; i--) {
			result.append(input.charAt(i));			
		}
		
		return result.toString();		
	}
	
	public static void ReadAndCount(String file) throws IOException {
		String line;
		
		HashMap<String, Integer> dictMap = new HashMap<String, Integer>();
		
		BufferedReader reader = new BufferedReader(new FileReader(file));			
		
		while ((line = reader.readLine())!= null) {			
			String[] splitedStrings = line.split("[\\s\\W]+");
			for (int i = 0; i < splitedStrings.length; i++) {
				if (dictMap.containsKey(splitedStrings[i])) {
					dictMap.put(splitedStrings[i], dictMap.get(splitedStrings[i])+1);
				}else {
					dictMap.put(splitedStrings[i], 1);
				}
			}
		}
		
		reader.close();
		
		Set<Map.Entry<String, Integer>> set = dictMap.entrySet();
		
		for (Map.Entry<String, Integer> entry : set) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}		
	}	
}