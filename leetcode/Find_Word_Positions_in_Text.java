package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/*
 * Given a text file and a word, find the positions 
 * that the word occurs in the file. We’ll be asked to 
 * find the positions of many words in the same file.
 */

public class Find_Word_Positions_in_Text {

	public String[] getWords(String text) {
		// converting to lower case
		text = text.toLowerCase();
		
		// converting non alpha-numeric to spaces
		text = text.replaceAll("[^a-z0-9]", " ");
		
		// split based on spaces
		return text.split(" ");
	}
	
	public HashMap<String, List<Integer>> createIndex1(String text) {
		HashMap<String, List<Integer>> index = new HashMap<String, List<Integer>>();
		String[] words = getWords(text);
		for(int i = 0; i < words.length ; i++) {
			List<Integer> list;
			
			// checking if word is present in key set
			if(!index.containsKey(words[i]))
				list = new ArrayList<Integer>();
			else 
				list = index.get(words[i]);
			
			list.add(i);
			index.put(words[i], list);
		}
		return index;
	}
	
	public List<Integer> getIndexList1(HashMap<String, List<Integer>> index, String word) {
		if(index.containsKey(word))
			return index.get(word);
		return new ArrayList<Integer>();
	}
	
	public static void main(String[] args) {
		Find_Word_Positions_in_Text words = new Find_Word_Positions_in_Text();
		
		String text = "a_b 1`3a a";
		System.out.println("Words: " + Arrays.toString(words.getWords(text)));
		
		HashMap<String, List<Integer>> index = words.createIndex1(text);
		String word = "a";
		List<Integer> indices = words.getIndexList1(index, word);
		System.out.println("For word \'" + word + "\', list of indices: " + Arrays.toString(indices.toArray()));
	}
}
