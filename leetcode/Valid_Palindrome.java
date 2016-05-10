package leetcode;

public class Valid_Palindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("aA"));
	}
	
	public static boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1)
            return true;
            
        int left = 0, right = s.length() - 1;
        
        // set left to left-most alphanumeric character
        while( left < s.length() && !isAlphanumeric(s, left) )
        	left++;
        
        // set right to right-most alphanumeric character
        while( right >= 0 && !isAlphanumeric(s, right))
        	right--;
        
        while(left < right) {
        	// present left is non-alphanumeric
            if( !isAlphanumeric(s, left) ) {
            	left++;
            	continue;
            }
            
            // present right is non-alphanumeric
            if( !isAlphanumeric(s, right) ) {
            	right--;
            	continue;
            }
            
            // character at left and right do not match
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            
            left++;
            right--;
        }
        return true;
    }
	
	private static boolean isAlphanumeric(String s, int indx) {
		return ( (Character.isDigit(s.charAt(indx))) || (Character.isLetter(s.charAt(indx))) );
	}
}
