package ctci;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 8 queens problem
 * @author Debosmit
 *
 */
public class RecursionDP9_9 {
	
	private final int GRID_SIZE = 8;
	
	// array columns 
	// value i-th index represents row of queen
	// for i-th column
	public void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
		if(row == GRID_SIZE)
			results.add(columns.clone());
		
		else {
			for(int col = 0 ; col < GRID_SIZE ; col++) {
				if(checkValid(columns, row, col)) {
					columns[row] = col;	// place queen
					placeQueens(row+1, columns, results);	// put a queen on next row
				}
			}
		}
	}

	private boolean checkValid(Integer[] columns, int row, int col) {
		
		for(int row2 = 0 ; row2 < row; row2++) {
			int col2 = columns[row2];
			
			// check same column
			if(col == col2)
				return false;
			
			// check same row
			// not needed
			
			// check diagonal
			// if distance between rows == distance between cols
			// they are on same diagonal
			if((row-row2) == Math.abs(col2-col))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		RecursionDP9_9 queens = new RecursionDP9_9();
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		
		queens.placeQueens(0, new Integer[queens.GRID_SIZE], results);
		
		for(Integer[] placement: results)
			System.out.println(Arrays.toString(placement));
	
	}
}
