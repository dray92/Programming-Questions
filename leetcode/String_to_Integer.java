package leetcode;

public class String_to_Integer {
	
	public static int myAtoi(String s) {
		s = s.trim();
		
		boolean neg = false, setFirst = false;
		
		if(s.length() == 0)
			return 0;
		
		if(s.charAt(0) == '-' || s.charAt(0) == '+') {
			setFirst = true;
			neg = s.charAt(0) == '-';
		}
		
		if(!setFirst && (s.charAt(0) < '0' || s.charAt(0) > '9'))
			return 0;
		
		int val = 0, val2 = 0;
		
		for(int i = 0 ; i < s.length() ; i++) {
			if(setFirst && i==0)
				continue;
			
			if(setFirst && neg && s.charAt(i) == '+')
				return 0;
			
			if(setFirst && s.charAt(i) == '-')
				return 0;
			
			if(s.charAt(i) < '0' || s.charAt(i) > '9')
				break;
			
			val2 = (val*10) + (s.charAt(i)-'0');
			
			if(val >= Integer.MAX_VALUE/10)
				return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			
			val = val2;
		}
		
		if(neg)
			return val*-1;
		
		return val;
	}
	
	public static void main(String[] args) {
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
