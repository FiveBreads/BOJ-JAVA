package fastcampus;
import java.io.*;
import java.util.*;
public class Num17269 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int[] values = {3,2,1,2,4,3,1,3,1,1,3,1,3,2,1,2,2,2,1,2,1,1,1,2,2,1};
		//1. ª�� �ܾ� ����ŭ �����ư��鼭 ��ġ�Ѵ�. �����ܾ�� �׵ڿ� �Ҷ��
		//2. i + (i+1)�� ���ϴ� �۾��� �ݺ��Ѵ�.
		//3. 2�� ����� 10�� �Ѿ ��� 1�� �ڸ��� �����.
		//4. �ΰ��� ������ �� �����Ѵ�.
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
		
		for(int i = 0; i < (range - 1); i++) { //�ݺ�Ƚ��
			for(int j = 0; j < (range - i); j++) { //���ϴ� �������
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
