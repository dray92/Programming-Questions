package ctci;

/**
 * Real number between 0 and 1 passed in as a double.
 * Print binary representation, to 32 bits. If not 
 * possible, throw error.
 * @author Debosmit
 *
 */
public class Bits5_2 {
	
	private final int MAX_BIT_LENGTH = 32;
	
	public String getBinary(double value) {
		if(value >= 1 || value <= 0)
			throw new IllegalArgumentException("Value must be in the set (0, 1).");
		
		StringBuilder binary = new StringBuilder();
		binary.append("0.");
		while(value > 0) {
			// max allowed length
			if (binary.length() > MAX_BIT_LENGTH) 
				throw new IllegalArgumentException("Binary cannot be contained under"
						+ " " + MAX_BIT_LENGTH + " bits");
			
			double rem = value * 2;
			if (rem >= 1) {
				binary.append(1);
				value = rem - 1;	// force value back to (0,1)
			} else {
				binary.append(0);
				value = rem;
			}
		}
		
		return binary.toString();
	}
	
	public static void main(String[] args) {
		double value = 0.25;
		System.out.println(value + " in binary is: " + new Bits5_2().getBinary(value));
	}
}
