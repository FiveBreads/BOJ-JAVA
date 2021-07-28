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
 * content : stack
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
        StringBuilder answer = new StringBuilder();
        boolean isInner = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '<'){
                while (!stk.isEmpty()){
                    answer.append(stk.pop());
                }
                answer.append(chars[i]);
                isInner = true;
            }else if (chars[i] == '>'){
                answer.append(chars[i]);
                isInner = false;
            }else if (isInner){
                answer.append(chars[i]);
            }else if (!isInner && Character.isWhitespace(chars[i])){
                while (!stk.isEmpty()){
                    answer.append(stk.pop());
                }
                answer.append(chars[i]);
            }else{
                stk.push(chars[i]);
            }
        }
        while (!stk.isEmpty()){
            answer.append(stk.pop());
        }
        System.out.println(answer.toString());
    }
}
