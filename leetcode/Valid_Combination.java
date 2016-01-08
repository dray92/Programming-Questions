package leetcode;

import java.util.HashSet;

/*
 * We are given 3 strings: str1, str2, and str3. Str3 is said to be a 
 * shuffle of str1 and str2 if it can be formed by interleaving 
 * the characters of str1 and str2 in a way that maintains 
 * the left to right ordering of the characters from each string. 
 * For example, given str1=”abc” and str2=”def”, str3=”dabecf” is 
 * a valid shuffle since it preserves the character ordering of
 *  the two strings. 
 *  So, given these 3 strings write a function that 
 *  detects whether str3 is a valid shuffle of str1 and str2.
 */
public class Valid_Combination {
	public boolean isValidShuffle(String st1, String st2, String st, 
			HashSet<Tuple<String, String>> falseTuples) {
		if(tupleExists(st1, st2, falseTuples))
			return false;
		
		if(st1.length() + st2.length() != st.length())
			return false;
		
		if(st.isEmpty() || st1.isEmpty() || st2.isEmpty()) {
			if(st.equals(st1+st2))
				return true;
			return false;
		}
		
		if((st1.charAt(0) != st.charAt(0)) && (st2.charAt(0) != st.charAt(0)))
			return false;
		
		if(st.charAt(0) == st1.charAt(0) && 
				isValidShuffle(st1.substring(1), st2, st.substring(1), falseTuples))
			return true;
		
		if(st.charAt(0) == st2.charAt(0) && 
				isValidShuffle(st1, st2.substring(1), st.substring(1), falseTuples))
			return true;
		
		falseTuples.add(new Tuple<String, String>(st1, st2));
		
		return false;
	}
	
	private boolean tupleExists(String st1, String st2, HashSet<Tuple<String, String>> set) {
		for(Tuple<String, String> t: set) 
			if(t.x.equals(st1) && t.y.equals(st2))
				return true;
		
		return false;
	}
	
	public class Tuple<X, Y> { 
		public final X x; 
		public final Y y; 
		
		public Tuple(X x, Y y) { 
			this.x = x; 
			this.y = y; 
		} 
	} 
	
	public static void main(String[] args) {
		Valid_Combination combo = new Valid_Combination();
		String st1 = "abc";
		String st2 = "def";
		String st = "adbecf";
		System.out.println("String 1: " + st1);
		System.out.println("String 2: " + st2);
		System.out.println("String: " + st);
		System.out.println("Valid Combination? " + combo.isValidShuffle(st1, st2, st, new HashSet<Tuple<String, String>>()));
	}
}
