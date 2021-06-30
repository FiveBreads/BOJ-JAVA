package programmers.level2;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Num76502 {

    public int solution(String s) {
        Stack<Character> stk = new Stack<>();
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        Map<Character, Character> couple = new HashMap<>();
        couple.put('(', ')');
        couple.put('[', ']');
        couple.put('{', '}');
        couple.put(')', '(');
        couple.put(']', '[');
        couple.put('}', '{');

        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean isRight = true;
            for (int j = i; j < s.length(); j++) {
                Character c = list.get(j);
                if (c == '(' || c == '[' || c == '{'){
                    stk.push(c);
                }else if (!stk.isEmpty() && couple.get(c) == stk.peek()){
                    stk.pop();
                }else{
                    isRight = false;
                    break;
                }
            }
            if (!isRight) {
                while (!stk.isEmpty()){
                    stk.pop();
                }
                continue;
            }
            for (int j = 0; j < i; j++) {
                Character c = list.get(j);
                if (c == '(' || c == '[' || c == '{'){
                    stk.push(c);
                }else if (!stk.isEmpty() && couple.get(c) == stk.peek()){
                    stk.pop();
                }else{
                    isRight = false;
                    break;
                }
            }
            if (!isRight || !stk.isEmpty()) {
                while (!stk.isEmpty()){
                    stk.pop();
                }
                continue;
            }else{
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}
