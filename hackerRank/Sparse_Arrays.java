package hackerRank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sparse_Arrays {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0 ; i < N ; i++) {
            String st = sc.next();
            if(!map.containsKey(st))
                map.put(st, 0);
            map.put(st, map.get(st) + 1);
        }
        
        int M = sc.nextInt();
        for(int i = 0 ; i < M ; i++) {
            String st = sc.next();
            if(map.containsKey(st))
                System.out.println(map.get(st));
            else
                System.out.println(0);
        }
    }
}
