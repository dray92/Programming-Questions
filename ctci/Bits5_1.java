package ctci;

/**
 * Two 32-bit numbers, N & M, and 2 bit
 * positions, i and j are given to you. Insert M
 * into N such that M starts at bit j and ends at bit i.
 * Assume bits j through i have enough space for M.
 * If M = 10011, there are at least 5 spaces between 
 * j and i.
 * N = 10000000000 <10 0's>
 * M = 10011
 * i = 2, j = 6
 * N = 10001001100
 * 
 * @author Debosmit
 *
 */

public class Bits5_1 {
	public int getModifiedBits(int n, int m, int i , int j) {
		// check
		if(i > 32 || j < 0)
			throw new IllegalArgumentException("Issue with values of i or j.");
		
		// clear bits in [j,i]
		int ones = ~0;	// full of 1's; eg. 11111111
		
		int leftOnes = ones << (j+1);	// if j = 2, 11111000
		int rightOnes = (1 << i) - 1;	// if i = 1, 00000001
		int mask = leftOnes | rightOnes;// j=2, i=1, 11111001
		
		// apply mask to n
		n &= mask;
		
		// move m to starting point, i.e., i
		m <<= i;
		
		return (n|m);
	}
	
	public static void main(String[] args) {
		int n = 19;	// 10011
		int m = 5;	// 101
		int j = 3, i = 1;
		// 1 0 0 1 1 = 19
		//	 1 0 1	 = 5
		// 1 1 0 1 1 = 27
		System.out.println("Returned value: " + new Bits5_1().getModifiedBits(n, m, i, j));
	}
}
