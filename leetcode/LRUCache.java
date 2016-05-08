package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	private int capacity;
	private Map<Integer, Node> map;
	private Node head, tail;

	public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
        this.head = this.tail = null;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
        	Node node = map.get(key);
        	remove(node);
        	setHead(node);
        	return node.val;
        }
        return -1;
    }
    
    private void setHead(Node node) {
		node.next = head;
		node.prev = null;
		
		if(head != null)
			head.prev = node;
		
		head = node;
		
		if(tail == null)
			tail = head;
	}

	private void remove(Node node) {
		if(node == null)
			return;
		
		// adjust prev pointer
		if(node.prev != null)
			node.prev.next = node.next;
		else 
			head = node.next;
		
		// adjust next pointer
		if(node.next != null)
			node.next.prev = node.prev;
		else 
			tail = node.prev;
		
	}

	public void set(int key, int value) {
        if(map.containsKey(key)) {
        	Node node = map.get(key);
        	node.val = value;
        	remove(node);
        	setHead(node);
        } else {
        	Node node = new Node(key, value);
        	if(map.size() == capacity) {
        		map.remove(tail.key);
        		remove(tail);
        	}
        	setHead(node);
        	map.put(key, node);
        }
    }
    
    private class Node {
    	private int val, key;
    	private Node prev, next;
    	
    	public Node(int key, int val) {
    		this.key = key;
    		this.val = val;
    	}
    	
    	public String toString() {
    		Node cur = this;
    		String st = "";
    		while(cur != null) {
    			st += cur.val;
    			cur = cur.next;
    		}
    		
    		return st;
    	}
    }
    
    public static void main(String[] args) {
    	LRUCache lru = new LRUCache(3);
    	lru.set(1,1);
    	lru.set(2,2);
    	lru.set(3,3);
    	lru.set(4,4);
    	System.out.println(lru.get(4));
    	System.out.println(lru.get(3));
    	System.out.println(lru.get(2));
    	System.out.println(lru.get(1));
    	lru.set(5,5);
    	System.out.println(lru.get(1));
    	System.out.println(lru.get(2));
    	System.out.println(lru.get(3));
    	System.out.println(lru.get(4));
    	System.out.println(lru.get(5));
    }
}
