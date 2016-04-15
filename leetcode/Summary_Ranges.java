package leetcode;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/summary-ranges/
public class Summary_Ranges {

	public static List<String> summaryRanges(int[] nums) {
		List<String> ranges = new LinkedList<String>();
        
        if(nums == null || nums.length == 0)
			return ranges;
		
        Integer startVal = nums[0];
        
        for(int i = 1 ; i < nums.length ; i++) {
        	// end of range
        	if(nums[i] - 1 != nums[i-1]) {
        		StringBuilder range = new StringBuilder();
        		range.append(startVal);
        		if(!startVal.equals(nums[i-1])) {
        			range.append("->");
        			range.append(nums[i-1]);
        		}
        		ranges.add(range.toString());
        		startVal = nums[i];
        	}
        }
        
        StringBuilder range = new StringBuilder();
		range.append(startVal);
		if(!startVal.equals(nums[nums.length - 1])) {
			range.append("->");
			range.append(nums[nums.length - 1]);
		}
		ranges.add(range.toString());
        
        return ranges;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{0,1,2,4,5,7};
		System.out.println(summaryRanges(nums));
		
		nums = new int[]{0,2,4,5,7,8};
		System.out.println(summaryRanges(nums));
		
		nums = new int[]{0};
		System.out.println(summaryRanges(nums));
	}
}
