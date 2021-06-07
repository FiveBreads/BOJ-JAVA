package BOJ.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Country{
    private int x;
    private int y;

    public Country(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}

public class ch13_7 {

    static int n, l, r, totCnt = 0;
    static int[][] countries;
    static boolean[][] visit;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean bfs(int x, int y){
        //값 변경용
        ArrayList<Country> list = new ArrayList<>();
        list.add(new Country(x, y));

        //값 저장용
        Queue<Country> que = new LinkedList<>();
        que.add(new Country(x,y));
        while (!que.isEmpty()){
            Country c = que.poll();
            int nx = c.getX();
            int ny = c.getY();
            for (int k = 0; k < 4; k++) {
                int gox = nx + dx[k];
                int goy = ny + dy[k];
                if (gox < 0 || goy < 0 || gox >= n || goy >= n || visit[gox][goy]) continue;
                int value = Math.abs(countries[nx][ny] - countries[gox][goy]);
                if (value >= l && value <= r) {
                    visit[gox][goy] = true;
                    que.add(new Country(gox,goy));
                    list.add(new Country(gox,goy));
                }
            }
        }
        if (list.size() == 1) return false;
        int sum = 0;
        int cnt = 0;
        //값 평균 로직
        for (int i = 0; i < list.size(); i++) {
            cnt++;
            int xx = list.get(i).getX();
            int yy = list.get(i).getY();
            sum += countries[xx][yy];
        }
        sum /= cnt;
        //값 변경 및 방문지 초기화
        for (int i = 0; i < list.size(); i++) {
            int xx = list.get(i).getX();
            int yy = list.get(i).getY();
            countries[xx][yy] = sum;
            visit[xx][yy] = false;
        }
        totCnt++;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        countries = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                countries[i][j] = Integer.parseInt(st.nextToken());
                visit[i][j] = false;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visit[i][j] = true;
                boolean isGroup = bfs(i,j);
                visit[i][j] = false;
                if(isGroup){
                    i = 0;
                    j = -1;
                }
            }
        }

        System.out.println(totCnt);
    }
}