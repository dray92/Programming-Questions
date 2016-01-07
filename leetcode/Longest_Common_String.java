package leetcode;

import java.util.Arrays;

public class Longest_Common_String {
	
	public static String longestCommonPrefix(String[] strs) {
		
		if(strs == null || strs.length == 0) 
			return "";
		
		// length of the smallest string in the array
		// is the upper bound for the possible
		// value of the prefix string
		int minLen = Integer.MAX_VALUE;
	    for(String str: strs)
	    	minLen = (minLen > str.length()) ? str.length() : minLen;
		
	    // main goal: max possible length of prefix
	    // is minLen => loop bounds
		for(int i = 0 ; i < minLen ; i++) {
			// if valid prefix exists, the first index
			// is something that can be compared to
			char ch = strs[0].charAt(i);
			// comparing with the other indices
			for(int j = 1 ; j < strs.length ; j++) {
				if(strs[j].charAt(i) != ch || i >= strs[j].length())
					return strs[j].substring(0, i);
			}
		}
		return strs[0].substring(0, minLen);
    }

	public static void main(String[] args) {
		String[] strs = {"ch", "char", "ch"};
		System.out.println("Longest common prefix of " + Arrays.toString(strs) + " : " + longestCommonPrefix(strs));
		
		String[] strs1 = {"dog", "char", "ch"};
		System.out.println("Longest common prefix of " + Arrays.toString(strs1) + " : " + longestCommonPrefix(strs1));
		
		String[] strs2 = {"aa", "a"};
		System.out.println("Longest common prefix of " + Arrays.toString(strs2) + " : " + longestCommonPrefix(strs2));
	}
}
