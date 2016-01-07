package leetcode;

public class Roman_to_Integer {
	
	public static int romanToInt(String s) {
        s = s.toLowerCase();
        
        int decimal = 0, last = 0;
        char ch;
        
        for(int i = s.length() - 1 ; i >= 0 ; i--) {
            ch = s.charAt(i);
            
            switch(ch) {
	            case 'm':	// 1000
	            	decimal = processHelper(1000, last, decimal);
	            	last = 1000;
	            	break;
	            	
	            case 'd':	// 500
	            	decimal = processHelper(500, last, decimal);
	            	last = 500;
	            	break;
	            	
	            case 'c':	// 100
	            	decimal = processHelper(100, last, decimal);
	            	last = 100;
	            	break;
	            	
	            case 'l':	// 50
	            	decimal = processHelper(50, last, decimal);
	            	last = 50;
	            	break;
	            	
	            case 'x':	// 10
	            	decimal = processHelper(10, last, decimal);
	            	last = 10;
	            	break;
	            	
	            case 'v':	// 5
	            	decimal = processHelper(5, last, decimal);
	            	last = 5;
	            	break;
	            	
	            case 'i':	// 1
	            	decimal = processHelper(1, last, decimal);
	            	last = 1;
	            	break;
            }
        }
        return decimal;
    }

	private static int processHelper(int curDec, int last, int lastVal) {
		// TODO Auto-generated method stub
		if(last > curDec)
			return lastVal - curDec;
		return lastVal + curDec;
	}
	
	public static void main(String[] args) {
		String s = "xiv";
		System.out.println(s + " to decimal: " + romanToInt(s));
		s = "cxxiv";
		System.out.println(s + " to decimal: " + romanToInt(s));
	}
}
