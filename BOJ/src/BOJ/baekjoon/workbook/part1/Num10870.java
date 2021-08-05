package BOJ.baekjoon.workbook.part1;

import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-08-05
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 피보나치 수 5
 * content :
 * link : [https://www.acmicpc.net/problem/10870]
 */
public class Num10870 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 1) {
            System.out.println(n);
        }else{
            int[] fibo = new int[n + 1];
            fibo[0] = 0;
            fibo[1] = 1;
            for (int i = 2; i <= n; i++) {
                fibo[i] = fibo[i - 1] + fibo[i - 2];
            }
            System.out.println(fibo[n]);
        }
    }
}
