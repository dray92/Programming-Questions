package projectEuler;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Problem4 {

	private static boolean isPalindrome(int n) {
		if(n < 0)
			return false;
		
		int div = 1;
		// find the divisor
		while(n/div >= 10)
			div *= 10;
		
		// any number less than 10 is a palindrome
		while(n != 0) {
			int leading = n/div;
			int trailing = n%10;
			if(leading != trailing)
				return false;
			
			// % with div gets rid of leading digit
			// dividing result by 10 gets rid of trailing digit
			n = (n % div)/10;
			
			// got rid of 2 numbers, update div accordingly
			div/=100;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Set<Integer> palindromes = new HashSet<Integer>();
		for(int i = 100 ; i <= 999 ; i++) {
			for(int j = 100 ; j <= 999 ; j++) {
				int product = i*j;
				if(isPalindrome(product))
					palindromes.add(product);
			}
		}
		System.out.println(Collections.max(palindromes));
	}
}
