package ctci;

import leetcode.FormattedTablePrint;
import ctci.ArrayString1_7.Coordinate;

/**
 * MxN matrix. Each row and column is in 
 * ascending order. Find an element.
 * @author Debosmit
 *
 */
public class SortingSearching11_6 {
	
	public Coordinate getIndex(int[][] arr, int value) {
		if(arr == null)
			return null;
		
		int curMaxCols = arr[0].length - 1, curMaxRows = arr.length - 1;
		
		// establish row bounds
		for(int i = arr.length - 1 ; i >= 0 ; i--) {
			if(arr[i][0] < value) {
				curMaxRows = i;
				break;
			}
		
		}
		
		// establish column bounds
		for(int i = arr[0].length - 1 ; i >= 0 ; i--) {
			if(arr[0][i] < value) {
				curMaxCols = i;
				break;
			}
		}
		
		// element cannot possibly be in the array
		if(curMaxCols == 0 || curMaxRows == 0)
			return new Coordinate(-1,-1);
		
		int curRow = curMaxRows;
		// start search from last possible row
		while(curRow >= 0) {
			// if bounds of this row doesn't include value
			// continue to next iteration
			if(arr[curRow][0] > value || arr[curRow][curMaxCols] < value) {
				curRow--;
				continue;
			}
			// see if row contains value
			for(int i = 0 ; i <= curMaxCols ; i++) {
				if(arr[curRow][i] == value)
					return new Coordinate(curRow, i);
			}
			// move to next row
			curRow--;
		}
		
		// value not found
		return new Coordinate(-1, -1);
	}
	
	
	public static void main(String[] args) {
		SortingSearching11_6 Search = new SortingSearching11_6();
		
		int[][] arr = new int[][]{{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}};
		
		System.out.println("Matrix: ");
		FormattedTablePrint Printer = new FormattedTablePrint();
		Printer.print2DArray(arr);
		
		int searchVal = 15;
		
		Coordinate indx = Search.getIndex(arr, searchVal);
		System.out.println("\nSearch value: " + searchVal);
		System.out.println("Value found at coordinates: " + indx);
	}

}
