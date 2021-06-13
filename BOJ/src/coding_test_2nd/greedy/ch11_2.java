package coding_test_2nd.greedy;

import java.util.Scanner;

public class ch11_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int result = str.charAt(0) - '0';
        for (int i = 1; i < str.length(); i++) {
            int tmp = str.charAt(i) - '0';
            if (result <= 1 || tmp <= 1){
                result += tmp;
            }else {
                result *= tmp;
            }
        }
        System.out.println(result);
    }
}
