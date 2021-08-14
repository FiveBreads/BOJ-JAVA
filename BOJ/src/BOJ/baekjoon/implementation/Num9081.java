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
        int t = sc.nextInt();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < t; i++) {
            char[] chars = sc.next().toCharArray();
            builder.append(nextPermutation(chars)).append("\n");
        }
        System.out.println(builder.toString());
    }

    static String nextPermutation(char[] chars) {
        int index = -1;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] < chars[i + 1]){ //정렬이 되어있다면 index를 올리면서 진행.
                index = i;
            }
        }

        if (index < 0) return new String(chars);

        char tmp;
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] > chars[index]){ //정렬이 안된 곳과 뒤에서부터 비교해서 바꿔준다. 정렬 해준다.
                tmp = chars[i];
                chars[i] = chars[index];
                chars[index] = tmp;
                break;
            }
        }
        Arrays.sort(chars, index + 1, chars.length);
        return new String(chars);
    }
}
//1차 풀이
/*
* public static void main(String[] args) {
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
* */