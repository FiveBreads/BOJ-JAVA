package fastcampus;

import java.io.*;
import java.util.*;

public class Num1966 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		Queue<Map<Integer, Integer>> queue = new LinkedList<>();		
		
		for(int i = 0; i < testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			String[] arr = br.readLine().split(" ");			
			
			for(int j = 0; j < n; j++) {
				Map<Integer, Integer> map = new HashMap<>();
				map.put(j, Integer.parseInt(arr[i]));
				queue.offer(map);
			}
			
			Arrays.sort(arr);
			int idx = arr.length - 1;
			
			while(!queue.isEmpty())	{
							
			}			
		}		
	}
}
