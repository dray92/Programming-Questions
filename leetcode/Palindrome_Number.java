package leetcode;

public class Palindrome_Number {
	public static boolean isPalindrome(int x) {
        
		if(x < 0)
			return false;
		
		int length = String.valueOf(x).length();
		
		return isPalindrome(x, length);
    }

	private static boolean isPalindrome(int x, int length) {
		// TODO Auto-generated method stub
		
		if(length == 0 || length == 1) {
			return true;
		}
		
		int last = x%10;
		int first = (int) (x / Math.pow(10,length-1));
		
		if(first != last)
			return false;
		
		return isPalindrome((int) ((x % Math.pow(10, length-1))/10), length-2);
	}
	
	public static boolean isPalindrome2(int x) {
		if(x < 0)
			return false;
		
		int div = 1;
		while(x / div >= 10) {
			div *= 10;
		}
		
		int left, right;
		while(x != 0) {
			left = x / div;
			right = x % 10;
			
			if(left != right)
				return false;
			
			x = (x % div) / 10;
			div /= 100;
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		int num = 1234;
		System.out.println(num + ": " + isPalindrome(num));
		
		num = 1221;
		System.out.println(num + ": " + isPalindrome(num));
		
		num = -1221;
		System.out.println(num + ": " + isPalindrome(num));
	}
}
