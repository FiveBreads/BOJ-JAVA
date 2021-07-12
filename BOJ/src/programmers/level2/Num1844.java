package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num1844 {

    static boolean[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] records;


    static int answer, n, m;

    /**
     * dfs는 시간초과임. bfs로 선회
     * @param x
     * @param y
     * @param count
     * @param maps
     */
    public void dfs(int x, int y, int count, int[][] maps){
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] != 0 && !visit[nx][ny]) {
                visit[nx][ny] = true;
                dfs(nx, ny, count + 1, maps);
                visit[nx][ny] = false;
            }
        }
        if (x == (n - 1) && y == (m - 1)){
            answer = Math.min(answer, count);
        }
    }

    public int solution(int[][] maps) {

        answer = Integer.MAX_VALUE;
        n = maps.length;
        m = maps[0].length;
        visit = new boolean[n][m];
        records = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                records[i][j] = 10001;
            }
        }

        Queue<Integer> queX = new LinkedList<>();
        Queue<Integer> queY = new LinkedList<>();

        queX.add(0);
        queY.add(0);

        records[0][0] = 1;

        while (!queX.isEmpty()){
            int x = queX.poll();
            int y = queY.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] != 0 && records[nx][ny] > (records[x][y] + 1)) {
                    records[nx][ny] = records[x][y] + 1;
                    queX.offer(nx);
                    queY.offer(ny);
                }
            }
        }
        //dfs(0, 0, 1, maps);
        if (records[n-1][m-1] == 10001){
            return -1;
        }else{
            return records[n-1][m-1];
        }
    }

    @Test
    void 게임_맵_최단거리(){
        Assertions.assertEquals(11, solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
        Assertions.assertEquals(-1, solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
    }
}