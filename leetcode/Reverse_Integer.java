package leetcode;

public class Reverse_Integer {
	
	public static int reverse(int x) {
		boolean neg = x < 0;
		
		if(neg)
			x *= -1;
		
		int rev = 0;
		
		while(x != 0) {
			try {
				rev = Math.addExact(Math.multiplyExact(rev, 10), x%10);
			} catch(ArithmeticException e) {
				return 0;
			}
			x /= 10;
		}
		if(neg)
			rev *= -1;
		
		return rev;
	}
	
	public static void main(String[] args) {
		int num = 1234;
		System.out.println(num + " reversed: " + reverse(num));
		
		num = -1234;
		System.out.println(num + " reversed: " + reverse(num));
		
		num = 1000000003;
		System.out.println(num + " reversed: " + reverse(num));
	}

}
