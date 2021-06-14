package coding_test_2nd.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Virus{
    private int x;
    private int y;

    public Virus(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
public class ch13_2 {

    public static int n, m;
    public static int blank_cnt = 0;

    public static int[][] lab;
    public static ArrayList<Virus> viruses = new ArrayList<>();

    public static int max_safe_area = 0;

    public static int[] dx = {1,-1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void spreadVirus(){
        int tmp_cnt = blank_cnt;
        for (int i = 0; i < viruses.size(); i++) {
            Virus virus = viruses.get(i);
            Queue<Integer> queX = new LinkedList<>();
            Queue<Integer> queY = new LinkedList<>();
            queX.add(virus.getX());
            queY.add(virus.getY());
            while (!queX.isEmpty()){
                int x = queX.poll();
                int y = queY.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && lab[nx][ny] == 0) {
                        tmp_cnt -= 1;
                        queX.offer(nx);
                        queY.offer(ny);
                    }
                }
            }
        }
        max_safe_area = Math.max(max_safe_area, tmp_cnt);
    }


    public static void dfs(int x, int y, int depth){
        if (depth == 3){
            //벽 3개가 쳐져 있으니까 여기서 이동거리 탐색
            spreadVirus();
            return;
        }
        for (int i = x; i < n; i++) {
            for (int j = y; j < m; j++) {
                if (lab[i][j] == 0){
                    lab[i][j] = 1;
                    dfs(i, j + 1, depth + 1);
                    lab[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lab = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2){
                    viruses.add(new Virus(i, j));
                }else if (lab[i][j] == 0){
                    blank_cnt++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (lab[i][j] == 0){
                    lab[i][j] = 1;
                    dfs(i, j + 1, 1);
                    lab[i][j] = 0;
                }
            }
        }
        System.out.println(max_safe_area - 3);
    }
}
