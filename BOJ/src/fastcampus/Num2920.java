package fastcampus;

import java.io.*;
import java.util.*;

public class Num2920 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int[] ar = new int[arr.length];
		for(int i = 0; i < ar.length; i++) {
			ar[i] = Integer.parseInt(arr[i]);
		}
		
		boolean isAsc = true;
		boolean isDes = true;
		
		for(int i = 1; i < ar.length; i++) {
			if(ar[i-1] < ar[i]) {
				isDes = false;
			}else {
				isAsc = false;
			}
		}
		if(isAsc) {
			System.out.println("ascending");
		}else if(isDes) {
			System.out.println("descending");
		}else {
			System.out.println("mixed");
		}
	}
}
