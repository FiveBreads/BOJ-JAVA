package BOJ.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by prayzz12@gmail.com on 2021-07-27
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 단어 뒤집기 2
 * content :
 * link : [https://www.acmicpc.net/problem/17413]
 */
public class Num17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] chars = input.toCharArray();

        Stack<Character> stk = new Stack<>();
        int startIdx = -1;
        int endIdx = -1;
        for (int i = 0; i < chars.length; i++) {
            char part = chars[i];
            if (part == '<') stk.push('<');
            else if (part == '>') stk.pop();
            else if ((i == chars.length - 1) || chars[i + 1] == ' ' || chars[i + 1] == '<'){
                if (stk.isEmpty()) {
                    endIdx = i;
                    char tmp;
                    while (startIdx <= endIdx){
                        tmp = chars[endIdx];
                        chars[endIdx] = chars[startIdx];
                        chars[startIdx] = tmp;
                        startIdx++;
                        endIdx--;
                    }
                    startIdx = -1;
                }
            }else if(part != ' ' && stk.isEmpty()){
                if (startIdx < 0) startIdx = i;
            }
        }
        String s = new String(chars);
        System.out.println(s);
    }
}
