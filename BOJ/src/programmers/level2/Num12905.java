package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num12905 {

    public int solution(int [][]board)
    {
        int answer = 0;
        int[][] map = new int[board.length + 1][board[0].length + 1];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 0;
            }
        }

        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                if (board[i - 1][j - 1] == 0) continue;
                map[i][j] = Math.min(map[i - 1][j - 1], Math.min(map[i - 1][j], map[i][j - 1])) + 1;
                answer = Math.max(answer, map[i][j]);
            }
        }
        return answer * answer;
    }

    @Test
    void 가장_큰_정사각형_찾기(){
        Assertions.assertEquals(9, solution(new int[][]{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}));
        Assertions.assertEquals(4, solution(new int[][]{{0,0,1,1},{1,1,1,1}}));
    }
}
