package projectEuler;

import java.util.TreeSet;

public class Problem46 {
	
	private static final int UPPER = 10000;  // 1,000,000
	private static TreeSet<Integer> knownPrimes = null;
	private static TreeSet<Integer> knownSquares = null;
	
	public static void main(String[] args) {
		
		int num = 1;
		boolean found = false;
		while(!found) {
			num += 2;
			found = true;
			for(int prime: knownPrimes) {
				if(num < prime)
					break;
				if(isTwiceSquare(num - prime)) {
					found = false;
					break;
				}
			}
			if(found)
				System.out.println(num);
		}
	}
	
	private static boolean isTwiceSquare(int val) {
		double sqrt = Math.sqrt(val/2);
		return sqrt == (int)sqrt;
	}
	
	static {
		// REF: http://stackoverflow.com/questions/2068372/fastest-way-to-list-all-primes-below-n-in-python/3035188#3035188
		knownPrimes = new TreeSet<Integer>();
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
		
		knownPrimes.add(2);
		knownPrimes.add(3);
		for(int i = 0 ; i < n/3 - (correction ? 1: 0) ; i++) 
			if(sieve[i])
				knownPrimes.add((3*i + 1) | 1);
		
		knownSquares = new TreeSet<Integer>();
		for(int i = 1 ; i < UPPER ; i++) {
			int sqrt = (int) Math.sqrt(i);
			if(sqrt*sqrt == i)
				knownSquares.add(i);
		}
	}
}
