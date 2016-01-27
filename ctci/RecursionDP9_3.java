package ctci;

import java.util.Arrays;

/**
 * Magic index in an array is said to 
 * be the index at which the value is
 * equal to the index.
 * Eg. [1, 1, 3, 5, 7]
 * in this array, the 1 at index 1 is
 * the magic index
 * Find the magic index given a sorted
 * array. What if the elements aren't distinct?
 * @author Debosmit
 *
 */
public class RecursionDP9_3 {

	public int getMagicIndex(int[] arr) {
		return getMagicIndex(arr, 0, arr.length - 1);
	}

	private int getMagicIndex(int[] arr, int start, int end) {
		if(arr == null || start < 0 || start > end || end >= arr.length)
			return -1;
		
		// checking if value at the mid of the array is equal to index
		int mid = (start + end)/2;
		int midVal = arr[mid];
		
		if(mid == midVal)
			return mid;
		
		// [-100, -2, 2, 2, 3, 3, 5, 7, 9, 14, 15]
		//    0    1  2  3  4  5  6  7  8   9  10
		
		// midIndex and midValue were not the same
		// magic index can be to the left or right of this midIndex
		// to search to the left, start index will not change
		// need to find the end index: know that the array is sorted 
		// and that magic index occurs when index and indexVal are the same
		// first criteria: new end cannot be greater than mid-1
		// second criteria: new end can be value at current mid
		// this is because the array is sorted
		
		// in the array above arr[5] = 3
		// mid - 1 = 4 and midVal = 3
		// can arr[4] possibly be the magic index?
		// no. since, we have 3 at index 5, and since 
		// the arr is sorted, value at index 4 cannot 
		// be greater than 3.
		// so, we can directly jump to index 3 and continue
		// from there.
		int left = getMagicIndex(arr, start, Math.min(mid-1, midVal));
		if(left > -1)
			return left;
		
		// [-100, -2, 2, 2, 3, 7, 7, 8, 9,  9, 15]
		//    0    1  2  3  4  5  6  7  8   9  10
		
		// in the array above, we have arr[5] = 7
		// mid + 1 = 6 and midVal = 6
		// can arr[6] possibly be the magic index?
		// no. since, we have 7 at index 5, and since 
		// the arr is sorted, value at index 6 cannot 
		// be lesser than 7.
		// so, we can directly jump to index 7 and continue
		// from there.
		int right = getMagicIndex(arr, Math.max(mid+1, midVal), end);
		return right;
	}
	
	// returns a new number in [min, max];
	private static int randomWithRange(int min, int max) {
		if(max < min)
			return randomWithRange(max, min);
		
		int range = (max - min) + 1;     
		return (int)((Math.random() * range) + min);
	}
	
	public static void main(String[] args) {
		RecursionDP9_3 magic = new RecursionDP9_3();
		int size = randomWithRange(5, 20);
		int[] arr = new int[size];
		
		for(int i = 0; i < size ; i++)
			arr[i] = randomWithRange(-size, size);
		Arrays.sort(arr);
		
		System.out.println("Array of size " + size + ": " + Arrays.toString(arr));
		System.out.println("Magic index: " + magic.getMagicIndex(arr));
	}
	
}
