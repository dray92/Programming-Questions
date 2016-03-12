package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, 
 * that are all of the same length. Find all starting 
 * indices of substring(s) in s that is a concatenation 
 * of each word in words exactly once and without any 
 * intervening characters. 
 * 
 * @author Debosmit
 *
 */

public class Substring_with_Concatenation_of_All_Words {

	public List<Integer> findSubstring(String s, String[] words) {
        if(words == null || s == null || s.length() == 0 || words.length == 0)
        	return new ArrayList<Integer>(); 
        
        int wordSize = words[0].length();
        
        if(s.length() < wordSize*words.length)
        	return new ArrayList<Integer>();
        
        List<Integer> list = new ArrayList<Integer>();
       
        
        // frequency map
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String word: words) {
        	if(!map.containsKey(word))
        		map.put(word, 0);
        	map.put(word, map.get(word)+1);
        }
        
        int upperBound = s.length() - wordSize*words.length;
        for(int i = 0 ; i <= upperBound ; i++) {
        	if(isValidSubstring(s, i, map, wordSize, words.length))
        		list.add(i);
        }
        
        return list;
    }
	
	private boolean isValidSubstring(String s, int indx, 
			Map<String, Integer> freqMap, int wordSize, int numWords) {
		
		// not possible to get substring starting at passed index
		// if the number of character of remaining substring
		// is less than the number of characters on concatenating words array
		if(s.length() - indx + 1 < wordSize*numWords)
			return false;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i = 0 ; i < numWords ; i++) {
			// get a substring at indx that has a size of wordSize
			String curWord = s.substring(indx + i*wordSize , indx + (i+1)*wordSize);
			
			// is this word relevant?
			if(!freqMap.containsKey(curWord))
				return false;
			
			// add to the map
			if(!map.containsKey(curWord))
        		map.put(curWord, 0);
        	map.put(curWord, map.get(curWord)+1);
        	
        	// if count of curWord in current setting
        	// results in frequency that is greater than the 
        	// frequency of curWord in words array
        	if(map.get(curWord) > freqMap.get(curWord))
        		return false;
		}
		
		return true;
	}

	
	public static void main(String[] args) {
		Substring_with_Concatenation_of_All_Words Word = 
				new Substring_with_Concatenation_of_All_Words();
		
		String st = "barfoothefoobarman";
		String[] words = new String[]{"foo", "bar"};
		System.out.println(Word.findSubstring(st, words));
		
		st = "foobarbarfoomandogcatdogman";
		words = new String[]{"foo", "bar"};
		System.out.println(Word.findSubstring(st, words));
		
		st = "wordgoodgoodgoodbestword";
		words = new String[]{"word", "good", "best", "good"};
		System.out.println(Word.findSubstring(st, words));
		
 	}
}
