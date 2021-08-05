package BOJ.baekjoon.workbook.part1;

import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-08-05
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 최대공약수와 최소공배수
 * content :
 * link : [https://www.acmicpc.net/problem/2609]
 */
public class Num2609 {

    //a * b = gcd * lcm;
    //lcm = (a * b) / gcd;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int gcd = gcd(a, b);
        int lcm = lcm(a, b);

        System.out.println(gcd);
        System.out.println(lcm);
    }
    static int gcd(int a, int b) {
        int big = a;
        int small = b;
        if (a <= b) {
            big = b;
            small = a;
        }
        while (big % small != 0){
            int r = big % small;
            big = small;
            small = r;
        }
        return small;
    }

    static int lcm(int x, int y) {
        return (x * y) / gcd(x, y);
    }
}
