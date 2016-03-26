package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Permutations_of_String {

	public Set<String> getPermutations(String st) {
		if(st.length() == 0)
			return new HashSet<String>();
		
		if(st.length() == 1) {
			Set<String> list = new HashSet<String>();
			list.add(st);
			return list;
		}
		
		Set<String> permutations = getPermutations(st.substring(1));
		char ch = st.charAt(0);
		Set<String> result = new HashSet<String>();
		for(String permutation: permutations) {
			StringBuilder permutationSB = new StringBuilder(permutation);
			for(int i = 0 ; i <= permutationSB.length() ; i++) {
				permutationSB.insert(i, ch);
				result.add(permutationSB.toString());
				permutationSB.replace(i, i+1, "");
			}
				
		}
		return result;
	}
	
	public static void main(String[] args) {
		Permutations_of_String permutationGenerator = new Permutations_of_String();
		String st = "aa";
		Set<String> words = permutationGenerator.getPermutations(st);
		System.out.println("Word: " + st);
		System.out.print("Permutations: ");
		for(String word: words)
			System.out.print(word + "  ");
	}
}
