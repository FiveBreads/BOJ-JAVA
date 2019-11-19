package step1;
import java.util.*;
public class Num10953 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < T; i++) {
			String str = sc.nextLine();
			int a = str.charAt(0) - '0';
			int b = str.charAt(2) - '0';
			System.out.println(a+b);
		}
	}
}
