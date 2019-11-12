package fastcampus;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num15969 {
	/*วเบน*/
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] grade = new int[N];
		for(int i = 0; i < N; i++) {
			grade[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(grade);
		int min = grade[0];
		int max = grade[grade.length - 1];
		System.out.println(max - min);
	}
}
