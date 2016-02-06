package ctci;

import java.util.Arrays;

/**
 * Two sorted arrays A and B. A has
 * a large enough buffer at the end to 
 * hold B. Merge B into A in sorted order.
 * @author Debosmit
 *
 */
public class SortingSearching11_1 {
	
	public void mergeSortedArrays(int[] a, int[] b, int lenA, int lenB) {
		// ensuring that the length of the first array is long
		// enough to hold the contents of the second array
		if(a.length < (lenA + lenB))
			throw new IllegalArgumentException("The length of array a isn't correct");
		
		// put pointers at the end of both arrays
		// the greater number goes to the appropriate 
		// index of array a
		// pointers are moved accordingly
		
		int destinationPtr = lenA + lenB - 1;	// destination index
		lenA--;									// array a pointer
		lenB--;									// array b pointer
		
		// insert elements while there are elements left in both arrays
		while(lenA >= 0 && lenB >=0) {
			// value at pointer index in array a 
			// is greater than the value at pointer 
			// index in array b
			if(a[lenA] > a[lenB]) 
				a[destinationPtr] = a[lenA--];
			else 
				a[destinationPtr] = b[lenB--];
			
			// decrement destinationPtr
			destinationPtr--;
		}
		
		// insert remaining elements from array b
		while(lenB >= 0) 
			a[destinationPtr--] = b[lenB--];
		
		// insert remaining elements from array a
		while(lenA >= 0)
			a[destinationPtr--] = a[lenA--];
	}
	
	public static void main(String[] args) {
		SortingSearching11_1 Merger = new SortingSearching11_1();
		
		int[] a = {0, 5, 10, 15, 20, 25, 30, 0, 0, 0, 0, 0, 0};
		int[] b = {3, 8, 13, 18};
		int lenA = 7;
		int lenB = 4;
		
		System.out.println("Array a: " + Arrays.toString(a));
		System.out.println("Array b: " + Arrays.toString(b));
		
		Merger.mergeSortedArrays(a, b, lenA, lenB);
		
		System.out.println("\nAfter merging, array a: " + Arrays.toString(a));
	}
}
