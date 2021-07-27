package BOJ.baekjoon.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-07-27
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 소가 길을 건너간 이유 1
 * content :
 * link : [https://www.acmicpc.net/problem/14467]
 */
public class Num14467 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Map<Integer, Integer> move = new HashMap<>();
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int cow = sc.nextInt();
            int now = sc.nextInt();
            if (move.containsKey(cow)){
                Integer before = move.get(cow);
                if (before != now){
                    answer++;
                    move.put(cow, now);
                }
            }else{
                move.put(cow, now);
            }
        }
        System.out.println(answer);
    }
}
