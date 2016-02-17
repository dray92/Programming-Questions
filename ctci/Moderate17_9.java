package ctci;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the frequency of occurrence
 * of a given word in a dictionary
 * @author Debosmit
 *
 */
public class Moderate17_9 {

	private Map<String, Integer> map;
	private String[] book;

	public Moderate17_9(String[] book) {
		this.book = book;
	}
	
	public void preprocess() {
		if(book == null)
			throw new IllegalArgumentException("Book not initialized");
		map = new HashMap<String, Integer>();
		for(String word: book) {
			// lower-case and upper-case
			// are treated differently
			if(!map.keySet().contains(word)) 
				map.put(word, 0);
			map.put(word, map.get(word) + 1);
		}
	}
	
	public int getFrequency(String word) {
		if(map.keySet().contains(word))
			return map.get(word);
		return -1;
	}
	
	public static void main(String[] args) {
		String[] book = {"I", "am", "bill", "Bill", "is", "my", "dog", "is"};
		Moderate17_9 Freq = new Moderate17_9(book);
		Freq.preprocess();
		String word = "is";
		System.out.println("Frequency of \'" + word + "\': " + Freq.getFrequency(word));
		
	}
}
