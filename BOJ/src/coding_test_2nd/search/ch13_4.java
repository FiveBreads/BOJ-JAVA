package coding_test_2nd.search;

import java.util.Stack;

public class ch13_4 {

    public static boolean checkBalance(String str){
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '('){
                stk.push(str.charAt(i));
            }else{
                if (stk.pop() != '(') return false;
            }
        }
        return true;
    }

    private static int seperateW(String w) {
        //문자열 w를 u와 v로 분리한다.
        int open = 0;
        int close = 0;
        int index = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '('){
                open++;
            }else {
                close++;
            }
            if (open == close){
                index = i;
                break;
            }
        }
        return index;
    }

    public static String phaseFour(StringBuilder str){
        StringBuilder result = new StringBuilder();
        result.append(str.substring(1, str.length() - 1));
        for (int i = 0; i < result.length(); i++) {

        }
        return null;
    }

    public static String solution(String w){
        int index = seperateW(w);
        StringBuilder u = new StringBuilder(w.substring(0, index + 1));
        StringBuilder v = new StringBuilder(w.substring(index + 1));
        if (checkBalance(u.toString())){
            return solution(v.toString());
        }else {
            StringBuilder tmp = new StringBuilder();
            return tmp.append("(")
                .append(solution(v.toString()))
                .append(")")
                .append(phaseFour(u)).toString();
        }
    }
}
