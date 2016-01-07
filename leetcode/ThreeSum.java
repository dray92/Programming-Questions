package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] num) {
		if(num.length < 3)
			return null;
		Arrays.sort(num);
        LinkedList<List<Integer>> ret = new LinkedList<List<Integer>>();
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1;
            int end = num.length - 1;
            while (start < end) {
                if (num[i] + num[start] + num[end] == 0) {
                    LinkedList<Integer> oneResult = new LinkedList<Integer>();
                    oneResult.add(num[i]);
                    oneResult.add(num[start]);
                    oneResult.add(num[end]);
                    set.add(oneResult);
                    start++;
                    end--;
                } else {
                    if (num[i] + num[start] + num[end] < 0)
                        start++;
                    else
                        end--;
                }
            }
        }
        ret.addAll(set);
        return ret;
	}
	
	public static void main(String[] args) {
		int[] num = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> lists = threeSum(num);
		System.out.println("Array: " + Arrays.toString(num));
		System.out.print("Lists: ");
		for(List<Integer> list: lists)
			System.out.print(Arrays.toString(list.toArray()) + "  ");

	}

}
