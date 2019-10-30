package fastcampus;
import java.io.*;
public class Num17389 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String grade = br.readLine();
		int bonus = 0;
		int totGrade = 0;
		for(int i = 0; i < N; i++) {
			if(grade.charAt(i) == 'O') {
				totGrade += i + 1 + bonus;
				bonus += 1;
			}else {
				bonus = 0;
			}			
		}
		System.out.println(totGrade);
	}
}
