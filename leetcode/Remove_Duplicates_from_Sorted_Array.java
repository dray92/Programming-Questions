package leetcode;

import java.util.Arrays;

public class Remove_Duplicates_from_Sorted_Array {

	public static int removeDuplicates(int[] nums) {
        if(nums == null) {
        	return 0;
        }
        
        if(nums.length < 2)
        	return nums.length;
        
        int lastUniqueIndex = 0;
        for(int i = 1 ; i < nums.length ; i++) {
        	if(nums[i] == nums[lastUniqueIndex])
        		continue;
        	else {
        		nums[++lastUniqueIndex] = nums[i];
        	}
        }
        System.out.println("Changed state of array: " + Arrays.toString(nums));
		return lastUniqueIndex+1;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,4,5,6,7};
		System.out.println("Original Array: " + Arrays.toString(nums));
		System.out.println("Number of unique integers: " + removeDuplicates(nums) + "\n\n");
		
		int[] nums1 = {1,1,2};
		System.out.println("Original Array: " + Arrays.toString(nums1));
		System.out.println("Number of unique integers: " + removeDuplicates(nums1) + "\n\n");
		
		int[] nums2 = {1,1};
		System.out.println("Original Array: " + Arrays.toString(nums2));
		System.out.println("Number of unique integers: " + removeDuplicates(nums2));
		
	}
}
