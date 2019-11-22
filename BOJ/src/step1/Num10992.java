package step1;
import java.util.*;
public class Num10992 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		for(int i = 1; i <= n; i++) {			
			if(i == n) {
				for(int j = 1; j <= 2*n - 1; j++) {
					System.out.printf("*");
				}
			}else {
				for(int j = 1; j <= n-i; j++) {
					System.out.printf(" ");
				}
				for(int j = 1; j <= (i * 2 - 1); j++) {
					if(j == 1 || j == (i * 2 - 1)) {
						System.out.print("*");
					}else {
						System.out.printf(" ");
					}
				}				
			}
			System.out.println();
		}			
	}
}
