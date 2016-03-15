package hackerRank;

import java.util.Scanner;

/**
 * Shashank likes strings in which consecutive characters are different. For example, he likes ABABA, while he doesn't like ABAA. Given a string containing characters AA and BB only, he wants to change it into a string he likes. To do this, he is allowed to delete the characters in the string.

Your task is to find the minimum number of required deletions.
 * @author Debosmit
 *
 */
public class Alternating_Characters {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        
        if(numTestCases < 1 || numTestCases > 10)
        	throw new IllegalArgumentException();
        
        while(numTestCases > 0) {
        	String st = scan.next();
        	
        	int result = numConsecSame(st);
        	
        	System.out.println(result);
        	
        	numTestCases--;
        }
    }

	private static int numConsecSame(String st) {
		int count = 0;
		for(int i = 1; i < st.length() ; i++)
			if(st.charAt(i) == st.charAt(i-1))
				count++;
		return count;
	}
}
