package dp1;

import java.io.*;
import java.util.*;
public class Num1149 {

	static int[][] RGB;
	static int[][] a;
	static StringTokenizer st;
	
	static int MIN = Integer.MAX_VALUE;
	
	static int Min(int a, int b) {return a < b ? a : b;}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		a = new int[n+1][3];
		RGB = new int[n+1][3];		
		
		a[0][0] = a[0][1] = a[0][2] = RGB[0][0] = RGB[0][1] = RGB[0][2] = 0;
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");			
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
			a[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= n; i++) {
			RGB[i][0] = Min(RGB[i-1][1], RGB[i-1][2]) + a[i][0];
			RGB[i][1] = Min(RGB[i-1][0], RGB[i-1][2]) + a[i][1];
			RGB[i][2] = Min(RGB[i-1][0], RGB[i-1][1]) + a[i][2];
		}
		
		System.out.println(Min(Min(RGB[n][0],RGB[n][1]), RGB[n][2]));		
	}
}
