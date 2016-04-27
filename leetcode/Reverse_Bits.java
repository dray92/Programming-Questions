package leetcode;

// https://leetcode.com/problems/reverse-bits/
public class Reverse_Bits {
	
	// given input 43261596 (represented in binary as 00000010100101000001111010011100), 
	// return 964176192 (represented in binary as 00111001011110000010100101000000)
	public static int reverseBits(int n) {
        for(int i = 0 ; i < 16 ; i++) 
        	n = swapBits(n, i, 32-i-1);
        
        return n;
    }

	private static int swapBits(int n, int i, int j) {
		int ithBit = (n >> i) & 0x1;
		int jthBit = (n >> j) & 0x1;
		
		// if bits are the same, don't swap
		if( (ithBit ^ jthBit) != 0) 
			return n ^= (1 << i) | (1 << j);
		
		return n;
	}

	public static void main(String[] args) {
		int n = 43261596;
		System.out.println(reverseBits(n));
	}
}
