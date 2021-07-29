package BOJ.baekjoon.implementation;

import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-07-29
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 배열 돌리기
 * content :
 * link : [https://www.acmicpc.net/problem/17276]
 */
public class Num17276 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int n, d;
        int[][] map;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < T; i++) {
            n = sc.nextInt();
            d = sc.nextInt();
            map = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    map[j][k] = sc.nextInt();
                }
            }

            rotate(map, n, d);

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    answer.append(map[j][k]).append(" ");
                }
                answer.append("\n");
            }
        }
        System.out.println(answer);
    }

    static void rotate(int[][] map, int n, int d){
        int cnt = 0;
        for (int i = n; i >= 3; i -= 2) {
            cnt++;
        }

        int abs = Math.abs(d);
        if (abs % 360 == 0) return;

        abs /= 45;
        int midIdx = (n - 1) / 2;

        for (int i = 0; i < cnt; i++) {
            int startIdx = i;
            int endIdx = n - 1 - i;
            for (int j = 0; j < abs; j++) {
                int tmp = map[startIdx][startIdx];
                if (d > 0){
                    //시계
                    map[startIdx][startIdx] = map[midIdx][startIdx];
                    map[midIdx][startIdx] = map[endIdx][startIdx];

                    map[endIdx][startIdx] = map[endIdx][midIdx];
                    map[endIdx][midIdx] = map[endIdx][endIdx];

                    map[endIdx][endIdx] = map[midIdx][endIdx];
                    map[midIdx][endIdx] = map[startIdx][endIdx];

                    map[startIdx][endIdx] = map[startIdx][midIdx];
                    map[startIdx][midIdx] = tmp;
                }else{
                    //반 시계
                    map[startIdx][startIdx] = map[startIdx][midIdx];
                    map[startIdx][midIdx] = map[startIdx][endIdx];

                    map[startIdx][endIdx] = map[midIdx][endIdx];
                    map[midIdx][endIdx] = map[endIdx][endIdx];

                    map[endIdx][endIdx] = map[endIdx][midIdx];
                    map[endIdx][midIdx] = map[endIdx][startIdx];

                    map[endIdx][startIdx] = map[midIdx][startIdx];
                    map[midIdx][startIdx] = tmp;
                }
            }
        }
    }
}
