package step1;
import java.util.*;
public class Num2446 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int len = 2*n - 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < len - (i*2); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = n-2; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < len - (i*2); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
