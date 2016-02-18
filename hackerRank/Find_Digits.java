package hackerRank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/find-digits
 * @author Debosmit
 *
 */
public class Find_Digits {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            if(n < 0 || n > 1000000000 )
                continue;
            int count = 0;
            int numDigits = (int)(Math.floor(Math.log10(n)) + 1);
            int temp = n;
            while(numDigits > 0) {
                int cur = temp%10;
                if(cur != 0 && n%cur == 0)
                    count++;
                temp /= 10;
                numDigits--;
            }
            System.out.println(count);
        }
    }
}
