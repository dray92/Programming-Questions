package ctci;

import java.util.HashMap;
import java.util.Map;

/**
 * Check if a game of tic-tac-toe is complete
 * @author Debosmit
 *
 */
public class Moderate17_2 {
	
	private final int N = 3;

	private Map<Integer, Boolean> checks = new HashMap<Integer, Boolean>();
	
	// assumption
	// 0 -> empty
	// 1 -> x
	// 2 -> O
	public boolean isComplete(int[][] arr) {
		int checkSum = getSum(arr);
		if(checks.keySet().contains(checkSum))
			return checks.get(checkSum);
		
		boolean isComplete = isCompleteHelper(arr);
		checks.put(checkSum, isComplete);
		return isComplete;
	}

	private int getSum(int[][] arr) {
		int coef = 1, sum = 0;
		for(int i = 0; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				sum += coef * arr[i][j];
				coef *= N;
			}
		}
		return sum;
	}
	
	private boolean isCompleteHelper(int[][] arr) {
		// check rows
		for(int row = 0 ; row < N ; row++) {
			// if first slot is not set, no need to check rest
			if(arr[row][0] == 0) 
				continue;
			
			int col;
			for(col = 1 ; col < N ; col++) {
				if(arr[row][col] != arr[row][col-1]) 
					break;
			}
			if(col == N)
				return true;
		}
		
		// check columns
		for(int col = 0 ; col < N ; col++) {
			// if first slot is not set, no need to check rest
			if(arr[0][col] == 0) 
				continue;
			
			int row;
			for(row = 1 ; row < N ; row++) {
				if(arr[col][row] != arr[col][row-1]) 
					break;
			}
			if(row == N)
				return true;
			
		}
		
		// check diagonal
		if(arr[0][0] != 0) {
			int row;
			for(row = 1 ; row < N ; row++) {
				if(arr[row][row] != arr[row-1][row-1])
					break;
			}
			if(row == N)
				return true;
		}
		
		// check reverse diagonal
		if(arr[0][N-1] != 0) {
			int row;
			for(row = 1 ; row < N ; row++) {
				if(arr[row][(N-1)-row] != arr[row-1][(N-1)-(row-1)])
					break;
			}
			if(row == N)
				return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[][] arr = {{0,0,1}, {0,1,0}, {1,0,0}};
		
		Moderate17_2 TicTacToe = new Moderate17_2();
		
		System.out.println("Is complete? " + TicTacToe.isComplete(arr));
	}
}
