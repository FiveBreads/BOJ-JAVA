package BOJ.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch5_1 {

    static int[] dx = {1, -1, 0, 0,};
    static int[] dy = {0, 0, 1, -1};

    static int[][] bowl;
    static boolean[][] mark;

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        bowl = new int[n][m];
        mark = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                bowl[i][j] = str.charAt(j) - '0';
                mark[i][j] = false;
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)){
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    static boolean dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m || mark[x][y] || bowl[x][y] == 1) {
            return false;
        }else{
            mark[x][y] = true;
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }
    }
}
