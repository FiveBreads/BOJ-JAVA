package BOJ.baekjoon.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-07-31
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 단어 맞추기
 * content : next_permutation
 * link : [https://www.acmicpc.net/problem/9081]
 */
public class Num9081 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            String str = sc.next();
            char[] chars = next_permutation(str.toCharArray());
            if (chars == null){
                System.out.println(str);
            }else{
                System.out.println(new String(chars));
            }
        }
    }

    static char[] next_permutation(char[] chars) {
        int idx = -1;

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] < chars[i + 1]){
                idx = i;
            }
        }

        if (idx < 0) return null;

        char tmp;
        for (int i = chars.length - 1; i > idx; i--) {
            if (chars[i] > chars[idx]){
                tmp = chars[i];
                chars[i] = chars[idx];
                chars[idx] = tmp;
                break;
            }
        }
        Arrays.sort(chars, idx + 1, chars.length);
        return chars;
    }
}
