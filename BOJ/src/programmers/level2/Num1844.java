package programmers.level2;

public class Num1844 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public  void dfs(int x, int y, int[][] maps, int[][] visit){
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int next_value = visit[x][y] + 1;
            if (nx < 0 || ny < 0
                || nx >= maps.length || ny >= maps[0].length
                || (visit[nx][ny] > 0 && visit[nx][ny] <= next_value) || maps[nx][ny] == 0) continue;
            visit[nx][ny] = next_value;
            dfs(nx, ny, maps, visit);
        }
    }

    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        int[][] visit = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = -1;
            }
        }
        visit[0][0] = 1;
        dfs(0,0, maps, visit);

        return visit[n-1][m-1];
    }
}