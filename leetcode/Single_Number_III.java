package leetcode;

public class Single_Number_III {
	
	public int[] singleNumber(int[] nums) {
        int xor = 0;
        int a = 0, b = 0;
        
        // first pass
        for(int num: nums) 
            xor ^= num;
        
        
        // xor is presently the XOR of the 2 
        // elements that appear only once
        
        // Get a number which has only one set bit of the xor.   
        // Since we can easily get the rightmost set bit, let us use it.
        // set_bit_no = xor & ~(xor-1) = (1110) & ~(1101) = 0010
        // Now set_bit_no will have only set as rightmost set bit of xor.
        int setBits = xor & ~(xor-1);
        
        for(int num: nums)
            if( (num & setBits) == 0)
                a ^= num;
            else
                b ^= num;
                
        int[] arr = new int[]{a,b};
        return arr;
    }
	
}
