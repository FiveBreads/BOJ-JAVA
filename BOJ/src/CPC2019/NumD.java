package CPC2019;
import java.io.*;
import java.util.*;
public class NumD {
	static boolean[] isMyGirlGroup;
	static HashMap<String, Integer> girlGroup = new HashMap<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		isMyGirlGroup = new boolean[M];
		for(int i = 0; i < M; i++) {
			isMyGirlGroup[i] = false;
		}		
		
		for(int i = 0; i < M; i++) {
			girlGroup.put(br.readLine(), i);
		}
		
	}
}
