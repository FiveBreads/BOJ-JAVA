package BOJ.baekjoon.workbook.part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-08-05
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 쉽게 푸는 문제
 * content :
 * link : [https://www.acmicpc.net/problem/1292]
 */
public class Num1292 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        list.add(-1);
        for (int i = 1; i <= b; i++) {
            for (int j = 1; j <= i; j++) {
                list.add(i);
            }
        }

        int answer = 0;
        for (int i = a; i <= b; i++) {
            answer += list.get(i);
        }
        System.out.println(answer);
    }
}
