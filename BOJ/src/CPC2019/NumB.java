package CPC2019;
import java.io.*;
import java.util.*;

public class NumB {
	static StringTokenizer st;
	// B는 A가 20000이상이어야 가능.
	// C는 A+B가 50000이상이어야 가능
	// C는 하나만 가능.

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		/*0 = A의 개수, 1 = B의 개수 , 2 = C의 개수*/
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());		
		
		HashMap<String, Integer> A_Menu = new HashMap<>();
		HashMap<String, Integer> B_Menu = new HashMap<>();
		HashMap<String, String> C_Menu = new HashMap<>();
		
		for(int i = 0; i < A; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String a = st.nextToken();
			int b = Integer.parseInt(st.nextToken());
			A_Menu.put(a, b);			
		}
		
		for(int i = 0; i < B; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String a = st.nextToken();
			int b = Integer.parseInt(st.nextToken());
			B_Menu.put(a, b);			
		}
		
		for(int i = 0; i < C; i++) {
			String a = br.readLine();
			C_Menu.put(a, a);
		}
		
		int order = Integer.parseInt(br.readLine());
		
		boolean canOrderB = false;
		boolean canOrderC = false;
		boolean oneC_menu = false;
		boolean isWrong = false;
		int sum = 0;
		
		for(int i = 0; i < order; i++) {
			if(sum >= 20000) { 
				canOrderB = true;
			}
			if(sum >= 50000) {
				canOrderC = true;
			}
			String ord = br.readLine();
			if(A_Menu.containsKey(ord)) {
				sum += A_Menu.get(ord);
			}else if(canOrderB && B_Menu.containsKey(ord)) {
				sum += B_Menu.get(ord);
			}else if(canOrderC && !oneC_menu) {
				oneC_menu = true;
			}else {
				isWrong = true;
			}
		}
		
		if(!isWrong) {
			System.out.println("Okay");
		}else {
			System.out.println("No");
		}
	}
}
