package BOJ.baekjoon.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-07-30
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : ZOAC
 * content : 이분 탐색
 * link : [https://www.acmicpc.net/problem/16719]
 */
public class Num16719 {

    static boolean[] visit;
    static char[] chars;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        chars = sc.nextLine().toCharArray();
        visit = new boolean[chars.length];

        zoac(0, chars.length - 1);
    }

    static void zoac(int start, int end){
        char min = Character.MAX_VALUE;
        int index = -1;
        for (int i = start; i <= end; i++) {
            if (min > chars[i]){
                min = chars[i];
                index = i;
            }
        }
        if (index == -1) return;
        visit[index] = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (visit[i]){
                sb.append(chars[i]);
            }
        }
        System.out.println(sb);
        zoac(index + 1, end);
        zoac(start, index - 1);
    }
}