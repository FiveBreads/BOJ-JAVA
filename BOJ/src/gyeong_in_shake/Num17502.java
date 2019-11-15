package gyeong_in_shake;

import java.util.*;
public class Num17502 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		String pal = sc.nextLine();
		
		int len = pal.length();
		char[] word = new char[len];
		
		for(int i = 0; i < len; i++) {
			word[i] = pal.charAt(i);
		}	
		int front = 0;
		int back = len - 1;
		
		for(front = 0; front < len; front++) {
			if(word[front] == word[back]) {
				if(word[front] == '?') {
					word[front] = word[back] = 'a';
				}			
			}else {
				if(word[front] == '?') {
					word[front] = word[back];
				}else {
					word[back] = word[front];
				}
			}
			back--;
		}
		
		String res = "";
		for(int i = 0; i < word.length; i++) {
			res += word[i];
		}
		System.out.println(res);
	}

}
