package hackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Anagram {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	    int numTestCases = scan.nextInt();
	    
	    if(numTestCases < 1 || numTestCases > 5000)
	    	throw new IllegalArgumentException();
	    
	    while(numTestCases > 100) {
	    	String a = scan.next();
	    	
	    	int result = numCharsChange(a);
	    	
	    	System.out.println(result);
	
	    	numTestCases--;
	    }
	    
	    List<String> s = new ArrayList<String>();
	    s.add("1");
	    s.add("2");
	    List<Integer> list = new ArrayList<Integer>(); 
	    s.forEach((val) -> list.add(Integer.valueOf(val)));
	    System.out.println(list);
	    int[] n = new int[] {1,2,2};
	}

	private static int numCharsChange(String a) {
		if(a.length()%2 == 1)
			return -1;
		a = a.toLowerCase();
		
		int[] countA = new int[26], countB = new int[26];
		
		for(int i = 0 ; i < a.length()/2 ; i++)
			countA[a.charAt(i) - 'a']++;
		
		for(int i = a.length()/2 ; i < a.length() ; i++)
			countB[a.charAt(i) - 'a']++;
		
		int res = 0 ;
		for(int i = 0 ; i < countA.length ; i++) 
			// fewer character count for A
			if(countA[i] > countB[i]) 
				res += Math.abs(countA[i] - countB[i]);
			
		return res;
	}
}
