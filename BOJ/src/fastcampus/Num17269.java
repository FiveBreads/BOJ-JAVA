package fastcampus;
import java.io.*;
import java.util.*;
public class Num17269 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int[] values = {3,2,1,2,4,3,1,3,1,1,3,1,3,2,1,2,2,2,1,2,1,1,1,2,2,1};
		//1. 짧은 단어 수만큼 번갈아가면서 배치한다. 남은단어는 그뒤에 촤라락
		//2. i + (i+1)을 더하는 작업을 반복한다.
		//3. 2의 결과가 10을 넘어갈 경우 1의 자리만 남긴다.
		//4. 두개가 남았을 때 종료한다.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a_len = Integer.parseInt(st.nextToken());
		int b_len = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		String A = st.nextToken();
		String B = st.nextToken();
		
		int min = a_len >= b_len ? b_len : a_len;
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < min; i++) {
			sb.append(A.charAt(i));
			sb.append(B.charAt(i));
		}
		if(min == a_len) {
			for(int i = min; i < b_len; i++) {
				sb.append(B.charAt(i));
			}
		}else {
			for(int i = min; i < a_len; i++) {
				sb.append(A.charAt(i));
			}
		}
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < sb.length(); i++) {
			list.add(values[(sb.charAt(i)-'A')]);
		}
		
		int range = a_len + b_len - 1;
		
		for(int i = 0; i < (range - 1); i++) { //반복횟수
			for(int j = 0; j < (range - i); j++) { //더하는 범위축소
				int x = list.get(j) + list.get(j+1);
				if(x >= 10) {
					x %= 10;
				}
				list.set(j, x);
			}
		}
		System.out.println(list.get(0)%10*10 + list.get(1) + "%");
	}
}
