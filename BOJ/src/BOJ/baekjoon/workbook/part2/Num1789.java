package BOJ.baekjoon.workbook.part2;

import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-08-21
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 수들의 합
 * content :
 * link : [https://www.acmicpc.net/problem/1789]
 */
public class Num1789 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = Long.parseLong(sc.next()); //서로 다른 n개의 자연수의 합이 s

        long count = 1;
        long sum = 1;

        while(sum < s){
            count++;
            sum += count;
        }
        if(sum > s){
            count--;
        }
        System.out.println(count);
    }
}
