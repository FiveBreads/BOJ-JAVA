package BOJ.baekjoon.workbook.part2;

import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-08-11
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 부분 문자열
 * content :
 * link : [https://www.acmicpc.net/problem/16916]
 */
public class Num16916 {

    static int[] part;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String targetPartStr = sc.next();

        part = setPart(targetPartStr);
        System.out.println(kmp(str, targetPartStr));
    }

    static int kmp(String str, String targetPartStr){
        int index = 0;
        for (int i = 1; i < str.length(); i++) {
            while (str.charAt(i) != targetPartStr.charAt(index) && index > 0){
                index = part[i - 1];
            }
            if (str.charAt(i) == targetPartStr.charAt(index)){
                index++;
            }
            if (index >= targetPartStr.length()) return 1;
        }
        return 0;
    }

    static int[] setPart(String str){
        int[] iterArr = new int[str.length()];
        int index = 0;

        for (int i = 1; i < str.length(); i++) {
            while (str.charAt(i) != str.charAt(index) && index > 0){ //반복이 끝났다.
                index = iterArr[index - 1];
            }
            if (str.charAt(i) == str.charAt(index)){
                iterArr[i] = ++index;
            }
        }
        return iterArr;
    }
}











//1회차 풀이
/*
static int[] pi;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();

        pi = getIterInfo(p);
        System.out.println(kmp(s, p));
    }

    static int kmp(String target, String str){
        int idx = 0;
        for (int targetIdx = 0; targetIdx < target.length(); targetIdx++) {
            while (target.charAt(targetIdx) != str.charAt(idx) && idx > 0){
                idx = pi[idx - 1];
            }
            if (target.charAt(targetIdx) == str.charAt(idx)){
                idx++;
            }
            if (idx >= str.length()) return 1;
        }
        return 0;
    }

    static int[] getIterInfo(String str){
        int[] iterArr = new int[str.length()];
        int idx = 0;
        for (int i = 1; i < str.length(); i++) {
            while (str.charAt(i) != str.charAt(idx) && idx > 0){ //반복이 끝났다.
                idx = iterArr[idx - 1];
            }
            if (str.charAt(i) == str.charAt(idx)){
                idx++;
                iterArr[i] = idx;
            }
        }
        return iterArr;
    }
* */