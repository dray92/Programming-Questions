package projectEuler;

public class Problem2 {
	public static void main(String[] args) {
		
		int first = 1, second = 2;
		int bound = 4000000;
		int sum = second;
		while(first + second < bound) {
			second = first+second;
			first = second-first;
			
			if( (second & 0x1) == 0 )
				sum += second;
		}
		
		System.out.println(sum);
	}
}
