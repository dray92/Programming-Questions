package ctci;

import java.util.LinkedList;

/**
 * An animal shelter holds only dogs or cats.
 * The follow a strict 'first in first out' 
 * policy. You either pick the oldest animal
 * or the oldest cat/dog if you have a preference.
 * Support enqueue, dequeue, dequeueDog, dequeueCat.
 * Implement such a data structure.
 * @author Debosmit
 *
 */
public class StackQueue3_7 {
	
	public enum Animal {
		DOG, CAT;
	}
	
	public static class AnimalQueueNode {
		Animal kind;
		long index;
		
		public AnimalQueueNode(Animal kind) {
			this(kind, 0);
		}
		
		public AnimalQueueNode(Animal kind, long index) {
			this.kind = kind;
			this.index = index;
		}
		
		public String toString() {
			return "" + kind + "(" + index + ")";
		}
	}
	
	/** 
	 * not implementing the abstract class queue since
	 * that would require writing more methods than is
	 * required right now.
	 * @author Debosmit
	 */
	public static class AnimalQueue {
		LinkedList<AnimalQueueNode> dogList = new LinkedList<AnimalQueueNode>();
		LinkedList<AnimalQueueNode> catList = new LinkedList<AnimalQueueNode>();
		int curOrder = 0;
		
		/**
		 * Adds node signifying either a dog or a cat to the
		 * appropriate list. The value of the order variable 
		 * is updated accordingly.
		 * @param kind
		 */
		public void enqueue(Animal kind) {
			if(kind == Animal.DOG) {
				AnimalQueueNode newNode = new AnimalQueueNode(kind, ++curOrder);
				dogList.add(newNode);
			} else if(kind == Animal.CAT) {
				AnimalQueueNode newNode = new AnimalQueueNode(kind, ++curOrder);
				catList.add(newNode);
			} else 
				throw new IllegalArgumentException("Only cats and dogs are "
						+ "supported right now");
		}
		
		/**
		 * @return get the head of the dog list
		 */
		public AnimalQueueNode dequeueDog() {
			return dogList.remove();
		}
		
		/**
		 * @return get the head of the cat list
		 */
		public AnimalQueueNode dequeueCat() {
			return catList.remove();
		}
		
		/**
		 * @return get the head of the list
		 */
		public AnimalQueueNode dequeue() {
			if(dogList.size() == 0)
				return dequeueCat();
			else if(catList.size() == 0)
				return dequeueDog();
			
			AnimalQueueNode node = (dogList.peek().index < catList.peek().index) 
									? dogList.remove() : catList.remove();
									
			return node;	
		}
	}

	public static void main(String[] args) {
		AnimalQueue queue = new AnimalQueue();
		
		// add 2 dogs
		queue.enqueue(Animal.DOG);
		queue.enqueue(Animal.DOG);
		
		// add 2 cats
		queue.enqueue(Animal.CAT);
		queue.enqueue(Animal.CAT);
		
		// add dog, cat
		queue.enqueue(Animal.DOG);
		queue.enqueue(Animal.CAT);
		
		System.out.println("First animal: " + queue.dequeue());
		System.out.println("First cat: " + queue.dequeueCat());
		System.out.println("First dog: " + queue.dequeueDog());
		System.out.println("First animal: " + queue.dequeue()); 	// should be cat
	}
}
