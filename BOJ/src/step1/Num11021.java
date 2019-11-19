package step1;
import java.util.Scanner;
public class Num11021 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println("Case #" + (i+1) + ": " + (a+b));
			sc.nextLine();
		}
	}
}
