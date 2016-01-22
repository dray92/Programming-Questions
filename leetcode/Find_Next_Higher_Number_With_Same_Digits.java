package leetcode;

/**
 * Given a number, find the next higher number using only 
 * the digits in the given number. For example if the given 
 * number is 1234, next higher number with same digits is 1243.
 * @author Debosmit
 *
 */
public class Find_Next_Higher_Number_With_Same_Digits {
	public int getNextHighest(int num) {
		StringBuilder val = new StringBuilder(""+num);
		
		int pivot;
		
		// get the digit that has to be switched
		for(pivot = val.length() - 2 ; pivot >=0 ; pivot--) 
			if(val.charAt(pivot) < val.charAt(pivot+1))
				break;
		
		// if everything to the right of this pivot
		// is sorted, the smallest of that subset of
		// digits will be at pivot+1; this digit will
		// not necessarily be greater than the digit at pivot; 
		// swapping pivot with a number in the sorted set
		// that is greater than the pivot value will yield
		// the required number
		
		// need to sort indices [pivot+1, val.length()-1]
		// single pass radix sort would work since we have
		// only digits ranging from 0 to 9.
		
		// get digits for the remainder of the list
		int numDigits = val.length() - (pivot + 1);
		int[] digits = new int[numDigits];
		for(int i = 0 ; i < digits.length ; i++)
			digits[i] = val.charAt(i + (pivot + 1)) - '0';
		
		// sort the digits
		// note: sorting can also be replaced with reversing
		// order of digits since they must be a0 >= a1 >= a3 ...
		RadixSort Sort = new RadixSort();
		Sort.sort(digits);
		
		// swap index pivot with appropriate
		// value in digits that is greater than current
		// value of pivot;
		// after this process, array must remain sorted
		// since oldPivotValue is being put at the index of value 
		// that is greater than it; it is also ensured that the 
		// values at all indices before this are less than 
		// or equal to the oldPivotValue
		int oldPivotVal = val.charAt(pivot) - '0';
		for(int i = 0 ; i < digits.length ; i++) {
			if(digits[i] > oldPivotVal) {
				val.setCharAt(pivot, (char)(digits[i] + '0'));
				digits[i] = oldPivotVal;
				break;
			}
		}
		
		// replace indices [pivot+1, val.length()-1] with
		// values from sorted array
		for(int i = 0 ; i < digits.length ; i++)
			val.setCharAt(i + (pivot + 1), (char)(digits[i] + '0'));
		
		return Integer.parseInt(val.toString());
	}
	
	public static void main(String[] args) {
		Find_Next_Higher_Number_With_Same_Digits Next = new 
				Find_Next_Higher_Number_With_Same_Digits();
		
		int num = 12543;
		System.out.println("Num: " + num);
		System.out.println("Next_Higher_Number_With_Same_Digits: " + Next.getNextHighest(num));
		
		num = 13542;
		System.out.println("\n\nNum: " + num);
		System.out.println("Next_Higher_Number_With_Same_Digits: " + Next.getNextHighest(num));
		
		num = 136442;
		System.out.println("\n\nNum: " + num);
		System.out.println("Next_Higher_Number_With_Same_Digits: " + Next.getNextHighest(num));
		
		num = 1232;
		System.out.println("\n\nNum: " + num);
		System.out.println("Next_Higher_Number_With_Same_Digits: " + Next.getNextHighest(num));
		
	}
}
