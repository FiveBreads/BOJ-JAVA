package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ch4_2 {

    static int view;

    static void turnLeft(){
        view--;
        if (view < 0){
            view = 3;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        view = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][] isMoved = new boolean[n][m];
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                isMoved[i][j] = false;
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        int count = 0;
        int turn = 0;
        while (true){
            turnLeft();
            int nx = x + dx[view];
            int ny = y + dy[view];

            if (!isMoved[ny][nx] && map[ny][nx] != 1){
                x = nx;
                y = ny;
                isMoved[ny][nx] = true;
                count++;
                turn = 0;
                continue;
            }else {
                turn++;
            }
            if (turn == 4){
                nx = x - dx[view];
                ny = y - dy[view];
                if (map[ny][nx] == 0){
                    x = nx;
                    y = ny;
                }else {
                    break;
                }
                turn = 0;
            }
        }
        System.out.println(count);

        Map<String, Integer> data = new HashMap<>();
        Collection<Integer> values = data.values();
        for (Integer value : values) {
            
        }
    }
}
