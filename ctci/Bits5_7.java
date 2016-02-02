package ctci;

/** 
 * An array contains integer from 
 * 0 to n, except for one number which is
 * missing. In this problem, we cannot
 * access an entire integer in A with
 * a single operation. The elements of A are 
 * represented in binary, and the only
 * operation we can use to access them is
 * "fetch the j-th bit of A[i]," which takes
 * constant time. Find the missing integer in
 * linear time, i.e., O(n).
 * @author Debosmit
 *
 */
public class Bits5_7 {

	/*
	 * n is the length of the list
	 * v is the value removed from list
	 *  consider the LSB of numbers from
	 *  0 to n
	 *  for n = 3, arr = {0,1,2,3}
	 *  0 -> 0 0 0 0
	 *  1 -> 0 0 0 1
	 *  2 -> 0 0 1 0
	 *  3 -> 0 0 1 1
	 *  
	 *  Considering LSBs, number of 0's = 2
	 *  and number of 1's = 2
	 *  
	 *  for n = 4, arr = {0,1,2,3,4}
	 *  0 -> 0 0 0 0
	 *  1 -> 0 0 0 1
	 *  2 -> 0 0 1 0
	 *  3 -> 0 0 1 1
	 *  4 -> 0 1 0 0
	 *  Considering LSBs, number of 0's = 3
	 *  and number of 1's = 2
	 *  
	 *  So, for n%2 == 0, count(0s) - 1 = count(1s)
	 *  for n%2 == 1, count(0s) = count(1s)
	 *  
	 *  Cases:
	 *  n % 2 == 0
	 *  	v % 2 == 0	expected, count(0s) - 1 = count(1s)
	 *  				found, count(0s) = count(1s)
	 *  	v % 2 == 1	expected, count(0s) - 1 = count(1s)
	 *  				found, count(0s) > count(1s), since count(0s) - 2 = count(1s)
	 *  
	 *  n % 2 == 1
	 *  	v % 2 == 0	expected, count(0s) = count(1s)
	 *  				found, count(0s) < count(1s), since count(0s) + 1 = count(1s)
	 *  	v % 2 == 1	expected, count(0s) = count(1s)
	 *  				found, count(0s) < count(1s), since count(0s) = count(1s) + 1
	 *  
	 *  Hence, if count(0s) >= count(1s) => even number removed
	 *  	   if count(0s) < count(1s) => odd number removed
	 *  
	 *  
	 *  Now, same process holds for the second LSB, instead of the first LSB,
	 *  i.e., instead of bit 0, look at bit 1.
	 */
	
	
	public class BitInts {
		public int INTEGER_SIZE;
		private Boolean[] bits;
		
		public BitInts() {
			bits = new Boolean[INTEGER_SIZE];
		}
		
		/**
		 * creates a new BitInt for the number n
		 * time: proportional to the size of the 
		 * array, i.e., INTEGER_SIZE
		 */
		public BitInts(int n) {
			// initialize bits array
			this();
			
			// set values in bits array
			for(int i = 0 ; i < INTEGER_SIZE ; i++) 
				// get i-th bit and set appropriate
				// index in the bits array
				// for i = 0, array index is INTEGER_SIZE - 0 - 1
				// 0-th bit = (n >> 0) & 1
				// if result is 1, 0-th bit is 1, 0 otherwise
				bits[INTEGER_SIZE - i - 1] = ((n >> i) & 1) == 1;
		}
		
		/**
		 * returns the k-th MSB
		 * for instance, bit 0 is the 0-th MSB or the LSB.
		 * @param k-th most significant bit
		 * @return
		 */
		public int getBit(int k) {
			return this.bits[INTEGER_SIZE - k - 1] ? 1 : 0;
		}
		
		/**
		 * sets the k-th MSB
		 * for instance, bit 0 is the 0-th MSB or the LSB.
		 * @param k
		 * @param bitVal
		 */
		public void setBit(int k, int bitVal) {
			// bitVal & 1 is done to ensure that only the
			// LSB of bitVal is considered for the check
			this.bits[INTEGER_SIZE - k - 1] = (bitVal & 1) == 1;
		}
		
		/**
		 * sets the k-th MSB
		 * for instance, bit 0 is the 0-th MSB or the LSB.
		 * @param k
		 * @param bitVal
		 */
		public void setBit(int k, char bitVal) {
			this.bits[INTEGER_SIZE - k - 1] = bitVal != '0';
		}
		
		/**
		 * sets the k-th MSB
		 * for instance, bit 0 is the 0-th MSB or the LSB.
		 * @param k
		 * @param bitVal
		 */
		public void setBit(int k, boolean bitVal) {
			this.bits[INTEGER_SIZE - k - 1] = bitVal;
		}
		
		/**
		 * integer representation of this BigInt
		 * @return the integer value of this BigInt
		 */
		public int getInt() {
			int num = 0;
			for(int i = 0 ; i < INTEGER_SIZE ; i++) 
				num += getBit(i) * (int)Math.pow(2, i);
			return num;
		}
	}
	
}
