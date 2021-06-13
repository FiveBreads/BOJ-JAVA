package coding_test_2nd.greedy;

import java.util.Scanner;

public class ch11_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int result = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) != str.charAt(i)){
                for (int j = i + 1; j < str.length(); j++) {
                    i++;
                    if (str.charAt(j) != str.charAt(j - 1)) break;
                }
                result++;
            }
        }
        System.out.println(result);
    }
}
