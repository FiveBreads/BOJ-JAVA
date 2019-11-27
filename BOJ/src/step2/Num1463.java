package step2;
import java.util.*;
public class Num1463 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int min = Integer.MAX_VALUE;
		int[] dp = new int[1000001];
		dp[1] = 0;
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i-1]+1;
			
		}
			
		System.out.println(min);
	}
}
