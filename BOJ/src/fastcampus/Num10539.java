package fastcampus;
import java.io.*;
import java.util.StringTokenizer;
public class Num10539 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arrA = new int[N];
		int[] arrB = new int[N];
		for(int i  = 0; i < N; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			arrA[i] = (arrB[i] * (i+1)) - sum;
			sum += arrA[i];
		}
		for(int i = 0; i < N; i++) {
			System.out.print(arrA[i] + " ");
		}
	}
}
