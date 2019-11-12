package fastcampus;

import java.io.*;
import java.util.*;

public class Num1874 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] ar = new int[n];
		for(int i = 0; i < ar.length; i++) {
			ar[i] = Integer.parseInt(br.readLine());
		}
		List<Character> list = new ArrayList<>();
		Stack<Integer> stack = new Stack();
		int count = 1;
		
		for(int i = 0; i < n; i++) {
			while(count <= ar[i]) {
				stack.push(count);
				list.add('+');
				count++;
			}
			if(stack.peek() == ar[i]) {
				stack.pop();
				list.add('-');
			}else {
				System.out.println("NO");
				System.exit(0);
			}
		}		
		for(int i =0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
