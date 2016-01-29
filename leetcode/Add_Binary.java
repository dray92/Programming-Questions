package leetcode;

/**
 * Two strings contain binary representations
 * of numbers. Add them and return a new string.
 * @author Debosmit
 *
 */
public class Add_Binary {
    public static String addBinary(String a, String b) {
        if(a == null && b == null)
            return null;
        if(a == null || a.length() == 0) 
            return b;
        if(b == null || b.length() == 0)
            return a;
        
        // if one variable is longer than the other,
        // ensuring variable a is the longer one
        if(a.length() < b.length())
        	return addBinary(b, a);
        
        StringBuilder sum = new StringBuilder();
        
        int aPtr = a.length() - 1;
        int bPtr = b.length() - 1;
        
        int carry = 0;
        while(aPtr >= 0 && bPtr >= 0) {
        	int aChar = a.charAt(aPtr) - '0';
        	int bChar = b.charAt(bPtr) - '0';
        	
        	if(!((aChar == 0 || aChar == 1) && (bChar == 0 || bChar == 1)))
        		return null;
        	
        	int s = aChar ^ bChar;
        	
        	int carryTemp1 = s & carry;
        	int carryTemp2 = aChar & bChar;
        	
        	s ^= carry;
        	carry = carryTemp1 | carryTemp2;
        	
        	sum.insert(0, s);
        	
        	aPtr--;
        	bPtr--;
        }
        
        // if a is longer
        while(aPtr >= 0) {
        	int aChar = a.charAt(aPtr) - '0';
        	if(!(aChar == 0 || aChar == 1))
        		return null;
        	
        	int s = aChar ^ 0;
        	
        	int carryTemp1 = s & carry;
        	int carryTemp2 = aChar & 0;
        	
        	s ^= carry;
        	carry = carryTemp1 | carryTemp2;
        	
        	sum.insert(0, s);
        	
        	aPtr--;
        }
        
        if(carry == 1)
        	sum.insert(0, 1);
        
        return sum.toString();
    }
    
    public static void main(String[] args) {
    	
    	String a = "1", b = "11";
    	System.out.println("    a = " + a);
    	System.out.println("    b = " + b);
    	System.out.println("a + b = " + addBinary(a,b));
    	System.out.println();


    }
}