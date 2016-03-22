package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two_Sum {
	public static int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2];
	 
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(numbers[i])) {
				int index = map.get(numbers[i]);
				result[0] = index;
				result[1] = i;
				break;
			} else 
				map.put(target - numbers[i], i);
		}
	 
		return result;
    }
	
	public static void main(String[] args) {
		int[] num = new int[]{2, 7, 11, 15};
		int target = 9;
		System.out.println(Arrays.toString(twoSum(num, target)));
	}
}
