package hackerRank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/2d-array
 * @author Debosmit
 *
 */
public class Array_2D_DS {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] ar = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                ar[i][j] = in .nextInt();
            }
        }
        printMax(ar);
        in.close();
    }

    private static void printMax(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {

                int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] 
                			+ arr[i + 1][j + 1] 
                			+ arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                max = Math.max(sum, max);
            }
        }
        System.out.println(max);
    }
}