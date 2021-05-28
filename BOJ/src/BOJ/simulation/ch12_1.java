package BOJ.simulation;

import java.util.Scanner;

public class ch12_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len = str.length();
        int half = len / 2;
        int left = 0;
        int right = 0;
        for (int i = 0; i < half; i++) {
            left += str.charAt(i) - '0';
        }
        for (int i = half; i < len; i++) {
            right += str.charAt(i) - '0';
        }
        if (left == right){
            System.out.println("LUCKY");
        }else {
            System.out.println("READY");
        }
    }
}
