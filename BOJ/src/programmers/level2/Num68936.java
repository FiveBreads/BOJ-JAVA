package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num68936 {

    static int[] answer;

    public int[] solution(int[][] arr) {
        // 0의 개수, 1의 개수
        answer = new int[2];
        dfs(arr, 0, 0, arr.length);
        return answer;
    }

    public void dfs(int[][] arr, int x, int y, int len) {
        boolean isZero = true;
        boolean isOne = true;
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (arr[i][j] == 0) isOne = false;
                else if (arr[i][j] == 1) isZero = false;
            }
        }
        //만약 0과 1이 둘 다 등장 했다면 isZero와 isOne은 둘다 false이기 때문에 더해줄 것이 없다.
        if (isZero){
            answer[0]++;
        }

        if (isOne){
            answer[1]++;
        }

        //둘다 false인 경우, 즉 0과 1이 번갈아가면서 등장한 경우에만 쪼개져서 재귀를 하고 아니면 멈춰!
        if (!isOne && !isZero){
            int half = len / 2;
            dfs(arr, x, y, half);
            dfs(arr, x + half, y, half);
            dfs(arr, x, y + half, half);
            dfs(arr, x + half, y + half, half);
        }
    }

    @Test
    void 쿼드압축_후_개수_세기(){
        Assertions.assertArrayEquals(new int[]{4,9}, solution(new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}}));
        Assertions.assertArrayEquals(new int[]{10,15}, solution(new int[][]{{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}}));
    }
}
