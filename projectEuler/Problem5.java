package projectEuler;

public class Problem5 {
	
	public static void main(String[] args) {
		for(int i = 100 ; i > 0 ; i++) {
			boolean evenlyDiv = true;
			for(int j = 2 ; j <= 20 ; j++) {
				if(i % j != 0) {
					evenlyDiv = false;
					break;
				}
			}
			if(evenlyDiv) {
				System.out.println(i);
				return;
			}
		}
	}
 
}
