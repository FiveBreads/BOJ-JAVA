package BOJ.baekjoon.workbook.part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by prayzz12@gmail.com on 2021-08-05
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 약수 구하기
 * content :
 * link : [https://www.acmicpc.net/problem/2501]
 */
public class Num2501 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        TreeSet<Integer> set = new TreeSet<>();
        int half = n / 2;
        for (int i = 1; i <= half; i++) {
            if (n % i == 0){
                set.add(i);
                set.add(n / i);
            }
        }

        if (k > set.size()){
            System.out.println(0);
        }else{
            ArrayList list = new ArrayList(set);
            System.out.println(list.get(k - 1));
        }
    }
}
