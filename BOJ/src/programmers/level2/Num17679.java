package programmers.level2;

import java.util.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num17679 {

    public int solution(int m, int n, String[] board) {
        LinkedList<LinkedList<Character>> map = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            map.add(new LinkedList<>());
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.get(i).add(board[i].charAt(j));
            }
        }

        char left_top, right_top, left_bot, right_bot;
        boolean flag = true;

        int answer = 0;
        while (flag){
            flag = false;
            boolean[][] del = new boolean[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    left_top = map.get(i).get(j);
                    right_top = map.get(i).get(j + 1);
                    left_bot = map.get(i + 1).get(j);
                    right_bot = map.get(i + 1).get(j + 1);
                    if (left_top == '-') continue;
                    if (left_top == right_top && left_bot == right_bot && left_top == left_bot && right_top == right_bot){
                        del[i][j] = true;
                        del[i][j + 1] = true;
                        del[i + 1][j] = true;
                        del[i + 1][j + 1] = true;
                        flag = true;
                    }
                }
            }
            for (int i = m - 1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (del[i][j]){
                        Character remove = map.get(i).remove(j);
                        Character addition = '-';
                        if (i > 0){
                            addition = map.get(i - 1).remove(j);
                            del[i - 1][j] = true;
                            map.get(i - 1).add(j, '-');
                        }
                        map.get(i).add(j, addition);
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    @Test
    void 프렌즈4블록(){
        /*Assertions.assertEquals(14, solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        Assertions.assertEquals(15, solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
        Assertions.assertEquals(4, solution(7, 2, new String[]{"AA", "BB", "AA", "BB", "ZZ", "ZZ", "CC"}));
        Assertions.assertEquals(4, solution(2, 4, new String[]{"baab", "baab"}));*/
        Assertions.assertEquals(32, solution(6, 6, new String[]{"AABBEE","AAAEEE","VAAEEV","AABBEE","AACCEE","VVCCEE"}));
    }
}
