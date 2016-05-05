package leetcode;

public class Move_Zeroes {
	
	public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
            
        int indx = -1 , searcher = 0;
        
        while(searcher < nums.length) {
            if(nums[searcher] != 0)
                swap(++indx, searcher, nums);
            searcher++;
        }
    }
    
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
