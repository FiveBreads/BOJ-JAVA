package step1;
import java.util.*;
public class Num2739 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		sc.close();
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", N, i, N*i);
		}
	}
}
