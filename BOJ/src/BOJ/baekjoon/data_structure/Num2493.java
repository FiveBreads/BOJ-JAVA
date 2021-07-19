package BOJ.baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by prayzz12@gmail.com on 2021-07-19 
 * Blog : http://devonuu.tistory.com 
 * Github : http://github.com/devonuu 
 * title : 탑
 * content : 스택
 * link : [https://www.acmicpc.net/problem/2493]
 */
 

public class Num2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<int[]> stk = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 1; i <= N; i++) {
            int tower = Integer.parseInt(st.nextToken());
            boolean canResponse = false;
            while (!stk.isEmpty()){
                if (stk.peek()[1] >= tower){
                    builder.append(stk.peek()[0]).append(" ");
                    canResponse = true;
                    break;
                }
                stk.pop();
            }
            if (!canResponse){
                builder.append(0).append(" ");
            }
            stk.push(new int[]{i, tower});
        }
        System.out.println(builder.toString().trim());
    }
}
