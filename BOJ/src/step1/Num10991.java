package step1;
import java.util.*;
public class Num10991 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		//ù��° ���� n��° ��ġ�� ������.
		//������ ���� 2*n-1��° ��ġ�� ������.		
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
