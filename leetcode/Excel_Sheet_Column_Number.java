package leetcode;

public class Excel_Sheet_Column_Number {
	
	public int titleToNumber(String s) {
        int num = 0;
        for(int i = s.length() - 1 ; i >= 0 ; i--) 
            num += (s.charAt(i) - 'A' + 1) * (int)Math.pow(26, s.length() - i - 1);
        return num;
    }

}
