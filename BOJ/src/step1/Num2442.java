package step1;
import java.util.*;
public class Num2442 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		int len = 2*N - 1;
		int left = N, right = N;
		for(int i = 0; i < N; i++) {
			for(int j = 1; j < left; j++) {
				System.out.print(" ");
			}
			for(int j = left; j <= right; j++) {
				System.out.print("*");
			}			
			System.out.println();
			left--;
			right++;			
		}
	}
}
