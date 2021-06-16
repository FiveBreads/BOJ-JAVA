package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Num1829 {
//카카오프렌즈 컬러링북
    public static int[] solution(int m, int n, int[][] picture){
        int max_area = 0;
        int area_cnt = 0;
        boolean[][] visit = new boolean[m][n];
        long[][] pic = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visit[i][j] = false;
                pic[i][j] = picture[i][j];
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 0 || visit[i][j]) continue;
                Queue<Integer> xque = new LinkedList<>();
                Queue<Integer> yque = new LinkedList<>();
                xque.offer(i);
                yque.offer(j);
                visit[i][j] = true;
                int area_tmp_cnt = 1;
                while (!xque.isEmpty()){
                    int x = xque.poll();
                    int y = yque.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < m && ny < n && picture[nx][ny] == picture[i][j] && !visit[nx][ny]){
                            xque.offer(nx);
                            yque.offer(ny);
                            visit[nx][ny] = true;
                            area_tmp_cnt++;
                        }
                    }
                }
                area_cnt++;
                max_area = Math.max(max_area, area_tmp_cnt);
            }
        }
        int[] answer = new int[2];
        answer[0] = area_cnt;
        answer[1] = max_area;
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        return answer;
    }

    public static void main(String[] args) {
        /*int m = 6;
        int n = 4;
        int[][] arr = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 }, { 0, 0, 0, 3 } };*/
        int m = 6;
        int n = 4;
        int[][] arr = {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
        solution(m,n,arr);

    }
}
