package BOJ.baekjoon.workbook.part1;

import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-08-05
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 지능형 기차 2
 * content :
 * link : [https://www.acmicpc.net/problem/2460]
 */
public class Num2460 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int total = 0;
        for (int i = 0; i < 10; i++) {
            int out = sc.nextInt();
            int in = sc.nextInt();
            total += (in - out);
            max = Math.max(max, total);
        }
        System.out.println(max);
    }
}
