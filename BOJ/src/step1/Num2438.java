package step1;
import java.util.*;
public class Num2438 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		String str = "*";
		for(int i = 0; i < N; i++) {
			System.out.println(str);
			str += "*";
		}
	}
}
