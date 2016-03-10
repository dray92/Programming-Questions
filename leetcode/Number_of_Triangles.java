package leetcode;

import java.util.Arrays;

/**
 * Given an unsorted array of positive integers. Find the 
 * number of triangles that can be formed with three 
 * different array elements as three sides of triangles. 
 * For a triangle to be possible from 3 values, the sum of any 
 * two values (or sides) must be greater than the third 
 * value (or third side).
 * @author Debosmit
 *
 */
public class Number_of_Triangles {

	public static int numTriangles(int[] arr) {
		if(arr == null || arr.length < 3)
			throw new IllegalArgumentException("Bad array");
		
		Arrays.sort(arr);
		
		int count = 0;
		
		for(int left = 0 ; left < arr.length - 2 ; left++) {
			
			for(int mid = left+1 ; mid < arr.length-1 ; mid++) {
				// with left and mid fixed, move the pointer right
				int right = mid+1;
				while( right < arr.length && arr[right] < (arr[left] + arr[mid]) )
					right++;
				
				count += (right - mid - 1);
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{10, 21, 22, 100, 101, 200, 300};
		System.out.println(Arrays.toString(arr) + " | Num triangles: " + numTriangles(arr));
		
		arr = new int[]{6, 3, 5, 4};
		System.out.println(Arrays.toString(arr) + " | Num triangles: " + numTriangles(arr));
	}
}
