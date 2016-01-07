package leetcode;

public class Zigzag_Conversion {
	public static String convert(String s, int numRows) {
        if(numRows == 1)
        	return s;
        
        StringBuilder sb = new StringBuilder();
        
        int step = 2 * numRows - 2;
        
        for(int i = 0 ; i < numRows ; i++) {
        	// row 0, row end
        	if(i == 0 || i == numRows-1)
	        	for(int j = i ; j < s.length() ; j+=step)
	        		sb.append(s.charAt(j));
        	else {
        		int j = i;
        		int s1 = 2 * (numRows - i - 1);
        		int s2 = step - s1;
        		boolean flag = true;
        		while(j < s.length()) {
        			sb.append(s.charAt(j));
        			if(flag)
        				j += s1;
        			else 
        				j += s2;
        			flag = !flag;
        		}
        	}
        }
        
        return sb.toString();
    }
	
	public static void main(String args[]) {
		String s1 = "PAYPALISHIRING";
		System.out.println("String: " + s1);
		System.out.println("Reformatted at n=3: " + convert(s1, 3));
	}
}
