package ctci;

/**
 * Write a method to replace all the spaces in a string
 * with '%20'. You may assume that the string has sufficient 
 * space at the end of the string to hold the additional
 * characters, and that you are given the 'true' length
 * of the string. Use char array in Java.
 * @author Debosmit
 *
 */
public class ArrayString1_4 {

	public void replace(char[] str, int length) {
		int spaces = 0;
		for(int i = 0 ; i < length ; i++)
			if(str[i] == ' ')
				spaces++;
		
		// the ' ' was taking up one character. 
		// the replacement string is '%20'
		// so, 2 new characters are added for every space
		int index = (spaces * 2) + length;
		
		if(str.length != index)
			throw new IllegalArgumentException("Char array size issue. "
					+ "Should be " + index + "; length " + str.length + " found.");
		
		// last index to be written
		index = index - 1;
		
		// start accessing characters from the end of the 
		// inputed char array
		// reducing spaces every time a space is encountered so 
		// that the first word in the string doesn't have to 
		// be rewritten
		for(int i = length - 1 ; i >= 0 && spaces > 0 ; i--) {
			char ch = str[i];
			// if character is not a space,
			// copy over to the end of the array
			if(ch != ' ')
				str[index--] = ch;
			else {
				str[index--] = '0';
				str[index--] = '2';
				str[index--] = '%';
				spaces--;
			}
		}
	}
	
	private char[] getRequiredCharArray(String st) {
		// get number of spaces
		int spaces = 0;
		for(int i = 0 ; i < st.length() ; i++)
			if(st.charAt(i) == ' ')
				spaces++;
		
		// append extra space to the end of string
		// use StringBuilder to save space since string is
		// being appended to inside a loop
		StringBuilder sb = new StringBuilder(st);
		// need an extra 2 spots for every space
		while(spaces > 0) {
			sb.append("  ");
			spaces--;
		}
		
		// convert to char array
		return sb.toString().toCharArray();
	}
	
	public static void main(String[] args) {
		ArrayString1_4 replaceSpace = new ArrayString1_4();
		String st = "Mr John Smith";
		char[] stChars = replaceSpace.getRequiredCharArray(st);
		
		System.out.println("Original string: " + st);
		
		// run op
		replaceSpace.replace(stChars, st.length());
		System.out.println("New string: " + new String(stChars));
	}
}
