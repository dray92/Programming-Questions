package ctci;

/**
 * Say you have a method isSubstring to check if a string
 * s2 is a substring of another string s1.
 * Write another method isRotation such that only one call 
 * to isRotation should return if s2 is a rotation of s1.
 * eg., s1 = waterbottle, s2 = erbottlewat
 * @author Debosmit
 *
 */
public class ArrayString1_8 {

	public boolean isSubstring(String s1, String s2) {
		if(s1.length() < s2.length())
			return isSubstring(s2, s1);
		return s1.indexOf(s2) >= 0;
	}
	
	public boolean isRotation(String s1, String s2) {
		int len = s1.length();
		
		if(s2.length() == len && len != 0)
			return isSubstring(s1+s1, s2);
		
		return false;
	}
	
	public static void main(String[] args) {
		ArrayString1_8 substring = new ArrayString1_8();
		
		String s1 = "waterbottle", s2 = "erbottlewat";
		System.out.println("String 1: " + s1);
		System.out.println("String 2: " + s2);
		System.out.println("Are they rotations? " + substring.isRotation(s1, s2));
	}
	
}
