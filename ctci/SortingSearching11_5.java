package ctci;

import java.util.Arrays;

/**
 * Sorted array of strings interspersed
 * with empty strings.
 * Find the location of a given string.
 * @author Debosmit
 *
 */
public class SortingSearching11_5 {

	public int search(String[] arr, String searchString) {
		if(arr == null || searchString == null || searchString.length() == 0)
			return -1;
		
		return search(arr, searchString, 0, arr.length-1);
	}
	
	private int search(String[] arr, String searchString, int start, int end) {
		if(start > end)
			return -1;
		
		int mid = (start + end)/2;
		
		if(arr[mid].isEmpty()) {
			// find closest non empty string
			int left = mid - 1;
			int right = mid + 1;
			while(true) {
				// could not find non-empty
				if(left < start || right > end)
					return -1;
				
				// first non empty string to the right
				else if(right <= end && !arr[right].isEmpty()) {
					mid = right;
					break;
				}
				
				// first non empty string to the left
				else if(left >= start && !arr[left].isEmpty()) {
					mid = left;
					break;
				}
				
				left--;
				right++;
			}
		}
		
		// proceed with normal binary search
		if(arr[mid].compareTo(searchString) == 0)
			return mid;
		// look to left
		else if(arr[mid].compareTo(searchString) > 0)
			return search(arr, searchString, start, mid-1);
		// look to right
		else 
			return search(arr, searchString, mid+1, end);
	}
	
	public static void main(String[] args) {
		SortingSearching11_5 Searcher = new SortingSearching11_5();
		
		String[] arr = {"abc", "acb", "", "", "ball", "", "", "bat", "", "cat", "tac"};
		
		System.out.println("Array: " + Arrays.toString(arr));
		String searchString = "cat";
		int index = Searcher.search(arr, searchString);
		
		System.out.println("\"" + searchString + "\" found at: " + index);
	}
}
