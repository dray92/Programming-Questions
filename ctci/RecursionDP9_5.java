package ctci;

import java.util.*;
/**
 * Compute all the permutations of a 
 * string of unique characters.
 * @author Debosmit
 *
 */
public class RecursionDP9_5 {
	
	public ArrayList<String> getPermutations(String st) {
		if(st == null)
			return null;
		
		ArrayList<String> permutations = new ArrayList<String>();
		// empty string gets empty string as permutation
		if(st.length() == 0) {
			permutations.add("");
			return permutations;
		}
		
		// get the first char
		char ch = st.charAt(0);
		// get the remainder of the string
		String remainder = st.substring(1);
		// get the permutations for the remainder
		ArrayList<String> remPermutations = getPermutations(remainder);
		// go over each of the permutations
		for(String permutation: remPermutations) {
			// for a certain permutation, insert the first char
			// at every possible position
			// add every permutation to the list
			StringBuilder sb = new StringBuilder(permutation);
			for(int i = 0; i <= sb.length() ; i++) {
				// insert
				sb.insert(i, ch);
				// add to list
				permutations.add(sb.toString());
				// remove inserted char to restore to original permutation
				sb.replace(i, i+1, "");
			}
		}
		return permutations;
	}

	public static void main(String[] args) {
		String st = "dog";
		
		RecursionDP9_5 permute = new RecursionDP9_5();
		ArrayList<String> list = permute.getPermutations(st);
		
		for(String word: list)
			System.out.println(word);
	}
}
