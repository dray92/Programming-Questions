package leetcode;

public class String_to_Integer {
	
	public static int myAtoi(String s) {
        if(s == null)
			throw new NumberFormatException("null");
		
		s = s.trim();
		
		if(s.length() == 0)
		    return 0;
		
		int result = 0;
		boolean negative = false;
        int limit = -Integer.MAX_VALUE;
		int indx = 0, len = s.length(), digit, multmin;
		
		final int RADIX = 10;
		
		if(len > 0) {
			char first = s.charAt(0);
			// first character must either be a number
			// or a + or -
			if(first < '0') {
				if(first == '-') {
					limit = Integer.MIN_VALUE;
					negative = true;
				} else if(first != '+') {
					return 0; // throw new NumberFormatException("first character must be a digit, \'+\' or \'-\'");
				}
				if (len == 1) // Cannot have lone "+" or "-"
					return 0; // throw new NumberFormatException("contains only a + or a -");
                indx++;
			}
			multmin = limit / RADIX;
			while(indx < len) {
				digit = Character.digit(s.charAt(indx++), RADIX);
				
				if (digit < 0) {
                    break; // throw new NumberFormatException("illegal character at index " + (indx-1));
                }
				if (result < multmin) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE; // throw new NumberFormatException("overflow");
                }
                result *= RADIX;
                if (result < limit + digit) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE; //throw new NumberFormatException("overflow");
                }
                result -= digit;
            }
        } else {
            throw new NumberFormatException("bad length");
        }
		return negative ? result : -result;
	}
	
	public static void main(String[] args) {
		Integer.parseInt("");
		
		String num = "1234";
		System.out.println("Converting 1234: " + myAtoi(num));
		
		num = "0";
		System.out.println("Converting 0: " + myAtoi(num));
		
		num = "-0";
		System.out.println("Converting -0: " + myAtoi(num));
		
		num = "-1234";
		System.out.println("Converting -1234: " + myAtoi(num));
		
		num = "-123.4";
		System.out.println("Converting -123.4: " + myAtoi(num));
		
		num = "+-1234";
		System.out.println("Converting +-1234: " + myAtoi(num));
		
		num = "    -12a34";
		System.out.println("Converting \"    -12a34\": " + myAtoi(num));
		
		num = "2147483648";
		System.out.println("Converting 2147483648: " + myAtoi(num));
		
		num = "    10522545459";
		System.out.println("Converting \"    10522545459\": " + myAtoi(num));
		
		num = "      -11919730356x";
		System.out.println("Converting \"      -11919730356x\": " + myAtoi(num));
	}
}
