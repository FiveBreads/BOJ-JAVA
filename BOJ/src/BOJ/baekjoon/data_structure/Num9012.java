package BOJ.baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by prayzz12@gmail.com on 2021-07-16 
 * Blog : http://devonuu.tistory.com 
 * Github : http://github.com/devonuu 
 * title : 괄호
 * content : stack
 * link : [https://www.acmicpc.net/problem/9012]
 */
public class Num9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Stack<Character> stk;
        boolean isCor;

        for (int i = 0; i < T; i++) {
            isCor = true;
            stk = new Stack<>();
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '('){
                    stk.push('(');
                }else {
                    if (stk.isEmpty()){
                        isCor = false;
                        break;
                    }else{
                        stk.pop();
                    }
                }
            }
            if (!stk.isEmpty()) isCor = false;
            if (isCor){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
