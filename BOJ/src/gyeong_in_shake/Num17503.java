package gyeong_in_shake;
import java.io.*;
import java.util.*;
public class Num17503 {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] beer = new int[K][2];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			beer[i][0] = Integer.parseInt(st.nextToken());
			beer[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		
	}

}
