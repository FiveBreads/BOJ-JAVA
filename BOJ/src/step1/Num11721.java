package step1;
import java.util.*;
public class Num11721 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		for(int i = 0; i < input.length(); i++) {
			System.out.print(input.charAt(i));
			if((i+1) % 10 == 0) {
				System.out.println();
			}
		}
	}
}
