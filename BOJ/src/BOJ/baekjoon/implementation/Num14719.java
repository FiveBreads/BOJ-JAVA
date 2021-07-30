package BOJ.baekjoon.implementation;

import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-07-30
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 빗물
 * content :
 * link : [https://www.acmicpc.net/problem/14719]
 */
public class Num14719 {

    static int[] world;
    static int answer;
    static int h, w;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc.nextInt();
        world = new int[w];
        answer = 0;
        for (int i = 0; i < w; i++) {
            world[i] = sc.nextInt();
        }
        while (h-- > 0){
            int start = 0;
            int end = 0;
            for (int i = 0; i < w; i++) {
                if (world[i] != 0){
                    start = i;
                    break;
                }
            }
            for (int i = w - 1; i >= 0 ; i--) {
                if (world[i] != 0){
                    end = i;
                    break;
                }
            }
            if (start == end) break;
            countZero(start, end);
            removeHeight();
        }
        System.out.println(answer);
    }

    static void countZero(int start, int end){
        int cnt = 0;
        for (int i = start; i <= end; i++) {
            if (world[i] == 0) cnt++;
        }
        answer += cnt;
    }

    static void removeHeight(){
        for (int i = 0; i < w; i++) {
            if (world[i] > 0) world[i]--;
        }
    }
}
