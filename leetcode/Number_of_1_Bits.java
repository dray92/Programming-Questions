package leetcode;

public class Number_of_1_Bits {
	
	public static void main(String[] args) {
		System.out.println(hammingWeight(Integer.MIN_VALUE));
	}

	public static int hammingWeight(int n) {
		int count = 0;
        while(n != 0) {
            if( (n & 0x1) == 1 )
                count++;
                
            n = n >>> 1;
        }
        return count;
    }
	
}
