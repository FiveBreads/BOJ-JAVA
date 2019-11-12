package dp1;

import java.io.*;
import java.util.*;
public class Num1932 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		int[][] input = new int[n+1][n+1];
		
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= i; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}		
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				if(j == 1) {
					input[i][j] = input[i][j] + input[i-1][j];
					continue;
				}
				if(i == j) {
					input[i][j] = input[i - 1][j - 1] + input[i][j];
					continue;
				}				
				input[i][j] = Math.max(input[i - 1][j], input[i - 1][j - 1]) + input[i][j];				
			}
		}
		Arrays.parallelSort(input[n]);
		System.out.println(input[n][n]);
	}
}
