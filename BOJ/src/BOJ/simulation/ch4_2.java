package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ch4_2 {
    static int n, m, x, y, direction;
    static int cnt = 1;
    static int[][] map = new int[50][50];
    static int[][] data = new int[50][50];
                    // 북 동 남 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());



        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        data[x][y] = 1;
        int nx, ny, turnCnt = 0;
        while (true){
            turnLeft();
            nx = x + dx[direction];
            ny = y + dy[direction];
            if (map[nx][ny] == 0 && data[nx][ny] == 0) {
                map[nx][ny] = 1;
                x = nx;
                y = ny;
                cnt += 1;
                turnCnt = 0;
            } else {
                turnCnt++;
            }
            if (turnCnt == 4){
                nx = x - dx[direction];
                ny = y - dy[direction];
                if (data[nx][ny] == 0){
                    x = nx;
                    y = ny;
                }else {
                    break;
                }
                turnCnt = 0;
            }
        }
    }

    static void turnLeft(){
        direction--;
        if (direction == -1){
            direction = 3;
        }
    }

}
