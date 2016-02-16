package ctci;

/**
 * Given an integer, print an
 * English phrase that describes 
 * the integer.
 * 
 * 1023 -> one thousand twenty three
 * @author Debosmit
 *
 */
public class Moderate17_7 {
	
	private String[] digits;
	private String[] teens;
	private String[] bigs;
	private String[] tens;
	
	public Moderate17_7() {
		String[] digitsTemp = {" one",
							    " two",
							    " three",
							    " four",
							    " five",
							    " six",
							    " seven",
							    " eight",
							    " nine"};
		
		String[] teensTemp = {" eleven",
							    " twelve",
							    " thirteen",
							    " fourteen",
							    " fifteen",
							    " sixteen",
							    " seventeen",
							    " eighteen",
							    " nineteen"};
		
		String[] bigsTemp = {"",
							"thousand", 
							"million", 
							"billion"};
		
		String[] tensTemp = {" ten",
						    " twenty",
						    " thirty",
						    " forty",
						    " fifty",
						    " sixty",
						    " seventy",
						    " eighty",
						    " ninety"};
		
		this.digits = digitsTemp;
		this.teens = teensTemp;
		this.bigs = bigsTemp;
		this.tens = tensTemp;
	}

	public String num2String(int num) {
		if(num == 0)
			return "zero";
		else if(num < 0)
			return "negative" + num2String(-1*num);
		
		int count = 0;
		String st = "";

		while(num > 0) {
			if(num % 1000 != 0) {
				st = num2String100s(num % 1000) + " " + bigs[count] + " " + st;
			}
			num /= 1000;
			count++;
		}
		
		return st;
	}

	private String num2String100s(int num) {
		String st = "";
		
		// hundreds place
		if(num >= 100) {
			st = digits[num/100 - 1] + " hundred ";
			num %= 100;
		}
		
		// tens place
		if(num >= 11 && num <= 19) {
			return st + teens[num - 11] + " ";
		} else if(num == 10 || num>=20) {
			// get tens
			st += tens[num/10 - 1] + " ";
			num %= 10;
		}
		
		if(num >= 1 && num <= 9)
			st += digits[num - 1] + " ";
		
		return st;
	}
	
	public static void main(String[] args) {
		int num = 1023;
		
		Moderate17_7 Int2English = new Moderate17_7();
		
		System.out.println(num + " to string: " + Int2English.num2String(num));
	}
}
