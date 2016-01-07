package leetcode;

import java.util.Arrays;

public class Median_of_Two_Sorted_Arrays {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		int n = nums1.length, m = nums2.length;
		
		// enforce assumption nums1[n], nums2[m] such that n <= m
		if(n > m)
			return findMedianSortedArrays(nums2, nums1);
		
		/*
		 * The smaller array has only one element
		 *		Case 1: n = 1, m = 1.
		 *		Case 2: n = 1, m is odd
		 *		Case 3: n = 1, m is even
		 *	The smaller array has only two elements
		 *		Case 4: n = 2, m = 2
		 *		Case 5: n = 2, m is odd
		 *		Case 6: n = 2, m is even
		 */
		
		if(n == 1) {
			// case 1
			if(m == 1) 
				return (nums1[0] + nums2[0])/2;
			
			// case 2
			/*
			 * nums1 has 1 element
			 * nums2 -> {..., m/2-1, m/2, m/2+1, ...}
			 * take the median of nums2[m/2-1], nums2[m/2+1], nums1[0]; call it m1
			 * take the median of m1 and nums2[m/2]
			 */
			else if(m%2 != 0)
				return median2(nums2[m/2], median3(nums1[0], 
						nums2[m/2 - 1], nums2[m/2 + 1]));
		
			// case 3
			/*
			 * nums1 has 1 element
			 * nums2 -> {..., m/2-1, m/2, ...}
			 * take the median of nums2[m/2-1], nums2[m/2], nums1[0]
			 */
			return median3(nums2[m/2], nums2[m/2 - 1], nums1[0]);
		} else if(n == 2) {
			// case 4
			if(m == 2) 
				return median4(nums1[0], nums1[1], 
						nums2[0], nums2[1]);
			
			// case 5
			/*
			 * nums1 has 2 elements
			 * nums2 -> {..., m/2-1, m/2, m/2+1, ...}
			 * take the max of nums1[0] and nums2[m/2-1]; call it m1
			 * take the min of nums1[1] and nums2[m/2+1]; call it m2
			 * take the median of m1, m2 and nums2[m/2]
			 */
			else if(m%2 != 0)
				return median3(nums2[m/2], Math.max( nums1[0], 
						nums2[m/2 - 1]), Math.min( nums1[1], nums2[m/2 + 1]));
			
			// case 6
			/*
			 * nums1 has 2 elements
			 * nums2 -> {..., m/2-1, m/2, ...}
			 * take the max of nums1[0] and nums2[m/2-1]; call it m1
			 * take the max of nums1[1] and nums2[m/2+1]; call it m2
			 * take the median of m1, m2, nums2[m/2] and nums2[m/2-1]
			 */
			return median4(nums2[m/2], nums2[m/2 - 1], Math.max( nums1[0], 
					nums2[m/2 - 2] ), Math.min( nums1[1], nums2[m/2 + 1]));
		}
		
		int n1 = (n-1)/2;
		int n2 = (m-1)/2;
		
		/*
		 * if nums1[n1] <= nums2[n2], median lies 
		 * between nums1[n1, ...] and nums2[..., n2]
		 */
		if(nums1[n1] <= nums2[n2])
			return findMedianSortedArrays(Arrays.copyOfRange(nums1, n1, nums1.length), Arrays.copyOfRange(nums2, 0, nums2.length - n2 + 1));
		
		/*
		 * if nums1[n1] > nums2[n2], median lies 
		 * between nums1[..., n1] and nums2[n2, ...]
		 */
		return findMedianSortedArrays(Arrays.copyOfRange(nums1, 0, n1 + 1), Arrays.copyOfRange(nums2, n2 - 1, nums2.length));
    }
	
	public static void main(String[] args) {
		// case 2
		int[] a1 = {9};
		int[] a2 = {5, 8, 10, 20, 30};
		System.out.println("Array 1: " + Arrays.toString(a1));
		System.out.println("Array 2: " + Arrays.toString(a2));

		double median = findMedianSortedArrays(a1, a2);
		System.out.println("Case 2 || The median of the 2 arrays is: " + median + "\n\n");
		
		// case 3
		int[] a3 = {15};
		int[] a4 = {5, 8, 10, 20};
		System.out.println("Array 1: " + Arrays.toString(a3));
		System.out.println("Array 2: " + Arrays.toString(a4));

		median = findMedianSortedArrays(a3, a4);
		System.out.println("Case 3 || The median of the 2 arrays is: " + median + "\n\n");
		
		// case 5
		int[] a5 = {15, 16};
		int[] a6 = {5, 8, 10, 20, 40};
		System.out.println("Array 1: " + Arrays.toString(a5));
		System.out.println("Array 2: " + Arrays.toString(a6));

		median = findMedianSortedArrays(a5, a6);
		System.out.println("Case 5 || The median of the 2 arrays is: " + median + "\n\n");
		
		// case 6
		int[] a7 = {15, 16};
		int[] a8 = {8, 10, 20, 40};
		System.out.println("Array 1: " + Arrays.toString(a7));
		System.out.println("Array 2: " + Arrays.toString(a8));

		median = findMedianSortedArrays(a7, a8);
		System.out.println("Case 6 || The median of the 2 arrays is: " + median + "\n\n");
		
		// default nums1[n1] <= nums2[n2]
		int[] a9 = {15, 16, 35};
		int[] a10 = {8, 10, 20, 40, 55};
		System.out.println("Array 1: " + Arrays.toString(a9));
		System.out.println("Array 2: " + Arrays.toString(a10));

		median = findMedianSortedArrays(a9, a10);
		System.out.println("Default Case {arr1[n1] <= arr2[n2]} || The median of the 2 arrays is: " + median + "\n\n");
		
		// default nums1[n1] > nums2[n2]
		int[] a11 = {15, 35, 40};
		int[] a12 = {8, 10, 20, 40, 55};
		System.out.println("Array 1: " + Arrays.toString(a11));
		System.out.println("Array 2: " + Arrays.toString(a12));

		median = findMedianSortedArrays(a11, a12);
		System.out.println("Default Case {arr1[n1] > arr2[n2]} || The median of the 2 arrays is: " + median + "\n\n");
		
	}
	
	// find median of an integer and a double
	private static double median2(int a, double b) {
		return (a + b) / 2.0; 
	}
	
	// find median of three integers
	private static double median3(int a, int b, int c) {
	    return a + b + c - Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c));
	}
	 
	// find median of four integers
	private static double median4(int a, int b, int c, int d) {
	    int max = Math.max(a, Math.max(b, Math.max(c, d)));
	    int min = Math.min(a, Math.min(b, Math.min(c, d)));
	    return (a + b + c + d - max - min) / 2.0;
	}
}
