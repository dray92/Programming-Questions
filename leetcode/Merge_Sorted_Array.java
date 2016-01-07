package leetcode;

import java.util.Arrays;

public class Merge_Sorted_Array {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] nums = new int[nums1.length];
//		System.arraycopy(nums, 0, nums1, 0, nums1.length);
		
        // assumption -> size of nums1 is at least m+n
		for(int i = 0 ; i < m ; i++)
			nums[i+n] = nums1[i];

		System.out.println("nums1 modified: " + Arrays.toString(nums));

		
		// range of values in nums1 -> m to m+n-1
		// range of values in nums2 -> 0 to n-1
		
		int ptr = 0, ptr1 = m, ptr2 = 0;
		while(ptr1 < m+n || ptr2 < n) {
			// take values from nums2
			if(ptr1 == m+n)
				nums[ptr] = nums2[ptr2++];
				
			// take values from nums1
			else if(ptr2 == n)
				nums[ptr] = nums1[ptr1++];
		
			// base case where both arrays have elements left
			else {
				if(nums1[ptr1] < nums2[ptr2]) 
					nums[ptr] = nums1[ptr1++];
				else
					nums[ptr] = nums2[ptr2++];
			}
			System.out.println("nums1 modified: " + Arrays.toString(nums));

			ptr++;
		}
    }
	
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 5, 7, 0, 0, 0, 0, 0, 0};
		int[] nums2 = {0, 3, 6, 8};
		System.out.println("nums1: " + Arrays.toString(nums1));
		System.out.println("nums2: " + Arrays.toString(nums2));
		merge(nums1, 4, nums2, 4);
		System.out.println("Merged: " + Arrays.toString(nums1));

 	}
}
