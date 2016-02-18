package randomCode;

public class Solutn {
	static void StairCase(int n) {
        for(int i = 1 ; i <= n ; i++) {
            for(int j = n-i ; j >0 ; j--)
                System.out.print(" ");
            for(int k = 0 ; k < i ; k++)
                System.out.print("#");
            System.out.println();
        }
    }


	public static void main(String[] args) {
		StairCase(6);
	}
}
