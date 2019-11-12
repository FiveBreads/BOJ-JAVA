package CPC2019;

import java.util.Scanner;
public class NumA {
	static String tmp_ask = "\"����Լ��� ������?\"";
	static String[] tmp_answer_not = {"\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.",
										"���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.",
										"���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\""};	
	static String tmp_realAnswer = "\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"";
	static String tmp_end = "��� �亯�Ͽ���.";
	static String tmp_line = "____";
	static boolean isEnd = false;
	
	static void recursive(int input, int lineC) {
		if(lineC == 0) {
			System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
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
