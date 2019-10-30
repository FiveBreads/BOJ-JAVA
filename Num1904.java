package dp1;

import java.io.*;

public class Num1904 {

	static long[] d;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		d = new long[n + 1];	
		
		d[1] = 1;
		d[2] = 2;
		for(int i = 3; i <= n ; i++) {
			d[i] = (d[i-1] + d[i-2]) % 15746;
		}		
		System.out.println(d[n]);		
	}
}
