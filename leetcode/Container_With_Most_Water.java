package leetcode;

/**
 * Given n non-negative integers a1, a2, ..., an, where each 
 * represents a point at coordinate (i, ai). n vertical lines 
 * are drawn such that the two endpoints of line i is at (i, ai) 
 * and (i, 0). Find two lines, which together with x-axis forms 
 * a container, such that the container contains the most water. 
 * 
 * Note: You may not slant the container. 
 * @author Debosmit
 *
 */
public class Container_With_Most_Water {
	public static int maxArea(int[] height) {
		if(height == null || height.length < 2)
			return 0;
		
        int curMax = 0;
        int left = 0, right = height.length - 1;
        
        int area;
        while(left < right) {
        	area = (right - left) * Math.min(height[left], height[right]);
        	curMax = Math.max(area, curMax);
        	
        	if(height[left] < height[right]) 
        		left++;
        	else 
        		right--;
        }
        
        return curMax;
    }
	
	public static void main(String[] args) {
		int[] height = new int[]{1,2,4,1,6,2};
		System.out.println( maxArea(height) );
	}
}
