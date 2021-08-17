package BOJ.baekjoon.greedy;

import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-08-17
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : A -> B
 * content :
 * link : [https://www.acmicpc.net/problem/16953]
 */
public class Num16953 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int result = 1;
        while (a < b){
            //홀수가 1 3 5 7 9가 있기 때문에 1인경우에만 허용하고 아니면 쳐내
            if (b % 2 == 0){
                b /= 2;
            }else if (b % 10 == 1){
                b /= 10;
            }else{
                break;
            }
            result++;
        }
        if (a == b){
            System.out.println(result);
        }else{
            System.out.println(-1);
        }
    }
}
