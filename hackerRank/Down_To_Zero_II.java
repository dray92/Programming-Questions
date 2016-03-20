package hackerRank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/down-to-zero-ii
 * @author Debosmit
 *
 */
public class Down_To_Zero_II {

	private static final int UPPER = 1000000;
	
	private static Set<Integer> known = null;
	static {
//		// implementing Sieve of Eratosthenes to
//		// pre-compute set of primes till 'UPPER'
//		known = new HashSet<Integer>();
//		for(int i = 2 ; i < UPPER ; i++)
//			known.add(i);
//		
//		// every time, we need to get the smallest number in
//		// our set of 'known', that is greater than 'p'; say,
//		// when p = 2, we store 2 in a temporary variable and then 
//		// reset p to 3. When we need to repeat this process for p=3,
//		// we will need to remove both 2 and 3. Instead of taking this 
//		// later we simply put these values in a list and add them in later.
//		List<Integer> smallPrimes = new ArrayList<Integer>();
//		
//		int p = Collections.min(known);
//		while(p != Collections.max(known)) {
//			for(int multiplier = 2 ; multiplier <= UPPER/p ; multiplier++) 
//				known.remove(multiplier*p);
//			
//			if(Collections.min(known) == p) {
//				smallPrimes.add(p);
//				known.remove(p);
//				p = Collections.min(known);
//			}
//		}
//		known.addAll(smallPrimes);
//		System.out.println(known);
		
		// REF: http://stackoverflow.com/questions/2068372/fastest-way-to-list-all-primes-below-n-in-python/3035188#3035188
		known = new HashSet<Integer>();
		int n = UPPER;
		boolean correction = (n % 6) > 1;
		
		// closest number to calculate primes till
		switch(n%6) {
			case 0:
				break;
			case 1:
				n = n-1;
				break;
			case 2:
				n = n+4;
				break;
			case 3:
				n = n+3;
				break;
			case 4:
				n = n+2;
				break;
			case 5:
				n = n+1;
				break;
		}
		
		boolean[] sieve = new boolean[n/3];
		for(int i = 1 ; i < sieve.length ; i++)
			sieve[i] = true;
		
		for(int i = 0 ; i < (int)(Math.abs(Math.sqrt(n)) + 1) ; i++) {
			if(sieve[i]) {
				int k = (3*i + 1) | 1;
				
				// sieve[      ((k*k)/3)      ::2*k]=[False]*((n/6-(k*k)/6-1)/k+1)
				int offset = (k*k)/3;
				int stride = 2*k;
				for(int indx = offset ; indx < sieve.length ; indx+=stride)
					sieve[indx] = false;
				
				// sieve[(k*k+4*k-2*k*(i&1))/3::2*k]=[False]*((n/6-(k*k+4*k-2*k*(i&1))/6-1)/k+1)
				offset = (k * k + 4 * k - 2 * k * (i & 1) ) / 3;
				for(int indx = offset ; indx < sieve.length ; indx+=stride)
					sieve[indx] = false;
			}
		}
		
		known.add(2);
		known.add(3);
		for(int i = 0 ; i < n/3 - (correction ? 1: 0) ; i++) 
			if(sieve[i])
				known.add((3*i + 1) | 1);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		while(q > 0) {
			int n = scan.nextInt();
			takeToZero(n, 0);
			q--;
		}
		scan.close();
		
	}

	private static void takeToZero(int n, int steps) {
		if(n == 0)
			System.out.println(steps);
		
		if(n == 1)
			System.out.println(steps + 1);
		
		if(known.contains(n))
			takeToZero(n-1, steps);
		
	}
}
