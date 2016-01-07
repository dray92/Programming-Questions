package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    
	public static int threeSumClosest(int[] num, int target) {
		if(num.length < 3)
			return 0;
		
        int closest = num[0] + num[1] + num[2];
        int diff = Math.abs(closest - target);
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1;
            int end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                int newDiff = Math.abs(sum - target);
                if (newDiff < diff) {
                    diff = newDiff;
                    closest = sum;
                }
                if (sum < target)
                    start++;
                else
                    end--;
            }
        }
        return closest;
    }
	
	public static void main(String[] args) {
		int[] num = {-1, 2, 1, -4};
		int val = threeSumClosest(num, 500);
		System.out.println("Array: " + Arrays.toString(num));
		System.out.print("Closest sum: " + val);
	}
}