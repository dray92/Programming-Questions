package leetcode;

import java.util.HashMap;

public class First_Non_Repeated_Character_String {
	public char firstNonRepeated(String st) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		// adding to hashmap for frequencies
		for(int i = 0 ; i < st.length() ; i++) {
			char c = st.charAt(i);
			if(!map.containsKey(c))
				map.put(c, 1);
			else 
				map.put(c, map.get(c)+1);
		}
		// check frequency of each character
		for(int i = 0 ; i < st.length() ; i++) 
			if(map.get(st.charAt(i)) == 1)
				return st.charAt(i);
		// return null if not found
		return '\u0000';
	}
	
	public static void main(String[] args) {
		First_Non_Repeated_Character_String freq = new First_Non_Repeated_Character_String();
		String st = "({{{}}[])";
		System.out.println("String: " + st);
		System.out.println("First non repeated character: " + freq.firstNonRepeated(st));
	}
}
