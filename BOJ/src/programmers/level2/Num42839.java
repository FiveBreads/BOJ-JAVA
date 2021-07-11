package programmers.level2;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num42839 {
    static boolean[] visit;
    static Set<Integer> data;
    static char[] chars;

    static int n;

    public int solution(String numbers) {
        n = numbers.length();
        chars = numbers.toCharArray();
        visit = new boolean[n];
        data = new HashSet<>();

        for (int i = 1; i <= numbers.length(); i++) {
            for (int j = 0; j < chars.length; j++) {
                visit[j] = true;
                dfs(new StringBuilder().append(chars[j]), i);
                visit[j] = false;
            }
        }
        int answer = 0;
        for (Integer num : data) {
            if (num == 1 || num == 0) continue;
            int target = 2;
            boolean flag = false;
            while (target <= (num / 2)){
                if (num % target == 0) {
                    flag = true;
                    break;
                }
                target++;
            }
            if (!flag) answer++;
        }
        return answer;
    }

    private void dfs(StringBuilder builder, int count) {
        if (builder.length() == count){
            data.add(Integer.parseInt(builder.toString()));
        }
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            dfs(builder.append(chars[i]), count + 1);
            builder.deleteCharAt(builder.length() - 1);
            visit[i] = false;
        }
    }

    @Test
    void 소수_찾기(){
        Assertions.assertEquals(3, solution("17"));
        Assertions.assertEquals(2, solution("011"));
    }
}
