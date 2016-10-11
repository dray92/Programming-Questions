package leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Count_of_Smaller_Numbers_After_Self {
	
	public static void main(String[] args) {
		int[] arr = new int[]{5, 2, 6, 1};
		System.out.println(countSmaller(arr));
		
		int[] arr2 = new int[]{6, 5, 4, 3, 2, 1};
		System.out.println(countSmaller(arr2));
		
		int[] arr3 = new int[]{6, 6, 6};
		System.out.println(countSmaller(arr3));
	}
	
	public static List<Integer> countSmaller(int[] nums) {
		if(nums == null || nums.length == 0)
			return new ArrayList<Integer>();
		
		int len = nums.length;
        List<Integer> result = new ArrayList<Integer>(len);
        
        // `value` at last index has 0 elements to its right
        // that are greater than it
        result.add(0);
        
        Node root = new Node(nums[len - 1]);
        for(int i = len - 2 ; i >= 0 ; i--) 
        	result.add(getCount(root, nums[i]));
        
        Collections.reverse(result);
        return result;
    }
	
	private static int getCount(Node root, int val) {
		int currCount = 0;
		
		while(true) {
			if(val <= root.val) {
				root.count++;
				if(root.left == null) {
					root.left = new Node(val);
					break;
				} else 
					root = root.left;
			} else {
				currCount += root.count;
				if(root.right == null) {
					root.right = new Node(val);
					break;
				} else 
					root = root.right;
			}
		}
		
		return currCount;
	}
	
	static class Node {
		Node left, right;
		int val, count = 1;
		
		public Node(int val) {
			this.val = val;
		}
	}
}
