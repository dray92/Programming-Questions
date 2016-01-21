package ctci;

import java.util.HashSet;
import java.util.Set;

/**
 * If any column in an MxN matrix is 0,
 * set the entire row and column to 0
 * @author Debosmit
 *
 */
public class ArrayString1_7 {

	public class Coordinate {
		int x, y;
		
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public void checkAndSet(int[][] arr) {
		Set<Coordinate> points = new HashSet<Coordinate>();
		
		for(int i = 0; i < arr.length ; i++) {
			for(int j = 0 ; j < arr[i].length ; j++) {
				if(arr[i][j] == 0)
					points.add(new Coordinate(i,j));
			}
		}
		
		for(Coordinate point: points) {
			// setting elements in row to 0
			for(int x = 0 ; x < arr[point.x].length ; x++)
				arr[point.x][x] = 0;
			
			// setting elements in the column to 0
			for(int y = 0 ; y < arr.length ; y++) {
				// no point reading in the row containing the 
				// given 0 element since it will waste time
				// reading an extra row
				if(y == point.x)
					continue;
				arr[y][point.y] = 0;
			}
		}
	}
	
	// prints a formatted version of a 2D array
	private void print2DPixelArray(int[][] arr) {
		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = 0 ; j < arr[i].length ; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		ArrayString1_7 compute = new ArrayString1_7();
		
		int[][] arr = new int[5][4];
		int count = 1;
		for(int i = 0  ; i < arr.length ; i++) 
			for(int j = 0 ; j < arr[i].length ; j++) 
				arr[i][j] = count++;
		arr[2][3] = 0;
		arr[3][2] = 0;
		System.out.println("Old array: ");
		compute.print2DPixelArray(arr);
		compute.checkAndSet(arr);
		System.out.println("\nNew array: ");
		compute.print2DPixelArray(arr);
		
	}
}
