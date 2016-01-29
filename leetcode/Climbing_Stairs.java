package leetcode;

import java.util.HashMap;

/**
 * Given the number of stairs, how many 
 * distinct ways are there to climb the 
 * stairs if someone can take 1 or 2
 * steps at a time?
 * @author Debosmit
 *
 */
public class Climbing_Stairs {
	
	private static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public static int climbStairs(int n) {
        if(n <= 2)
        	return n;
        if(!map.keySet().contains(n)) {
        	map.put(n, climbStairs(n-1) + climbStairs(n-2));
        }
        return map.get(n);
    }
	
	public static void main(String[] args) {
		int n = 4;
		System.out.println("n = " + n + " | Number of distinct combinations: " + climbStairs(n) + "\n");
	}
}
