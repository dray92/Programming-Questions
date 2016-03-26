package randomCode;

public class Divide_Conquer_2dArr {
	
	private static boolean divideAndConquer(int[][] arr, int target) {
		
		/* IDEA */
		// NORTH_WEST [Kanye West joke(?)]
		// need to search row-wise from [0,row-1], col-wise from [0, col-1]
		
		// NORTH_EAST
		// need to search row-wise from [0,row-1], col-wise from [col, maxCol]
		
		// SOUTH_WEST
		// need to search row-wise from [row, maxRow], col-wise from [0, col-1]
		
		// SOUTH_EAST
		// need to search row-wise from [row, maxRow], col-wise from [col, maxCol]
		
		return divideAndConquerHelper(arr, target, 0, arr[0].length-1, 0, arr.length-1);
	}

	private static boolean divideAndConquerHelper(int[][] arr, int target, int minCol, 
			int maxCol, int minRow, int maxRow) {
		// print relevant stuff
		printArr(arr,  minCol, maxCol, minRow, maxRow);
		
		if(minCol == maxCol || minRow == maxRow) {
			
			if(minCol == maxCol) {
				for(int i = minRow ; i <= maxRow ; i++)
					if(arr[i][minCol] == target) {
						System.out.println("Found!");
						return true;
					}
			}
			
			else if(minRow == maxRow) {
				for(int i = minCol ; i <= maxCol ; i++)
					if(arr[minRow][i] == target) {
						System.out.println("Found!");
						return true;
					}
			}
			
			return false;
		}
		
		int midRow = (maxRow + minRow)/2;
		int midCol = (maxCol + minCol)/2;
		
		
		return 
				// north-west quadrant
				divideAndConquerHelper(arr, target, minCol, midCol, minRow, midRow)
				||
				// north-east quadrant
				divideAndConquerHelper(arr, target, midCol+1, maxCol, minRow, midRow)
				||
				// south-west quadrant
				divideAndConquerHelper(arr, target, minCol, midCol, midRow+1, maxRow)
				||
				// south-east quadrant
				divideAndConquerHelper(arr, target, midCol+1, maxCol, midRow+1, maxRow);
	}
	
	// prints arr[minRow..maxRow][minCol..maxCol] inclusive
	private static void printArr(int[][] arr, int minCol, 
			int maxCol, int minRow, int maxRow) {
		for(int i = minRow ; i <= maxRow ; i++ ) {
			for(int j = minCol ; j <= maxCol ; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("==================================");
	}

	public static void main(String[] args) {
		int[][] arr = new int[][]
				{
					{1,2,3,4},
					{6,7,8,9},
					{11,12,13,14},
					{16,17,18,19},
					{21,22,23,24}
				};
		
		boolean retVal = divideAndConquer(arr, 12);
		if(!retVal)
			System.out.println("Not found :(");
	}
}
