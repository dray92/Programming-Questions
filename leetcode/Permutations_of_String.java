package leetcode;

import java.util.List;
import java.util.ArrayList;

public class Permutations_of_String {

	public List<String> getPermutations(String st) {
		if(st.length() == 0)
			return new ArrayList<String>();
		
		if(st.length() == 1) {
			List<String> list = new ArrayList<String>();
			list.add(st);
			return list;
		}
		
		List<String> permutations = getPermutations(st.substring(1));
		char ch = st.charAt(0);
		List<String> result = new ArrayList<String>();
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
		List<String> words = permutationGenerator.getPermutations(st);
		System.out.println("Word: " + st);
		System.out.print("Permutations: ");
		for(String word: words)
			System.out.print(word + "  ");
	}
}
