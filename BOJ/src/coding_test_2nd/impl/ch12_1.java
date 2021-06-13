package coding_test_2nd.impl;

import java.util.Scanner;

public class ch12_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int len = n.length();
        int left = 0;
        int right = 0;
        for (int i = 0; i < len / 2; i++) {
            left += n.charAt(i) - '0';
        }
        for (int i = len / 2; i < len; i++) {
            right += n.charAt(i) - '0';
        }
        if (left == right){
            System.out.println("LUCKY");
        }else{
            System.out.println("READY");
        }
    }
}
