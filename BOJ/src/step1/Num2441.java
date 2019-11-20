package step1;
import java.util.*;
public class Num2441 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		for(int i = 0; i < N; i++) {			
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < N-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
