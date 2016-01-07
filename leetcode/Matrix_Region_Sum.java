package leetcode;

public class Matrix_Region_Sum {

	private int[][] sums;	// store the cost matrix
	private int[][] arr;	// stores reference to matrix to see if recomputation needed
	// in order to not have to recalculate every time,
	// we follow kind of a DP approach
	// lets store the sums of the all possible
	// sub-rectangles in an array
	// space complexity then become O(mn) where m and n
	// are the width and height of the array
	public int[][] getCostMatrix(int[][] arr) {
		if(this.sums != null && this.arr == arr)
			return this.sums;
		
		if(arr.length < 1 || arr[0].length < 1)
			return null;
		
		this.arr = arr;
		this.sums = new int[arr.length][arr[0].length];
		
		// copying over value at the origin index
		sums[0][0] = arr[0][0];
		
		// taking a cumulative sum for the 0th row
		for(int col = 1 ; col < arr[0].length ; col++) 
			sums[0][col] = arr[0][col] + sums[0][col-1];
		
		// taking a cumulative sum for the 0th column
		for(int row = 1 ; row < arr.length ; row++) 
			sums[row][0] = arr[row][0] + sums[row-1][0];
		
		for(int col = 1 ; col < arr[0].length ; col++) {
			int colSum = arr[0][col];
			for(int row = 1 ; row < arr.length ; row++) {
				colSum += arr[row][col];
				sums[row][col] = sums[row][col-1] + colSum;
			}
		}
		
		return sums;
	}
	
	public int getSum(int[][] arr, int topRow, int leftCol, int bottomRow, int rightCol) {
		if(topRow < 0 || leftCol < 0 || bottomRow >= arr.length || rightCol >= arr[0].length)
			throw new IllegalArgumentException();
		
		int[][] cost = getCostMatrix(arr);
		
		int bigBoxSum = cost[bottomRow][rightCol];
		int removeCols, removeRows, intersectingBox;
		
		if(topRow == 0)
			removeRows = 0;
		else
			removeRows = cost[topRow-1][rightCol];
		
		if(leftCol == 0)
			removeCols = 0;
		else 
			removeCols = cost[bottomRow][leftCol-1];
		
		// box at arr[topRow][leftCol] has been computed twice in 
		// the cumulative sums; need to factor that back in
		if(topRow == 0 || leftCol == 0)
			intersectingBox = 0;
		else 
			intersectingBox = cost[topRow-1][leftCol-1];

		return bigBoxSum + intersectingBox - removeRows - removeCols;
	}
	
	public static void main(String[] args) {
		Matrix_Region_Sum sum = new Matrix_Region_Sum();
		FormattedTablePrint printer = new FormattedTablePrint();
		int[][] arr = new int[][]{{1,2,3},{3,4,5}};
		System.out.println("Array: ");
		for(int[] row: arr)
			printer.printRow(row);
		
		int[][] cost = sum.getCostMatrix(arr);
		System.out.println("\nCost Matrix: ");
		for(int[] row: cost)
			printer.printRow(row);
		
		System.out.println("Sum for box with top left at (1,1), "
				+ "bottom right at (1,2): " + sum.getSum(arr, 1, 1, 1, 2));
		
		int[][] arr2 = {{1,3,7,9}, {5,8,0,2}, {6,1,3,17}, {21,9,2,1}};
		System.out.println("Array: ");
		for(int[] row: arr2)
			printer.printRow(row);
		
		cost = sum.getCostMatrix(arr2);
		System.out.println("\nCost Matrix: ");
		for(int[] row: cost)
			printer.printRow(row);
		
		System.out.println("Sum for box with top left at (1,1), "
				+ "bottom right at (2,2): " + sum.getSum(arr2, 1, 1, 2, 2));
	}
}
