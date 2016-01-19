package ctci;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a string has all unique characters.
 * No additional data structures
 * @author Debosmit
 *
 */
public class ArrayString1_1 {
	
	// iterate over the string, checking if the same
	// character occurs again
	public boolean allCharsUnique(String st) {
		if(st == null || st.length() == 1)
			return true;
		
		if(st.length() > 256)
			return false;
		
		int len = st.length();
		st = st.toLowerCase();
		
		for(int i = 0 ; i < len - 1 ; i++)
			for(int j = i+1 ; j < len ; j++)
				if(st.charAt(i) == st.charAt(j))
					return false;
		return true;
	}
	
	// using aux storage
	public boolean allCharsUnique2(String st) { 
		if(st == null || st.length() == 1)
			return true;
		
		if(st.length() > 256)
			return false;
		
		st = st.toLowerCase();
		
		Set<Character> set = new HashSet<Character>();
		for(int i = 0 ; i < st.length() ; i++) {
			boolean res = set.add(st.charAt(i));
			if(!res)
				return false;
		}
		return true;
	}
	
	// using bit shifts
	public boolean allCharsUnique3(String st) { 
		if(st == null || st.length() == 1)
			return true;
		
		if(st.length() > 256)
			return false;
		
		st = st.toLowerCase();
		
		int aggregator = 0;
		for(int i = 0 ; i < st.length() ; i++) {
			int val = st.charAt(i) - 'a';
			if((aggregator & (1 << val)) > 0)
				return false;
			aggregator |= (1 << val);
		}
		return true;
	}
	
	public static void main(String[] args) {
		String st = "abcdefghijklmnopqrstuvwxyz";
		ArrayString1_1 unique = new ArrayString1_1();
		System.out.println("String: " + st);
		System.out.println("All chars unique? " + unique.allCharsUnique3(st));
	}
}
