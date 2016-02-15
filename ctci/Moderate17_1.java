package ctci;

/**
 * Swap a number in place
 * @author Debosmit
 *
 */
public class Moderate17_1 {

	public void swap(int[] arr, int indx1, int indx2) {
		if(arr == null || 
				indx1 > arr.length - 1 || indx1 < 0 || 
				indx2 > arr.length - 1 || indx2 < 0)
			throw new IllegalArgumentException("Illegal args");
		
		if(indx1 == indx2)
			return;
		
		arr[indx1] ^= arr[indx2];
		arr[indx2] ^= arr[indx1];
		arr[indx1] ^= arr[indx2];
	}
}
