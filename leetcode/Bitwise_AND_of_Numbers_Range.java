package leetcode;

public class Bitwise_AND_of_Numbers_Range {
	
	public static int rangeBitwiseAnd(int m, int n) {
		while (n > m) {
	          n = n & n - 1;
	     }
	     return m & n;
    }
	
	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(5,7));
	}
}
