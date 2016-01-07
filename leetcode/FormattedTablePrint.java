package leetcode;

public class FormattedTablePrint {

    public static void printRow(int[] row) {
        for (int i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int twoDm[][]= new int[7][5];
        int i,j,k=1;

        for(i=0;i<7;i++) {
            for(j=0;j<5;j++) {
                twoDm[i][j]=randomWithRange(-1, 1) * k;
                k++;
            }
        }

        for(int[] row : twoDm) {
            printRow(row);
        }
    }
    
    private static int randomWithRange(int min, int max) {
       int range = (max - min) + 1;     
       return (int)(Math.random() * range) + min;
    }
}