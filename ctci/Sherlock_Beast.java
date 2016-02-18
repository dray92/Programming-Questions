package ctci;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-the-beast
 * @author Debosmit
 *
 */

public class Sherlock_Beast {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            if(n <= 1 || n == 2 || n == 4) {
                System.out.println("-1");
                continue;
            }
            // num 3's -> 0, 5, 10, 15, ..
            // num 5's -> 0, 3, 6, 9, 12, ..
            
            // if n%3 == 0, can fill with 5's
            if(n%3 == 0) {
                print(5, n);
            } else {
                // must either be a combination of 3's and 5's
                // or only 3's
                // if putting 3's, must put at least 5 3's
                // is there space left for at least 3 5's?
                if((n - 5) >= 3) {
                    int num5s = 0, num3s = 5;
                    
                    // is n - num3s a multiple of 3?
                    // if yes, num5s = (n-num3s)/3
                    // else, increment num3s by 5 till condition is reached
                    while( (n-num3s)%3 != 0) {
                        num3s += 5;
                    }
                    print(5, n - num3s);
                    print(3, num3s);
                } else {
                    print(3, n);
                }
            }
            
            System.out.println();    
        }
    }
    
    private static void print(int digit, int times) {
        for(int i = 0 ; i < times ; i++)
            System.out.print("" + digit);
    }
}
