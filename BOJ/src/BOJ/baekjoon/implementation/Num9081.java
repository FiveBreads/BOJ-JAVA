package BOJ.baekjoon.implementation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by prayzz12@gmail.com on 2021-07-31
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 단어 맞추기
 * content :
 * link : [https://www.acmicpc.net/problem/9081]
 */
public class Num9081 {

    static TreeSet<String> set;
    static boolean[] visit;
    static char[] chars;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            set = new TreeSet<>();
            chars = sc.next().toCharArray();
            visit = new boolean[chars.length];
            if (chars.length == 1) {
                System.out.println(new String(chars));
            }else{
                visit[0] = true;
                for (int j = 1; j < chars.length; j++) {
                    visit[j] = true;
                    word(2, new StringBuilder().append(chars[0]).append(chars[j]));
                    visit[j] = false;
                }
                if (set.size() == 1){
                    System.out.println(set.ceiling(new String(chars)));
                }else {
                    System.out.println(set.higher(new String(chars)));
                }
            }
        }
    }
    static void word(int count, StringBuilder sb){
        if (count == chars.length){
            set.add(sb.toString());
            return;
        }
        for (int i = 1; i < chars.length; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            word(count + 1, sb.append(chars[i]));
            sb.deleteCharAt(sb.length() - 1);
            visit[i] = false;
        }
    }

    static void word(){
        Queue<Character> que = new LinkedList<>();
        while (!que.isEmpty()){

        }
    }
}
