package ctci;

/** 
 * What does this code do?
 *  (n & (n-1)) == 0
 * @author Debosmit
 *
 */
public class Bits5_4 {

	public static void main(String[] args) {
		
		for(int i = 0 ; i < 100 ; i++) 
			System.out.println("(" + i + ") " + Integer.toBinaryString(i) + 
					"  &&  " + "(" + (i+1) + ") " +
								Integer.toBinaryString(i-1) + "  =  " + 
								 	"(" + (i & (i-1)) + ") " + 
								 	Integer.toBinaryString( i & (i-1) ));
		
		// we find that for 2^i such that i is in the set [0,1,2,..], we get 0
	}
}
