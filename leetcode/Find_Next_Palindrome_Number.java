package leetcode;

/*
 * Given a number, find the next smallest palindrome 
 * larger than the number. For example if the number 
 * is 125, next smallest palindrome is 131.
 */
public class Find_Next_Palindrome_Number {
	
	public int getNextPalindrome(int num) {
		String numSt = "" + num;
		int len = numSt.length();
		boolean isOddChars = len%2 == 1;
		String left = getLeft(numSt);
		char mid = getMid(numSt);
		int increment = 0;
		String newNum;
		
		if(isOddChars) {
			increment = (int)Math.pow(10, len/2);
			newNum = left + mid + reverse(left);
		} else {
			increment = (int)(1.1 * Math.pow(10, len/2));
			newNum = left + reverse(left);
		}
		if(Integer.parseInt(newNum) > num)
			return num;
		
		if(mid != '9') 
			return Integer.parseInt(newNum)+increment;

		return getNextPalindrome(roundUp(numSt));
		
	}

	private Character getMid(String numSt) {
		int len = numSt.length();
		return numSt.charAt(len/2);
	}

	private String getLeft(String numSt) {
		int len = numSt.length();
		return numSt.substring(0, len/2);
	}
	
	private String reverse(String st) {
		StringBuilder sb = new StringBuilder(st);
		int len = st.length();
		for(int i = 0; i < len/2 ; i++) {
			char c = sb.charAt(i);
			sb.replace(i, i+1, ""+sb.charAt(len-i-1));
			sb.replace(len-i-1, len-i, ""+c);
		}
		return sb.toString();
	}
	
	private int roundUp(String num) { 
		int len = num.length();
		int increment = (int)Math.pow(10,len/2 + 1);
		int number = Integer.parseInt(num);
		return (number/increment + 1) * increment;
	}
	
	public static void main(String[] args) {
		int num = 387;
		Find_Next_Palindrome_Number getPalindrome = new Find_Next_Palindrome_Number();
		System.out.println("Next biggest palindrome for " + num + ": " + getPalindrome.getNextPalindrome(num));
		num = 1050;
		System.out.println("Next biggest palindrome for " + num + ": " + getPalindrome.getNextPalindrome(num));
	}
	
}
