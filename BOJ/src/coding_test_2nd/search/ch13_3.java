package coding_test_2nd.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch13_3 {

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] tube = new int[n + 1][n + 1];
        boolean[][] visit = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                tube[i][j] = Integer.parseInt(st.nextToken());
                visit[i][j] = false;
            }
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        for (int i = 0; i < s; i++) { //진행 초
            for (int j = 1; j <= n; j++) { //x좌표
                for (int l = 1; l <= n; l++) { //y좌표
                    if (tube[j][l] != 0 && !visit[j][l]){
                        visit[j][l] = true;
                        for (int m = 0; m < 4; m++) {
                            int nx = j + dx[m];
                            int ny = l + dy[m];
                            if (nx > 0 && nx <= n && ny > 0 && ny <= n && tube[nx][ny] == 0) {
                                visit[nx][ny] = true;
                                tube[nx][ny] = tube[j][l];
                            }
                        }
                    }
                }
            }
            for (int j = 1; j <= n; j++) {
                for (int l = 1; l <= n; l++) {
                    visit[j][l] = false;
                }
            }
        }
        System.out.println(tube[x][y]);
    }
}
