package randomCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * http://www.journaldev.com/2774/java-8-stream-api-example-tutorial
 * @author Debosmit
 *
 */
public class Stream_Learning {
	
	private static int positiveSumIteratorApproach(List<Integer> list) {
		Iterator<Integer> it = list.iterator();
		int sum = 0;
		while(it.hasNext()) {
			int val = it.next();
			if(val > 0)
				sum += val;
		}
		return sum;
	}
	
	private static int positiveSumStreamApproach(List<Integer> list) {
		Stream<Integer> stream = list.stream();
		int sum = stream.filter(i -> i > 0).mapToInt(i -> i).sum();
		return sum;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0 ; i < 10 ; i++)
			list.add(i);
		System.out.println(positiveSumIteratorApproach(list));
		System.out.println(positiveSumStreamApproach(list));
	}
	
	private static void creatingStreams() {
		Stream<Integer> stream = Stream.of(1,2,3,4);
		
	}
}
