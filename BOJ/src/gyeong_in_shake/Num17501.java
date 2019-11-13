package gyeong_in_shake;
import java.util.*;
import java.io.*;
public class Num17501 {
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());		
		int[] op = new int[N];	
		int countM = 0;
		long answer = 0;
		for(int i = 0; i < N; i++) {			
			op[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(op);
		int len = 2*N-1;
		for(int i = N; i < 2*N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String a = st.nextToken();
			if(a.equals("-")) {
				countM++;
				System.out.println("마이너스 갯수 : " + countM);
			}
		}
		int front = 0;
		int back = op.length - 1;
		while(countM > 0) {
			answer += (op[back] - op[front]);	
			front++;
			back--;
			countM--;
		}
		for(int i = front; i <= back; i++) {
			answer += op[i];
		}
		System.out.println(answer);		
	}
}
