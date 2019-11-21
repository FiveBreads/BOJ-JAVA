package step1;
import java.util.*;
public class Num2522 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		for(int i = 1; i <= n; i++) {
			for(int j = n-i; j > 0; j--) {
				System.out.print(" ");
			}
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 1; i <= n - 1; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for(int j = n-i; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
