package BOJ.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ch5_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[][] map = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String data = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = data.charAt(j) - '0';
                visit[i][j] = false;
            }
        }
        Queue<Integer> queX = new LinkedList<>();
        Queue<Integer> queY = new LinkedList<>();
        Queue<Integer> queCnt = new LinkedList<>();
        queX.add(0);
        queY.add(0);
        queCnt.add(1);
        visit[0][0] = true;
        int x, y, cnt = 1;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (!queX.isEmpty()){
            x = queX.poll();
            y = queY.poll();
            cnt = queCnt.poll();
            visit[x][y] = true;
            if ((x+1) == n && (y+1) == m) break;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (map[nx][ny] == 1 && !visit[nx][ny]){
                    queX.add(nx);
                    queY.add(ny);
                    queCnt.add(cnt+1);
                }
            }
        }
        System.out.println(cnt);
    }
}
