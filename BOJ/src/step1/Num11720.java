package step1;
import java.util.*;
public class Num11720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		String a = sc.nextLine();
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += a.charAt(i) - '0';
		}
		System.out.println(sum);
	}
}
