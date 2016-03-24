package projectEuler;

public class Problem112 {
	
	public static void main(String[] args) {
		int count = 0;
		int i = 99;
		int percentageNeeded = 99;
		while(100*count < percentageNeeded*i) {
			i++;
			if(isBouncy(i))
				count++;
		}
		System.out.println(i);
	}
	
	private static boolean isBouncy(int num) {
		boolean inc = false;
		boolean dec = false;
		
		int last = num % 10;
		num /= 10;
	 
		while(num > 0) {
			int next = num % 10;
			num /= 10;
	        if (next < last)
	            inc = true;
	        else if (next > last)
	            dec = true;
	 
	        last = next;
	 
	        if (dec && inc) return true;
		}
		
		return inc && dec;
	}
}
