package projectEuler;

public class Problem1 {

	public static void main(String[] args) {
		int sumMult3 = 0, sumMult5 = 0;
		final int upper = 1000;
		for(int i = 3 ; i < upper ; i+=3) 
			sumMult3 += i;
		
		for(int i = 5 ; i < upper ; i+=5) {
			// ensure that number is not already
			// included in sumMult3;
			if(i%3 != 0)
				sumMult5 += i;
		}
		
		System.out.println(sumMult3 + sumMult5);
	}
	
}
