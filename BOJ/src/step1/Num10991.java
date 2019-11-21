package step1;
import java.util.*;
public class Num10991 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		//첫번째 별은 n번째 위치에 찍힐것.
		//마지막 별은 2*n-1번째 위치에 찍힐것.		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n - i; j++) {
				System.out.printf(" ");
			}
			for(int j = 1; j <= (i*2-1); j++) {
				if(j %2 == 0) {
					System.out.printf(" ");
				}else {
					System.out.printf("*");
				}
			}
			System.out.println();
		}
	}
}
