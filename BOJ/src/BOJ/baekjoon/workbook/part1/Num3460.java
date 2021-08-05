package BOJ.baekjoon.workbook.part1;

import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-08-05
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 이진수
 * content :
 * link : [https://www.acmicpc.net/problem/3460]
 */
public class Num3460 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int cnt = 0;
            while (n > 0){
                if (n % 2 == 1) builder.append(cnt).append(" ");
                n /= 2;
                cnt++;
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }
}
