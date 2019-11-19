package step1;
import java.io.*;
import java.util.*;
public class Num10818 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			int res = Integer.parseInt(st.nextToken());
			max = Math.max(max, res);
			min = Math.min(min, res);
		}		
		System.out.printf("%d %d", min, max);
	}
}
