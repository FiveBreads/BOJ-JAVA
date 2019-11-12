package CPC2019;

import java.util.Scanner;
public class NumA {
	static String tmp_ask = "\"재귀함수가 뭔가요?\"";
	static String[] tmp_answer_not = {"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
										"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
										"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""};	
	static String tmp_realAnswer = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
	static String tmp_end = "라고 답변하였지.";
	static String tmp_line = "____";
	static boolean isEnd = false;
	
	static void recursive(int input, int lineC) {
		if(lineC == 0) {
			System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		}		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < lineC; i++) {
			sb.append(tmp_line);
		}
		
		System.out.println(sb.toString() + tmp_ask);
		if(input == 0) {
			isEnd = true;
			System.out.println(sb.toString() + tmp_realAnswer);
		}else {
			for(String tmp : tmp_answer_not) {
				System.out.println(sb.toString() + tmp);
			}
		}
		if(!isEnd) {
			recursive(input - 1, lineC + 1);
		}		
		System.out.println(sb.toString() + tmp_end);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int linec = 0;
		recursive(input, linec);
	}
}
