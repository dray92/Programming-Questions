package randomCode;

import java.util.Scanner;

public class Solution10 {
	static String nextNum(String base, String n) {
		// 2 cases
		// one requires carry over
		if(n.charAt( n.length() - 1 ) == base.charAt( base.length()-1 ) ) {
			
			// note: carry is set to 1
			int last = n.length() - 1, carry = 1;
			
			int systemBase = base.charAt(base.length() - 1) - '0';
			systemBase++;		// equals 10 for base=0123456789
								// equals 4 for base=0123
			
			String newString = "";
			int curIndx = n.length() - 1;
			while(curIndx >= 0) {
				int digit = n.charAt(curIndx) - '0';
				
				// add carry over value
				digit += carry;
				
				carry = digit / systemBase;
				digit = digit % systemBase;
				
				newString = digit + newString;
				
				curIndx--;
			}
			//if there is something left in carry
			if(carry != 0)
				newString = carry + newString;
			
			return newString;
		} 
		// no carry over
		else {
			// just need to add one to last character
			// increment last character by 1
			int last = n.charAt(n.length() - 1) - '0';	// actual value of last
			last++;										// increment by 1
			return ( n.substring(0, n.length()-1) + last );
		}
	}       

  public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      System.out.print("Please enter base: ");
      String base = input.nextLine();
      System.out.print("Please enter first number: ");
      String n = input.nextLine();         

      System.out.println(nextNum(base,n));        

  }

}
