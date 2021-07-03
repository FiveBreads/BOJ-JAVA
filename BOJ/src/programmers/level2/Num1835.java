package programmers.level2;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num1835 {
    public static char[] persons = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    public static boolean[] visit = new boolean[8];
    public static List<String> cases;

    public void dfs(int count, StringBuilder sb){
        if (count == 8){
            cases.add(sb.toString());
        }
        for (int i = 0; i < persons.length; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            dfs(count + 1, sb.append(persons[i]));
            sb.deleteCharAt(sb.length() - 1);
            visit[i] = false;
        }
    }

    public int solution(int n, String[] data) {
        cases = new ArrayList<>();
        for (int i = 0; i < visit.length; i++) {
            visit[i] = false;
        }

       for (int i = 0; i < persons.length; i++) {
            visit[i] = true;
            dfs(1, new StringBuilder().append(persons[i]));
            visit[i] = false;
        }
        int from_index, to_index, value;
        char oper;
        int answer = 0;
        for (int i = 0; i < cases.size(); i++) {
            boolean isCorrect = false;
            for (int j = 0; j < data.length; j++) {
                from_index = cases.get(i).indexOf(data[j].charAt(0));
                to_index = cases.get(i).indexOf(data[j].charAt(2));
                oper = data[j].charAt(3);
                value = data[j].charAt(4) - '0' + 1;
                if ('=' == oper && Math.abs(from_index - to_index) == value){
                    isCorrect = true;
                }else if ('>' == oper && Math.abs(from_index - to_index) > value){
                    isCorrect = true;
                }else if ('<' == oper && Math.abs(from_index - to_index) < value){
                    isCorrect = true;
                }else{
                    isCorrect = false;
                    break;
                }
            }
            if (isCorrect) answer++;
        }
        return answer;
    }

    @Test
    void 단체사진찍기(){
        Assertions.assertEquals(3648, solution(2, new String[]{"N~F=0", "R~T>2"}));
    }
}
