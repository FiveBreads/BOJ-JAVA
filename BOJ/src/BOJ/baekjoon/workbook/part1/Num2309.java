package BOJ.baekjoon.workbook.part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-08-05
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 일곱 난쟁이
 * content :
 * link : [https://www.acmicpc.net/problem/2309]
 */
public class Num2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int dwarf = sc.nextInt();
            list.add(dwarf);
            sum += dwarf;
        }
        Collections.sort(list);
        int i, j;
        for (i = 0; i < 9; i++) {
            int tmp = sum - list.get(i);
            for (j = 0; j < 9; j++) {
                if (j == i) continue;
                if (tmp - list.get(j) == 100){
                    for (int k = 0; k < list.size(); k++) {
                        if (k != i && k != j) {
                            System.out.println(list.get(k));
                        }
                    }
                    return;
                }
            }
        }
    }
}
