package leetcode;

import java.util.HashMap;

/**
 * Given two strings, check if they’re anagrams or 
 * not. Two strings are anagrams if they are written 
 * using the same exact letters, ignoring space, 
 * punctuation and capitalization. Each letter should 
 * have the same count in both strings. For example, 
 * ‘Eleven plus two’ and ‘Twelve plus one’ are meaningful 
 * anagrams of each other.
 */
public class AnagramStrings {
	public boolean areAnagrams(String st1, String st2) {
		
		// to ignore capitalization
		st1 = st1.toLowerCase();
		st2 = st2.toLowerCase();
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		// adding to map for frequencies
		for(int i = 0 ; i < st1.length() ; i++) {
			char c = st1.charAt(i);
			if(c < 97 || c > 122)
				continue;
			if(!map.containsKey(c))
				map.put(c, 1);
			else 
				map.put(c, map.get(c)+1);
		}
		// for every character encountered, we decrement value
		// if in map, else return false since it's a new character
		for(int i = 0 ; i < st2.length() ; i++) {
			char c = st2.charAt(i);
			if(c < 97 || c > 122)
				continue;
			if(!map.containsKey(c))
				return false;
			else 
				map.put(c, map.get(c)-1);
		}
		for(char c: map.keySet())
			if(map.get(c) != 0)
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		AnagramStrings anagrams = new AnagramStrings();
		String st1 = "Eleven plus two";
		String st2 = "Twelve plus one";
		System.out.println("String 1: " + st1);
		System.out.println("String 2: " + st2);
		System.out.println("Are the strings anagrams? " + anagrams.areAnagrams(st1, st2));
	}
}
