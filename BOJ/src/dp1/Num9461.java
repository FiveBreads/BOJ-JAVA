package dp1;

import java.io.*;
public class Num9461 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		long[] d = new long[101];
		d[1] = 1;
		d[2] = 1;
		d[3] = 1;
		for(int i = 4; i <= 100; i++) {
			d[i] = d[i - 2] + d[i - 3];
		}
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(d[n]);
		}
	}
}
