package BOJ.baekjoon.data_structure;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by prayzz12@gmail.com on 2021-07-20
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 후위 표기식
 * content : stack
 * link : [https://www.acmicpc.net/problem/1918]
 */


public class Num1918 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        Stack<Character> stk = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isAlphabetic(chars[i])){
                builder.append(chars[i]);
            }else if (chars[i] == '('){
                stk.push(chars[i]);
            }else if (chars[i] == ')'){
                char oper;
                while (!stk.isEmpty() && (oper = stk.pop()) != '('){
                    builder.append(oper);
                }
            }else{
                while (!stk.isEmpty() && compareTo(stk.peek(), chars[i]) >= 0){
                    builder.append(stk.pop());
                }
                stk.push(chars[i]);
            }
        }
        while (!stk.isEmpty()){
            builder.append(stk.pop());
        }
        System.out.println(builder.toString());
    }

    public static int compareTo(char op1, char op2){
        int op1_pri = getPriority(op1);
        int op2_pri = getPriority(op2);
        return op1_pri - op2_pri;
    }

    public static int getPriority(char op){
        if (op == '*' || op == '/'){
            return 2;
        }else if (op == '+' || op == '-'){
            return 1;
        }else {
            return 0;
        }
    }
}
