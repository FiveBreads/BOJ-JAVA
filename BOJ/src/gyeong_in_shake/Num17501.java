package gyeong_in_shake;
import java.util.*;
import java.io.*;
public class Num17501 {	
	static StringTokenizer st;
	static String[][] input;
	static int[] numbers;
	static int front, back;
	
	static int dfs(String root, String left, String right, int leftNum, int rightNum, boolean flag) {
		int lNum = 0, rNum = 0, max = 0, min = 0;
		
		if(left.equals("+") || left.equals("-")) {
			lNum = Integer.parseInt(input[leftNum][1]);
			rNum = Integer.parseInt(input[leftNum][2]);
			max = dfs(left, input[lNum][0], input[rNum][0] ,lNum, rNum, false);
			flag = true;
		}
		flag = false;
		
		if(right.equals("+") || right.equals("-")) {
			lNum = Integer.parseInt(input[rightNum][1]);
			rNum = Integer.parseInt(input[rightNum][2]);
			min = dfs(right, input[rNum][0], input[rNum][0] ,lNum, rNum, false);
			flag = true;
		}		
		
		if(!flag) {
			if(front == back) 
				return numbers[front];
			if(root.equals("+")) {
				min = numbers[front++]; 
				max = numbers[front++];
				return min + max;
			}else { // root.equals("-")
				min = numbers[front++]; 
				max = numbers[back++];
				return max - min;
			}
		}else {
			if(root.equals("+")) {				
				return min + max;
			}else { // root.equals("-")				
				return max - min;
			}
		}				
	}	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int opEnd = 2*N - 1;
		input = new String[opEnd + 1][3];
		numbers = new int[opEnd + 1];
		front = 1;
		back = N;
		numbers[0] = -10001;
		for(int i = 1; i <= N; i++) {
			String a = br.readLine();
			numbers[i] = Integer.parseInt(a);
			input[i][0] = a;
		}
		for(int i = N + 1; i <= opEnd; i++) {
			numbers[i] = 10001;
			st = new StringTokenizer(br.readLine());
			input[i][0] = st.nextToken();
			input[i][1] = st.nextToken();
			input[i][2] = st.nextToken();
		}
		Arrays.sort(numbers);
		for(int str : numbers) {
			System.out.println(str);
		}
		int leftNum = Integer.parseInt(input[opEnd][1]);
		int rightNum = Integer.parseInt(input[opEnd][2]);
		int result = dfs(input[opEnd][0], input[leftNum][0], input[rightNum][0], leftNum, rightNum, false);
		System.out.println(result);
	}
}
