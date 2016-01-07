package leetcode;

/*
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 */

public class Longest_Palindromic_Substring {
	
	/*
	 * We maintain a boolean table[n][n] that is filled in bottom up manner. 
	 * The value of table[i][j] is true, if the substring is palindrome, 
	 * otherwise false. To calculate table[i][j], we first check the value 
	 * of table[i+1][j-1], if the value is true and s.charAt(i) is same as s.charAt(j), 
	 * then we make table[i][j] true. Otherwise, the value of table[i][j] is made false.
	 */
	public static String longestPalindrome(String s) {
		
		if(s == null || s.length() == 0)
			return "";
		
		int len = Math.min(s.length(), 1000);
     
		boolean[][] table = new boolean[len][len];
		
		// All substrings of length 1 are palindromes
	    int maxLength = 1;
	    for (int i = 0; i < len; ++i)
	        table[i][i] = true;
	    
	    // check for substring of length 2.
	    int start = 0;
	    for (int i = 0; i < len - 1; ++i) {
	        if (s.charAt(i) == s.charAt(i+1)) {
	            table[i][i+1] = true;
	            start = i;
	            maxLength = 2;
	        }
	    }
	
	    // Check for substring of lengths greater 
	    // than 2. k is length of substring
	    for (int k = 3; k <= len; ++k) {
	        // Fix the starting index
	        for (int i = 0; i < len-k+1 ; ++i) {
	            // Get the ending index of substring from
	            // starting index i and length k
	            int j = i + k - 1;
	 
	            // checking for sub-string from i-th index to
	            // j-th index iff s[i+1] to s[j-1] is a
	            // palindrome
	            if (table[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
	                table[i][j] = true;
	 
	                if (k > maxLength) {
	                    start = i;
	                    maxLength = k;
	                }
	            }
	        }
	    }
	    
		return s.substring(start, start + maxLength);
    }
	
	/*
	 * The idea is to generate all even length and odd length palindromes and keep track of the longest palindrome seen so far.
	 * Step to generate odd length palindrome:
	 * 		Fix a center and expand in both directions for longer palindromes.
	 * Step to generate even length palindrome:
	 * 		Fix two center ( low and high ) and expand in both directions for longer palindromes.
	 */
	public static String longestPalindromeString(String s) {
		
		if(s == null || s.length() == 0)
			return "";
		
		int maxLength = 1, start = 0, len = s.length();
		int low, high;
		
		// each index is considered to be the center of a
		// palindrome of both an odd and an even length
		for(int i = 1 ; i < len ; i++) {
			// even length
			low = i-1;
			high = i;
			while (low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
	            if (high - low + 1 > maxLength) {
	                start = low;
	                maxLength = high - low + 1;
	            }
	            low--;
	            high++;
	        }
			
			// odd length
			low = i-1;
			high = i+1;
			while (low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
	            if (high - low + 1 > maxLength) {
	                start = low;
	                maxLength = high - low + 1;
	            }
	            low--;
	            high++;
	        }
			
		}
		return s.substring(start, start + maxLength);
	}
	
	public static void main(String[] args) {
		String s = "a";
		System.out.println("String is: " + s);
		System.out.println("Longest palindromic substring is: " + longestPalindromeString(s));
		System.out.println();
		
		s = "aa";
		System.out.println("String is: " + s);
		System.out.println("Longest palindromic substring is: " + longestPalindromeString(s));
		System.out.println();
		
		s = "aaa";
		System.out.println("String is: " + s);
		System.out.println("Longest palindromic substring is: " + longestPalindromeString(s));
		System.out.println();
		
		s = "forgeeksskeegfor";
		System.out.println("String is: " + s);
		System.out.println("Longest palindromic substring is: " + longestPalindromeString(s));
		System.out.println();
	}
}