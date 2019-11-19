package step1;
import java.util.*;
public class Num1924 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.close();
		int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		int sum = 0;
		for(int i = 1; i < x; i++) {
			sum += month[i];
		}
		sum += y;
		sum = sum%7;
		System.out.println(day[sum]);		
	}
}
