package projectEuler;

public class Problem14 {
	
	public static void main(String[] args) {
		final int number = 1000000;
		 
		long sequenceLength = 0;
		long startingNumber = 0;
		long sequence;
		 
		for (int i = 2; i <= number; i++) {
		    int length = 1;
		    sequence = i;
		    while (sequence != 1) {
		        if ((sequence % 2) == 0) {
		            sequence = sequence / 2;
		        } else {
		            sequence = sequence * 3 + 1;
		        }
		        length++;
		    }
		 
		    //Check if sequence is the best solution
		    if (length > sequenceLength) {
		        sequenceLength = length;
		        startingNumber = i;
		    }
		}
		System.out.println(startingNumber);
	}

}
