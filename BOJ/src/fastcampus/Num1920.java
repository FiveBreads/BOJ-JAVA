package fastcampus;

import java.io.*;
import java.util.*;

public class Num1920 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//�Էº�
		br.readLine();
		HashSet<String> set = new HashSet<>();
		String[] A = br.readLine().split(" ");		
		for(String str : A) {
			set.add(str);
		}		
		br.readLine();
		String[] K = br.readLine().split(" ");		
		//������
		//�迭A�ȿ� K�迭�� ���� �����ϴ��� üũ		
		for(String str : K) {
			if(set.contains(str))
				System.out.println("1");
			else
				System.out.println("0");
		}
	}
}
