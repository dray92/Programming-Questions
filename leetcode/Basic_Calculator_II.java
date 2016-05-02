package leetcode;

public class Basic_Calculator_II {
	String str;
	int indx = 0;
	
	public int calculate(String s) {
		this.str = s;
		
		int res = 0, lhs = 0, rhs = 0;
		Character op = '+';
		Object o = getNextToken();
		
		while(o != null) {
			if(isOperator(o)) {
				op = (Character)o;
				if(op=='+'||op=='-') {
	                res += lhs;
	                lhs = 0;
	            }
				
			} else { 
				rhs = (Integer)o;
				switch(op) {
		            case '+': lhs += rhs; break;
		            case '-': lhs -= rhs; break;
		            case '*': lhs *= rhs; break;
		            case '/': lhs /= rhs; break;
				}
			}
			o = getNextToken();
		}
		return (res+lhs);
	}
	
	private boolean isOperator(Object c) {
		if(!(c instanceof Character))
			return false;
		
		c = (Character)c;
		
        if (c.equals('+') || c.equals('-')
                || c.equals('*') || c.equals('/'))
            return true;
        return false;
    }

	public Object getNextToken() {
		while(this.indx < this.str.length() && this.str.charAt(this.indx) == ' ')
			this.indx++;
		
		if(this.indx == this.str.length())
			return null;
		
		Character c = this.str.charAt(this.indx++);
		
		// if operator
		if(c == '+' || c == '-' || c == '*' || c == '/') 
			return c;
		
		// must be number
		Integer num = c - '0';
		
		// single digit number
		// remember indx has already been incremented
		// check if indx is at the end of the string, if yes return
		// check if present value at indx is not a number, if yes return
		if(this.indx == this.str.length() || (this.str.charAt(indx) < '0' || this.str.charAt(indx) > '9') )
			return num;
		
		// get next number which has more than 1 digit
		while(this.indx < this.str.length() && (this.str.charAt(this.indx) >= '0' && this.str.charAt(this.indx) <= '9') ) {
			num *= 10;
			num += this.str.charAt(this.indx++) - '0';
		}
		return num;
	}
	
	public static void main(String[] args) {
		String s = "0";
		System.out.println(new Basic_Calculator_II().calculate(s));
	}
}
