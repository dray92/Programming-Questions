package ctci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Sort an array of strings so that all  
 * the anagrams are next to each other.
 * @author Debosmit
 *
 */
public class SortingSearching11_2 {
	
	public void groupAnagrams(String[] words) {
		Map<String, LinkedList<String>> dict = new HashMap<String, LinkedList<String>>();
		
		// sorting all the letters of a word
		// will result in anagrams having the same
		// sorted string
		
		for(String word: words) {
			String sortedWord = sortChars(word);
			
			if(!dict.keySet().contains(sortedWord)) 
				dict.put(sortedWord, new LinkedList<String>());
			
			dict.get(sortedWord).push(word);
		}
		
		// take words from the HashMap and insert 
		// it into the original array
		int count = 0;
		for(String sortedWord: dict.keySet()) 
			for(String anagram: dict.get(sortedWord))
				words[count++] = anagram;
	}
	
	private String sortChars(String word) {
		char[] chars = word.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	
	public static void main(String[] args) {
		SortingSearching11_2 MergeAnagrams = new SortingSearching11_2();
		
		String[] words = {"abc", "dog", "acb", "god", "cab", "odg", "cba", "dgo", "battle"};
		
		System.out.println("Original Array: " + Arrays.toString(words));
		
		MergeAnagrams.groupAnagrams(words);
		
		System.out.println("Array with anagrams grouped: " + Arrays.toString(words));
	}
}
