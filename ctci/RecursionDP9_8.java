package ctci;


/**
 * Given an infinite number of quarters,
 * dimes, nickels and pennies, calculate
 * number of ways of representing n cents
 * @author Debosmit
 *
 */
public class RecursionDP9_8 {

	/*
	 * list[0] -> penny
	 * list[1] -> nickel
	 * list[2] -> dime
	 * list[3] -> quarter
	 */
	public int getNumWays(int n, int[] list, int index) {
		int[][] map = new int[n+1][list.length];
		return getNumWays(n, list, index, map);
	}
	
	private int getNumWays(int n, int[] list, int index, int[][] map) {
		// TODO Auto-generated method stub
		if(map[n][index] > 0)
			return map[n][index];
		
		// one denomination left
		if(index >= list.length - 1)
			return 1;
		
		int denomination = list[index];
		int ways = 0;
		
		for(int i = 0 ; i * denomination <= n ; i++) {
			int amount = i*denomination;
			ways += getNumWays(n - amount, list, index+1, map);
		}
		
		map[n][index] = ways;
		return ways;
	}

	public static void main(String[] args) {
		int[] values = {25, 10, 5, 1};
		RecursionDP9_8 calculateNumCoins = new RecursionDP9_8();
		
		int numCents = 10; 
		int ways = calculateNumCoins.getNumWays(numCents, values, 0);
		
		System.out.println("Ways to get " + numCents + " cents in change: " + ways);
	}
}
