package BOJ.search;

import java.util.Stack;

public class ch13_4 {

    static String solution(String w){
        if ("".equals(w)) return "";
        StringBuilder result = new StringBuilder();
        int index = balance_index(w);
        String u = w.substring(0, index+1);
        String v = w.substring(index+1);
        if (checkCorrectStr(u)){
            result.append(u)
                .append(solution(v));
        }else {
            result.append("(")
                .append(solution(v))
                .append(")")
                .append(deleteAndReverse(u));
        }
        return result.toString();
    }

    static int balance_index(String w){
        int count = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') count++;
            else count--;
            if (count == 0){
               return i;
            }
        }
        return 0;
    }

    static String deleteAndReverse(String u){
        if (u.length() <= 2) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < u.length()-1; i++) {
            if (u.charAt(i) == '(') sb.append(')');
            else sb.append('(');
        }
        return sb.toString();
    }

    static boolean checkCorrectStr(String str){
        if (str.charAt(0) != '(') return false;
        Stack<Character> stk = new Stack<>();
        stk.push(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ')'){
                Character pop = stk.pop();
                if (pop != '(') return false;
            }else {
                stk.push(str.charAt(i));
            }
        }
        if (stk.isEmpty()) return true;
        else return false;
    }

    public static void main(String[] args) {
        String str = "()))((()";
        System.out.println(solution(str));
    }
}
