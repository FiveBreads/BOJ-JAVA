package BOJ.baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by prayzz12@gmail.com on 2021-07-16
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 후위 표기식2
 * content : stack
 * link : [https://www.acmicpc.net/problem/1935]
 */
public class Num1935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        Map<Character, Double> map = new HashMap<>();
        char alpha = 'A';
        for (int i = 0; i < N; i++) {
            map.put(alpha, Double.parseDouble(br.readLine()));
            alpha = (char) (alpha + 1);
        }

        Stack<Double> stk = new Stack<>();
        Double front, end;

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)){
                case '*':
                    end = stk.pop();
                    front = stk.pop();
                    front *= end;
                    stk.push(front);
                    break;
                case '-':
                    end = stk.pop();
                    front = stk.pop();
                    front -= end;
                    stk.push(front);
                    break;
                case '+':
                    end = stk.pop();
                    front = stk.pop();
                    front += end;
                    stk.push(front);
                    break;
                case '/':
                    end = stk.pop();
                    front = stk.pop();
                    front /= end;
                    stk.push(front);
                    break;
                default:
                    stk.push(map.get(str.charAt(i)));
            }
        }
        System.out.println(String.format("%.2f", stk.pop()));
    }
}
