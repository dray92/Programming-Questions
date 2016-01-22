package leetcode;

import java.util.Set;
import java.util.HashSet;

/**
 * Remove duplicate characters in a given string 
 * keeping only the first occurrences. For example, 
 * if the input is ‘tree traversal’ the output will 
 * be ‘tre avsl’.
 * @author Debosmit
 *
 */
public class Remove_Duplicate_Characters_in_String {
	public String removeDuplicates(String st) {
		Set<Character> set = new HashSet<Character>();
		// Java Strings are immutable, StringBuilder isn't
		StringBuilder result = new StringBuilder();
		
		for(int i = 0 ; i < st.length() ; i++) 
			// if character isn't present, add(..)
			// returns true
			if(set.add(st.charAt(i)))
				result.append(st.charAt(i));
			
		return result.toString();
	}
	
	public static void main(String[] args) {
		String st = "tree traversal";
		Remove_Duplicate_Characters_in_String Remover = new 
				Remove_Duplicate_Characters_in_String();
		
		System.out.println("String: " + st);
		System.out.println("String without duplicates: " + Remover.removeDuplicates(st));
		
		st = "tree traversal my tree traversal";
		System.out.println("\n\nString: " + st);
		System.out.println("String without duplicates: " + Remover.removeDuplicates(st));
	}
}
