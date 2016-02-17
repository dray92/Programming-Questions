package ctci;

/**
 * Write a function to add 2 numbers
 * without using + or any other 
 * arithmetic operator.
 * @author Debosmit
 *
 */
public class Hard18_1 {

	public int add(int a, int b) {
		if(b == 0)
			return a;
		
		int sum = a^b;
		int carry = (a & b) << 1;
		return add(sum, carry);
	}
	
	public static void main(String[] args) {
		int a = 5, b = 3;
		System.out.println(new Hard18_1().add(a,b));
	}
}
