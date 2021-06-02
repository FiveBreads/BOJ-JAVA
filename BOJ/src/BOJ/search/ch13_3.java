package BOJ.search;

import java.util.Scanner;

public class ch13_3 {

    public static int n, k, s, x, y;
    public static int[][] map = new int[201][201];

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static boolean[][] visit = new boolean[201][201];

    public static void dfs(int x, int y, int value){
        int nx = 0, ny = 0;
        for (int i = x; i <= n; i++) {
            for (int j = y; j <= n; j++) {
                if (!visit[i][j] && map[i][j] == value) {
                    visit[i][j] = true;
                    for (int m = 0; m < 4; m++) {
                        nx = i + dx[m];
                        ny = j + dy[m];
                        // 상, 하, 좌, 우 중에서 바이러스가 퍼질 수 있는 경우
                        if (nx > 0 && nx <= n && ny > 0 && ny <= n) {
                            if (map[nx][ny] == 0){
                                map[nx][ny] = value;
                                visit[nx][ny] = true;
                            }
                        }
                    }
                    dfs(i, j, value);
                }
            }
        }
        for (int m = 0; m < 4; m++) {
            if (nx > 0 && nx <= n && ny > 0 && ny <= n) {
                if (map[nx][ny] == value){
                    visit[nx][ny] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt();
                visit[i][j] = false;
            }
        }
        s = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();

        while (s > 0){
            for (int i = 1; i <= k; i++) {
                dfs(1, 1, i);
            }
            s--;
        }
        System.out.println(map[x][y]);
    }
}
