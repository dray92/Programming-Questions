package leetcode;

import org.apache.commons.lang3.StringUtils;

/*
 * Given an input string, reverse all the words. To clarify, 
 * input: “Interviews are awesome!” output: “awesome! are Interviews”. 
 * Consider all consecutive non-whitespace characters as 
 * individual words. If there are multiple spaces between words 
 * reduce them to a single white space. Also remove all leading and 
 * trailing whitespaces. So, the output for ”   CS degree”, “CS    degree”, 
 * “CS degree   “, or ”   CS   degree   ” are all the same: “degree CS”.
 */
public class Reverse_Words_in_String {
	
	public String reverseOrderWords(String st) {
		// getting rid of the unneeded spaces
		st = StringUtils.normalizeSpace(st);
		if(st.length() < 2)
			return st;
		
		// every time a string variable is modified, a new one is created
		// that is why a StringBuilder is used.
		return reverseOrderWords(new StringBuilder(st)).toString();
	}

	private StringBuilder reverseOrderWords(StringBuilder st) {
		
		reverseString(st, 0, st.length()-1);
		// setting up read and write pointers
		int read = 0;
		while(read < st.length()) {
			if(st.charAt(read) != ' ') {
				int startIndex = read;
				// keep updating read pointer till end of word reached
				for ( ; read < st.length() && st.charAt(read)!=' '; read++);
				reverseString(st, startIndex, read-1);
			}
			read++;
		}
		return st;
	}

	private void reverseString(StringBuilder st, int start, int end) {
		
		int len = end - start + 1;
		for(int i = 0 ; i < len/2 ; i++) {
			char chFirst = st.charAt(start + i);
			char chSecond = st.charAt(end - i);
			st.replace(start+i, start+i+1, "" + chSecond);
			st.replace(end-i, end-i+1, "" + chFirst);
		}
	}

	public static void main(String[] args) {
		String st = "Interviews are awesome!";
		System.out.println("String: " + st);
		Reverse_Words_in_String reverser = new Reverse_Words_in_String();
		System.out.println("New String: " + reverser.reverseOrderWords(st));
	}
}
