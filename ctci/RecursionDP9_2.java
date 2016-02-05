package ctci;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;


/** 
 * Robot at sitting at the top left corner
 * of an X by Y grid. Robot can move in 2 direction,
 * right and down. How many possible ways
 * for the robot to go from (0,0) to (X,Y)?
 * What if there are obstacles in the path 
 * that the robot can't go over?
 * 
 * @author Debosmit
 *
 */
public class RecursionDP9_2 {

	public static int[][] maze;
	public static int N = 120;
	
	public long getNumPaths(int x, int y) {
		// possible paths from (0,0) to (x,y)
		// total movements needed (x+y)
		// number of right movements needed = x
		// possible ways -> from (x+y) choose x
		// so, ways = (x+y)! / (x!)(y!);
		long[] factorials = new long[x+y+1];
		for(int i = 1 ; i < factorials.length ; i++)
			factorials[i] = -1;
		factorials[0] = 1;
		factorials[1] = 1;
		
		long totalFact = getFactorial(x+y, factorials);
		long xFact = getFactorial(x, factorials);
		long yFact = getFactorial(y, factorials);
		
		return totalFact/(xFact*yFact);
	}
	
	// returns the factorial of a number using DP
	private long getFactorial(int num, long[] factorials) {
		if(num <= 1)
			return 1;
		
		else if(factorials[num] > -1)
			return factorials[num];
		
		else {
			factorials[num] = num * getFactorial(num-1, factorials);
			return factorials[num];
		}
	}
	
	public boolean getPathRecurse(int x, int y, ArrayList<Point> list) {
		if(x < 0 || y < 0 || x >= N || y >= N || !isFree(x,y) )
			return false;
		
		boolean isOrigin = (x==0 && y==0);
		
		// if the point is origin or if path to 
		// (0,0) exists from (x-1, y) or (x, y-1)
		// return true and add point to list
		if(isOrigin || getPathRecurse(x-1, y, list) || getPathRecurse(x, y-1, list)) {
			list.add(new Point(x,y));
			return true;
		}
		return false;
	}
	
	public boolean getPathDP(int x, int y, ArrayList<Point> list, HashMap<Point, Boolean> cache) {
		
		if(x < 0 || y < 0 || x >= N || y >= N || !isFree(x,y) )
			return false;
		
		Point myPoint = new Point(x,y);
		
		// if point is previously visited,
		// solution computed then can be used
		if(cache.containsKey(myPoint))
			return cache.get(myPoint);
		
		boolean isOrigin = (x==0 && y==0);
		boolean success = false;
		
		// if the point is origin or if path to 
		// (0,0) exists from (x-1, y) or (x, y-1)
		// return true and add point to list
		if(isOrigin || getPathDP(x-1, y, list, cache) || getPathDP(x, y-1, list, cache)) {
			list.add(myPoint);
			success = true;
		}
		
		// add point to cache
		cache.put(myPoint, success);
		return success;
		
	}
	
	private boolean isFree(int x, int y) {
		return maze[x][y] != 0;
	}
	
	// returns a new number in [min, max];
	private static int randomWithRange(int min, int max) {
		if(max < min)
			return randomWithRange(max, min);
		
		int range = (max - min) + 1;     
		return (int)((Math.random() * range) + min);
	}
	
	// prints 2D maze
	private static void printMaze() {
		System.out.println("Maze [0 signifies obstacle, anything else is valid]: ");
		for(int[] i: maze) {
			for(int j: i)
				System.out.print(j + "\t");
			System.out.println();
		}
		System.out.println();
	}
	
	private static String getPointCoordinates(Point p) {
		return "(" + p.x + "," + p.y + ")";
	}
	
	public static void main(String[] args) {
		int x = 5, y = 5;
		RecursionDP9_2 numWays = new RecursionDP9_2();
		System.out.println("Number of possible ways from (0,0) to (5,5) "
				+ "without any obstacles: " + numWays.getNumPaths(x,y) + "\n\n");
		
		int minRange = 0, maxRange = 9;
		maze = new int[N][N];
		
		// init maze
		// minRange should be 0 to include obstacles
		for(int i = 0 ; i < maze.length ; i++)
			for(int j = 0 ; j < maze[i].length ; j++)
				maze[i][j] = randomWithRange(minRange, maxRange);
		
		// origin can't be an obstacle
		if(maze[0][0] == 0)
			maze[0][0] = randomWithRange(1, maxRange);
		
		printMaze();
		
		for(int i = 0 ; i < 2 ; i++) {
			ArrayList<Point> list = new ArrayList<Point>();
			int randX = randomWithRange(0, N-1);
			int randY = randomWithRange(0, N-1);
			
			Point source = new Point(randX, randY);
			Point target = new Point(0, 0);
			System.out.println("Starting point: " + getPointCoordinates(source));
			System.out.println("Ending point: " + getPointCoordinates(target));
			
			boolean pathFound = false;
			
			// call recursion algorithm
			System.out.print("Recursion ->           ");
			long t1 = System.currentTimeMillis();
			pathFound = numWays.getPathRecurse(randX, randY, list);
			long t2 = System.currentTimeMillis();
			if(pathFound) 
				// process list
				for(Point point: list) 
					System.out.print(getPointCoordinates(point) + " ");
			
			System.out.println(" (" + (t2-t1) + " millis)");
			
			// clear list of point for DP algorithm
			list = new ArrayList<Point>();
			pathFound = false;
			
			// initialize cache
			HashMap<Point, Boolean> cache = new HashMap<Point, Boolean>();
			
			// call DP algorithm
			System.out.print("Dynamic Programming -> ");
			t1 = System.currentTimeMillis();
			pathFound = numWays.getPathDP(randX, randY, list, cache);
			t2 = System.currentTimeMillis();
			if(pathFound) 
				// process list
				for(Point point: list) 
					System.out.print(getPointCoordinates(point) + " ");
			
			System.out.println(" (" + (t2-t1) + " millis)\n");
			
		}
	}
}
