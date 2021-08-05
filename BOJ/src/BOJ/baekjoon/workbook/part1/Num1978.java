package BOJ.baekjoon.workbook.part1;

import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-08-05
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 소수 찾기
 * content :
 * link : [https://www.acmicpc.net/problem/1978]
 */
public class Num1978 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = n;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 1) {
                result--;
                continue;
            }
            if (num == 2 || num == 3) continue;
            for (int j = 2; j < num; j++) {
                if (num % j == 0) {
                    result--;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
