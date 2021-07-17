package BOJ.baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by prayzz12@gmail.com on 2021-07-17
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 쇠막대기
 * content : 스택
 * link : [https://www.acmicpc.net/problem/10799]
 */


public class Num10799 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<String> stk = new Stack<>();

        int totalCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '('){
                stk.push("(");
            }else{ //닫는 경우
                String pop = stk.pop();
                if ("(".equals(pop)){ //바로 여는 것이 나왔다는 것은 이게 레이저 라는 것.
                    int count = 1;
                    while (!stk.isEmpty()){
                        if ("(".equals(stk.peek())){
                            stk.push(String.valueOf(count));
                            break;
                        }else{
                            count += Integer.parseInt(stk.pop());
                        }
                    }
                }else{ //laser가 나왔을 때
                    stk.pop(); //뺄건 빼고
                    totalCount += Integer.parseInt(pop) + 1;
                    int tmpCount = Integer.parseInt(pop);
                    while (!stk.isEmpty()){
                        if ("(".equals(stk.peek())){
                            stk.push(String.valueOf(tmpCount));
                            break;
                        }
                        tmpCount += Integer.parseInt(stk.pop());
                    }
                }
            }
        }
        System.out.println(totalCount);
    }
}
