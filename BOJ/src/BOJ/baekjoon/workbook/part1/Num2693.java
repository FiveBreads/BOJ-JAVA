package BOJ.baekjoon.workbook.part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-08-05
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : N번째 큰 수
 * content :
 * link : [https://www.acmicpc.net/problem/2693]
 */
public class Num2693 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < t; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                list.add(sc.nextInt());
            }
            Collections.sort(list, Collections.reverseOrder());
            Object[] objects = list.toArray();
            builder.append(objects[2]).append("\n");
        }
        System.out.println(builder);
    }
}
