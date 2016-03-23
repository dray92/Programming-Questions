package projectEuler;

import java.util.Set;
import java.util.TreeSet;

public class Problem7 {
	
	private static final int UPPER = 1000000;
	private static Set<Integer> known = null;
	
	public static void main(String[] args) {
		System.out.println("Found " + known.size() + " primes");
		System.out.println(known);
		int i = 10001;
		System.out.println(i + "th prime is: " + known.toString().split(",")[i-1]);
		
	}
	
	static {
		// REF: http://stackoverflow.com/questions/2068372/fastest-way-to-list-all-primes-below-n-in-python/3035188#3035188
		known = new TreeSet<Integer>();
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

}
