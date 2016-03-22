package hackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
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
	private static Map<Integer, List<Integer>> factors;
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
		
		factors = new HashMap<Integer, List<Integer>>();
		for(int i = 2 ; i <= n ; i++) {
			if(known.contains(n))
				continue;
			List<Integer> factorsOfN = new ArrayList<Integer>();
			for(int factor = 2 ; factor < Math.sqrt(i) ; factor++)
				if(i % factor == 0)
					factorsOfN.add( Math.max(factor, i/factor) );
			factors.put(i, factorsOfN);
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		while(q > 0) {
			int n = scan.nextInt();
			System.out.println( takeToZero(n) );
			q--;
		}
		scan.close();
	}

	private static Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
	private static int takeToZero(int n) {
		if(cache.containsKey(n))
			return cache.get(n);
		
		if(n == 0)
			return 0;
		
		if(n == 1)
			return (1);
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add( 1 + takeToZero(n-1) );
		
		// if number is not prime
		if(!known.contains(n)) {
			
			if(!factors.containsKey(n)) {
				// add number of steps for each of the factors
				for(int i = 2 ; i <= Math.sqrt(n) ; i++) 
					if(n % i == 0) 
						pq.add( 1 + takeToZero( Math.max(i, n/i)) );
			} else {
				for(int factor: factors.get(n) )
					pq.add( 1 + factor );
			}				
		}	
		cache.put(n, pq.poll());
		return cache.get(n);
	}
}