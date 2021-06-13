package coding_test_2nd.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ch12_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))){
                sum += str.charAt(i) - '0';
            }else {
                sb.append(str.charAt(i));
            }
        }
        char[] chars = sb.toString().toCharArray();
        Arrays.sort(chars);
        sb = new StringBuilder(new String(chars));
        sb.append(sum);
        System.out.println(sb.toString());
    }
}
