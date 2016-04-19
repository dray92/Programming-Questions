package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Word_Break {
	
	// returns true if string can be segmented into space separated
	// words, otherwise returns false
	public static boolean wordBreak2(String str, Set<String> set) {
	    int size = str.length();
	 
	    // Base case
	    if (size == 0)  
	    	return true;
	 
	    // Try all prefixes of lengths from 1 to size
	    for (int i=1; i<=size; i++) {
	        // We first check whether current prefix is in
	        // dictionary. Then we recursively check for remaining string
	        // str.substr(i, size-i) which is suffix of length size-i
	        if (set.contains( str.substring(0, i) ) &&
	            wordBreak2( str.substring(i), set ))
	            return true;
	    }
	 
	    // If we have tried all prefixes and none of them worked
	    return false;
	}
	
	

	public static void main(String[] args) {
		String dict[] = new String[]{"mobile","samsung","sam","sung","man","mango",
                "icecream","and","go","i","like","ice","cream"};
		
		Set<String> set = new HashSet<String>();
		
		for(String word: dict) 
			set.add(word);
		
		System.out.println(wordBreak2("ilikesamsung", set));
	}

}
