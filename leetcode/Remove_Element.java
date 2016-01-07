package leetcode;

import java.util.Arrays;

public class Remove_Element {
	public static int removeElement(int[] nums, int val) {
        
		if(nums == null || nums.length == 0) {
        	return 0;
        }
        
        int lastUniqueIndex = 0;
        for(int i = 0 ; i < nums.length ; i++) {
        	if(nums[i] == val)
        		continue;
        	else {
        		nums[lastUniqueIndex++] = nums[i];
        	}
        }
        System.out.println("Changed state of array: " + Arrays.toString(nums));
		return lastUniqueIndex;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1,1};
		System.out.println("Original Array: " + Arrays.toString(nums));
		System.out.println("New length: " + removeElement(nums,1) + "\n\n");
		
		int[] nums1 = {1,1,2};
		System.out.println("Original Array: " + Arrays.toString(nums1));
		System.out.println("New length: " + removeElement(nums1,1) + "\n\n");
//		
		int[] nums2 = {1,1,2};
		System.out.println("Original Array: " + Arrays.toString(nums2));
		System.out.println("New length: " + removeElement(nums2,2));
		
	}
}
