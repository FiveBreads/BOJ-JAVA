package gyeong_in_shake;
import java.util.*;

public class Num17300 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = Integer.parseInt(sc.nextLine());
		
		boolean[] visited = new boolean[10];
		int[] pattern = new int[L];
		String res = "YES";
		
		for(int i = 0; i < L; i++) {
			pattern[i] = sc.nextInt();
		}
		sc.nextLine();
		int num = pattern[0];
		visited[num] = true;
		for(int i = 1; i < L; i++) {
			num = pattern[i];
			if( visited[num] ) {
				res = "NO";
				break;
			}else if( num == 5 || pattern[i-1] == 5 ){
				visited[num] = true;
			}else if( (pattern[i-1] + pattern[i])%2 == 0 ){				
				int a = (pattern[i-1] + pattern[i])/2;
				if(visited[a]) {
					visited[num] = true;
				}else {
					res = "NO";
					break;
				}
			}else {
				visited[num] = true;
			}		
		}		
		System.out.println(res);		
	}
}
