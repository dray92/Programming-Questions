package hackerRank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * You are playing a game on your cellphone. You are given an array of length nn, indexed from 00 to n−1n−1. Each element of the array is either 00 or 11. You can only move to an index which contains 00. At first you are at the 0th0th position. In each move you can do one of the following things:

    Walk one step forward or backward.
    Make a jump of exactly length mm forward.

That means you can move from position xx to x+1x+1, x−1x−1 or x+mx+m in one move. The new position must contain 0. Also you can move to any position greater than n-1.

You can't move backward from position 00. If you move to any position greater than n−1n−1, you win the game.

Given the array and the length of the jump, you need to determine if it's possible to win the game or not.

Input Format

In the first line there will be an integer TT denoting the number of test cases. Each test case will consist of two lines. The first line will contain two integers, nn and mm. On the second line there will be nn space-separated integers, each of which is either 00 or 11.

Constraints:

1<=T<=50001<=T<=5000
2≤n≤1002≤n≤100
0≤m≤1000≤m≤100
The first integer of the array is always 00.
 * @author Debosmit
 *
 */
public class Java_1D_Array_Hard {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        
        if(numTestCases < 1 || numTestCases > 5000)
        	throw new IllegalArgumentException();
        
        while(numTestCases > 0) {
        	// num array elements
        	int arrLen = scan.nextInt();
        	
        	if(arrLen < 2 || arrLen > 100)
            	throw new IllegalArgumentException();
        	
        	// jump value
        	int jumpVal = scan.nextInt();
        	
        	if(jumpVal < 0 || jumpVal > 100)
            	throw new IllegalArgumentException();
        	
        	// get array
        	int arr[] = new int[arrLen];
        	for(int i = 0 ; i < arrLen ; i++)
        		arr[i] = scan.nextInt();
        	
        	boolean result = getResult(0, arr, jumpVal, new HashSet<Integer>());
        	
        	if(result)
        		System.out.println("YES");
        	else 
        		System.out.println("NO");
        	
        	numTestCases--;
        }
    }

	private static boolean getResult(int curIndex, int[] arr, int m, Set<Integer> visited) {
		if(curIndex < 0)
			return false;
		
		if(curIndex > arr.length-1)
			return true;
		
		if(arr[curIndex] != 0)
			return false;
		
		// add to visited 
		// if already visited, return false
		if(!visited.add(curIndex))
			return false;
		
		boolean back = getResult(curIndex - 1, arr, m, visited);
		boolean frontOne = getResult(curIndex + 1, arr, m, visited);
		boolean frontM = getResult(curIndex + m, arr, m, visited);
		
		if(back || frontOne || frontM)
			return true;
		return false;
	}
}
