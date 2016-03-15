package hackerRank;

import java.util.HashSet;
import java.util.Scanner;


/**
 * Suppose you have some string SS having length NN that is indexed from 00 to N−1N−1. You also have some string RR that is the reverse of string SS. SS is funny if the condition | S[j]−S[j−1] |=| R[j]−R[j−1] || S[j]−S[j−1] |=| R[j]−R[j−1] | is true for every jj from 11 to N−1N−1.

Note: For some string SS, S[j]S[j] denotes the ASCII value of the jthjth zero-indexed character in SS. The absolute value of some integer xx is written as | x || x |.
 * @author Debosmit
 *
 */

public class Funny_String {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        
        if(numTestCases < 1 || numTestCases > 10)
        	throw new IllegalArgumentException();
        
        while(numTestCases > 0) {
        	String st = scan.next();
        	
        	boolean result = isFunny(st);
        	
        	if(!result)
        		System.out.print("not ");
        	System.out.println("funny");
        	
        	numTestCases--;
        }
    }
	
	public static boolean isFunny(String st) {
		String rev = new StringBuilder(st).reverse().toString();
		
		for(int i = 1 ; i < st.length() ; i++) {
			int diff1 = Math.abs(st.charAt(i) - st.charAt(i-1));
			int diff2 = Math.abs(rev.charAt(i) - rev.charAt(i-1));
			if(diff1 != diff2)
				return false;
		}
		return true;
	}
}
