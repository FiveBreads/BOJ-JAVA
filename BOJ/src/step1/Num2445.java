package step1;
import java.util.*;
public class Num2445 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int it = 2*n - 1;
		int len = 2*n;
		int space = len-2;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			for(int j = 1; j <= space; j++) {
				System.out.print(" ");
			}
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			space -= 2;
			System.out.println();
		}
		space = 2;
		for(int i = n - 1; i >= 1; i--) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			for(int j = 1; j <= space; j++) {
				System.out.print(" ");
			}
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}	
			space += 2;
			System.out.println();
		}
	}
}
