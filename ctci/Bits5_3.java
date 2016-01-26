package ctci;

/**
 * Given a positive integer, 
 * find the next smallest and largest number 
 * with the same number of 1 bits.
 * @author Debosmit
 *
 */
public class Bits5_3 {

	
	public int getPrev(int i) {
		if (!hasValidPrev(i)) {
			return -1;
		}		
		int num_ones = countOnes(i);
		i--;	// make sure number is lesser than given i
		
		// keep subtracting 1 from number till the number of 
		// 1 bits is equal to the number of 1 bits in the 
		// original number	
		while (countOnes(i) != num_ones) 
			i--;
		
		return i;
	}
	
	public int getNext(int i) {
		if (!hasValidNext(i)) {
			return -1;
		}
		int num_ones = countOnes(i);
		i++;	// make sure number is greater than given i
		
		// keep adding 1 to number till the number of 1 bits
		// is equal to the number of 1 bits in the original
		// number
		while (countOnes(i) != num_ones) 
			i++;
		
		return i;
	}
	
	private boolean hasValidPrev(int i) {
		// keep shifting ones to the right
		while ((i & 1) == 1) 
			i >>= 1;
		
		// when first 0 bit was the LSB,
		// while stopped
		// now, LSB = 0. If entire number is 0
		// it cannot have a smaller number 
		// with same bits
		if (i == 0) 
			return false;
		
		return true;		
	}
	
	private boolean hasValidNext(int i) {
		// if all bits are 0's,
		// this is the biggest possible number
		// with the given bits
		if (i == 0) 
			return false;
		
		int count = 0;
		// getting all the 0 bits before encountering
		// first 1 bit
		while ((i & 1) == 0) {
			i >>= 1;
			count++;
		}
		// getting all the 1 bits before encountering
		// first 0 bit
		while ((i & 1) == 1) {
			i >>= 1;
			count++;
		}
		// given number is a sequence of 1's
		// followed by a sequence of 0's
		// can't have a number bigger than this
		// with the given bits
		if (count == 31) 
			return false;
		
		return true;	
	}
	
	private int countOnes(int i) {
		int count = 0;
		while (i > 0) {
			if ((i & 1) == 1) {
				count++;
			}
			// when LSB is 0, keep right shifting
			// till next 1 bit is at LSB position
			i = i >> 1;
		}
		return count;
	}
	
	public int getPrevFast(int n) {
		int temp = n;
		int count0 = 0;
		int count1 = 0;		// number of 1's before any 0's
		while ((temp & 1) == 1) {
			count1++;
			temp >>= 1;
		}
		
		/* If temp is 0, 'n' is a sequence of 0s followed by a sequence of 1s. This 
		 * is already the smallest number with count1 ones.
		 */
		if (temp == 0) 
			return -1;
		
		// after the 1's, counting the sequence of 0's
		// before a 1
		while (((temp & 1) == 0) && (temp != 0)) {
			count0++;
			temp >>= 1;
		}

		int position = count0 + count1; // position of right-most non-trailing one 
								 // (where the right most bit is bit 0)
								 // Ex, for n = 5 which is 101
								 // count1 = 1 for the rightmost 1
								 // count0 = 1 for the 0 at index 1
								 // p = 2 for the 1 at index 2

		/* Flip right-most non-trailing one. 
		 * n = 0 0 0 1 1 1 0 0 0 1 1
		 * count1 = 2
		 * count0 = 3
		 * position = 5
		 * 
		 * REFERENCE: 
		 * 		https://github.com/gaylemcd/ctci/blob/master/java/Chapter%205/Question5_3/Question.java
		 * 
		 * 
		 * Build up a mask as follows:
		 * (1) ~0 will be a sequence of 1s
		 * (2) shifting left by p + 1 will give you 11...11000000 (six 0s and a bunch of 1's) 
		 * (3) ANDing with n will clear the last 6 bits
		 * 
		 * 		~0         1 1 1 1 1 1 1 1 1 1 1
		 * 	
		 *  ~0 << (5+1) ...1 1 1 1 1 0 0 0 0 0 0
		 *      n          0 0 0 1 1 1 0 0 0 1 1
		 * n after AND     0 0 0 1 1 0 0 0 0 0 0
		 */
		n &= ((~0) << (position + 1)); // clears from bit p onwards (inclusive, to the right)
		
		/* Create a sequence of (count1 + 1) 1s as follows
		 * (1) Shift 1 to the left (count1 + 1) times. If c1 is 2, this will give you 0..001000
		 * (2) Subtract one from that. This will give you 0..00111
		 * 
		 * shift 1 to the 
		 * left count1 + 1 
		 * times		   0 0 0 0 0 0 0 1 0 0 0	
		 * 
		 * subtract 1      0 0 0 0 0 0 0 0 1 1 1
		 */
		int mask = (1 << (count1 + 1)) - 1; // Sequence of (c1+1) ones
		
		/* Move the ones to be right up next to bit p 
		 * Since this is a sequence of (c1+1) ones, and p = c1 + c0, we just need to
		 * shift this over by (c0-1) spots.
		 * If c0 = 3 and c1 = 2, then this will look like 00...0011100
		 * 
		 * mask prev       0 0 0 0 0 0 0 0 1 1 1
		 * 
		 * shifted mask    0 0 0 0 0 0 1 1 1 0 0
		 * 
		 *     n           0 0 0 1 1 0 0 0 0 0 0
		 *     
		 *   result        0 0 0 1 1 0 1 1 1 0 0
		 * Then, finally, we OR this with n.
		 */
		n |= mask << (count0 - 1);  
		
		return n;		
	}
	
