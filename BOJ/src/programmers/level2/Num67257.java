package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class Num67257 {

    public static List<Long> inputNums = new ArrayList<>();
    public static List<Character> inputOperator = new ArrayList<>();
    public static char[] operator = {'+', '-', '*'};
    public static boolean[] visit = new boolean[3];
    public static long answer = 0;

    public static void dfs(String opers){
        if (opers.length() == 3){
            List<Long> copyInputNums = new ArrayList<>(inputNums);
            List<Character> copyOperator = new ArrayList<>(inputOperator);
            for (int i = 0; i < opers.length(); i++) {
                for (int j = 0; j < copyOperator.size(); j++) {
                    if (opers.charAt(i) == copyOperator.get(j)){
                        long res = calculate(copyInputNums.remove(j), copyInputNums.remove(j), opers.charAt(i));
                        copyInputNums.add(j, res);
                        copyOperator.remove(j);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(copyInputNums.get(0)));
            return;
        }
        for (int i = 0; i < visit.length; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            dfs(opers + operator[i]);
            visit[i] = false;
        }
    }


    public static long calculate(long a, long b, char oper){
        if (oper == '+'){
            return a + b;
        }else if (oper == '-'){
            return a - b;
        }else{
            return a * b;
        }
    }

    public static long solution(String expression) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) - '0' >= 0 && expression.charAt(i) - '0' <= 9){
                sb.append(expression.charAt(i));
            }else{
                inputNums.add(Long.parseLong(sb.toString()));
                inputOperator.add(expression.charAt(i));
                sb = new StringBuilder();
            }
        }
        inputNums.add(Long.parseLong(sb.toString()));

        for (int i = 0; i < 3; i++) {
            visit[i] = true;
            dfs(operator[i] + "");
            visit[i] = false;
        }

        return answer;
    }

    public static void main(String[] args) {
        String str = "100-200*300-500+20";
        solution(str);
    }
}
