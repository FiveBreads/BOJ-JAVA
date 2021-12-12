package BOJ.baekjoon.myarray;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-12-12
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 접미사 배열
 * content :
 * link : [https://www.acmicpc.net/problem/11656]
 */
public class Num11656 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] arr = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.substring(i);
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(str -> {
            sb.append(str).append("\n");
        });
        System.out.println(sb);
    }
}
