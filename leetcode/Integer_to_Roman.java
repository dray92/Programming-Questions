package leetcode;

public class Integer_to_Roman {
	public static String intToRoman(int num) {
		/*
			I: 1
			IV: 4
			V: 5
			IX: 9
			X: 10
			XL: 40
			L: 50
			XC: 90
			C: 100
			CD: 400
			D: 500
			CM: 900
			M: 1000
		 */
		
		// key
		String dict[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		int val[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};  
		
		StringBuilder roman = new StringBuilder();
		
		for(int i = 0; i < dict.length; i++) {
			// if our current num is greater than the value at the array at index i,
			// we need to know how many times it is occurring
            if(num >= val[i]) {
                int count = num/val[i];	// how many times it is occurring
                num %= val[i];			// getting rid of this part for next iteration
               
                // append that character to the string, 'count' times.
                for(int j = 0 ; j < count; j++)
                    roman.append(dict[i]);
            }
        }  
		
		return roman.toString();
    }
	
	public static void main(String[] args) {
		int num = 1000;
		System.out.println(num + " to roman: " + intToRoman(num));
		num = 100;
		System.out.println(num + " to roman: " + intToRoman(num));
		num = 124;
		System.out.println(num + " to roman: " + intToRoman(num));
	}
}
