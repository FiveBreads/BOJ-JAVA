package BOJ.baekjoon.workbook.part1;

import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-08-05
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 소수
 * content :
 * link : [https://www.acmicpc.net/problem/2581]
 */
public class Num2581 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int sum = 0;
        int min = -1;
        for (int i = m; i <= n; i++) {
            if (isPrime(i)){
                sum += i;
                if (min < 0) min = i;
            }
        }
        if (min < 0){
            System.out.println(min);
        }else{
            System.out.println(sum);
            System.out.println(min);
        }
    }

    static boolean isPrime(int num){
        if (num == 1) return false;
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
