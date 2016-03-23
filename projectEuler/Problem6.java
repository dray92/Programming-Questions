package projectEuler;

public class Problem6 {

	public static void main(String[] args) {
		int max = 100;
		
		// sum of all numbers in [1,100] = 100 * 101 / 2
		int squareOfSum = max*(max+1)/2;
		squareOfSum *= squareOfSum;
		
		// sum of squares of i : i belongs to [1, 100]
		int sumOfSquares = 0;
		for(int i = 1 ; i <= max ; i++)
			sumOfSquares += i*i;
		
		System.out.println(squareOfSum - sumOfSquares);
	}
}