	public int getNextFast(int n) {
		int c = n;
		int count0 = 0;		// number of 0's before any 1's
		int count1 = 0;		
		while (((c & 1) == 0) && (c != 0)) {
			count0++;
			c >>= 1;
		}
		
		while ((c & 1) == 1) {
			count1++;
			c >>= 1;
		}
		
		/* If c is 0 here, n is sequence of count 1 1s followed by a sequence of count0 0s.
		 * This is the biggest number with count1 1s. Return error.
		 * getting rid of following case:
		 * 	1 1 1 1....0 0 0 0
		 */
		if (count0 + count1 == 31 || count0 + count1 == 0) 
			return -1;
		
		
		int pos = count0 + count1; // position of right-most non-trailing zero (where the right most bit is bit 0)
		
		/* Flip the right-most non-trailing zero (which will be at position pos) */
		n |= (1 << pos); // Flip right-most non-trailing zero
				
		/* Clear all bits to the right of pos.
		 * Example with pos = 5 
		 * (1) Shift 1 over by 5 to create 0..0100000           [ mask = 1 << pos ]
		 * (2) Subtract 1 to get 0..0011111                     [ mask = mask - 1 ]
		 * (3) Flip all the bits by using '~' to get 1..1100000 [ mask = ~mask    ]
		 * (4) AND with n
		 */
		n &= ~((1 << pos) - 1); // Clear all bits to the right of pos
		
		/* Put (ones-1) 1s on the right by doing the following:
		 * (1) Shift 1 over by (ones-1) spots. If ones = 3, this gets you 0..0100
		 * (2) Subtract one from that to get 0..0011
		 * (3) OR with n
		 */
		n |= (1 << (count1 - 1)) - 1;
		
		return n;
	}
	
	public static void printBinary(int i) {
		System.out.println("Integer " + i + " in binary: " + Integer.toBinaryString(i));		
	}
	
	public static void main(String[] args) {
		Bits5_3 bitShift = new Bits5_3();
		for (int i = 0; i < 200; i++) {
			int p1 = bitShift.getPrev(i);
			int p2 = bitShift.getPrevFast(i);
			int n1 = bitShift.getNext(i);
			int n2 = bitShift.getNextFast(i);
			
			if (p1 != p2 || n1 != n2) {
				printBinary(i);
				printBinary(p1);
				printBinary(p2);
				
				printBinary(n1);
				printBinary(n2);
				
				System.out.println("");
			}			
		}
		System.out.println("Done!");
	}
	
}
