package BOJ.baekjoon.implementation;

import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-07-27
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 윤년
 * content :
 * link : [https://www.acmicpc.net/problem/2753]
 */
public class Num2753 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
