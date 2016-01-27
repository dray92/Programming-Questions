package ctci;

/**
 * Child is running up a staircase with 
 * n steps. S/he can take 1, 2 or 3 steps.
 * How many possible ways?
 * @author Debosmit
 *
 */
public class RecursionDP9_1 {

	public long countStepsDP(int n, long[] map) {
		if (n < 0) 
			return 0;
		
		else if (n == 0) 
			return 1;
		
		else if(map[n] > -1) 
			return map[n];
		
		else {
			map[n] = countStepsDP(n-1, map) + 
					countStepsDP(n-2, map) +
					countStepsDP(n-3, map);
			return map[n];
		}
	}
	
	public long countStepsRecursion(int n) {
		if(n < 0)
			return 0;
		
		else if(n == 0)
			return 1;
		
		else 
			return countStepsRecursion(n-1) + 
					countStepsRecursion(n-2) + 
					countStepsRecursion(n-3);
	}
	
	private static double millisToSec(long val) {
		return val*1.0/1000;
	}
	
	public static void main(String[] args) {
		int steps = 38;
		RecursionDP9_1 stepCounter = new RecursionDP9_1();
		
		for(int step = 0 ; step < steps ; step++) {
			long[] map = new long[step+1];
			for(int i = 0 ; i < map.length ; i++) 
				map[i] = -1;
			
			long t1 = System.currentTimeMillis();
			long ways = stepCounter.countStepsRecursion(step);
			long t2 = System.currentTimeMillis();
			System.out.println(step + " steps || Recursion: " + ways 
					+ "   (" + millisToSec(t2-t1) + " sec)");
			
			t1 = System.currentTimeMillis();
			ways = stepCounter.countStepsDP(step, map);
			t2 = System.currentTimeMillis();
			System.out.println(step + " steps || DP: " + ways 
					+ "   (" + millisToSec(t2-t1) + " sec)\n");
			
		}
	}
}
