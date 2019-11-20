package step1;
import java.util.*;
public class Num2440 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		for(int i = N; i >= 1; i--) {
			for(int j = i; j >= 1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
