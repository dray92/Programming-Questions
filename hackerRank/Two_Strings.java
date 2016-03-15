package hackerRank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * You are given two strings, AA and BB. Find if there is a substring that appears in both AA and BB.
 * @author Debosmit
 *
 */
public class Two_Strings {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        
        if(numTestCases < 1 || numTestCases > 10)
        	throw new IllegalArgumentException();
        
        while(numTestCases > 0) {
        	String a = scan.next();
        	String b = scan.next();
        	
        	System.out.println(substringPossible(a, b) ? "YES" : "NO");
        	
        	numTestCases--;
        }
    }

	private static boolean substringPossible(String a, String b) {
		Set<Character> setA = new HashSet<Character>();
		for(int i = 0 ; i < a.length() ; i++)
			setA.add(a.charAt(i));
		
		Set<Character> setB = new HashSet<Character>();
		for(int i = 0 ; i < b.length() ; i++)
			setB.add(b.charAt(i));
				
		for(Character c: setA)
			if(!setB.add(c))
				return true;
		return false;
	}
}
