package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

class Snake{
    private int x;
    private int y;
    public Snake(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Snake snake = (Snake) o;
        return x == snake.x && y == snake.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class ch12_5 {
    static int[][] map;
    static HashMap<Integer, String> move = new HashMap<>();
    static Queue<Snake> snakeBody = new LinkedList<>();
    static int endTime = 0;
    static int direction = 0;

    public static void main(String[] args) throws IOException {
        int n, k, x, y, l;
        String c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        createMap();
        k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        //사과 위치 지정
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }
        //움직임 정보 저장
        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            c = st.nextToken();
            move.put(x,c);
        }
        startMove(1,1);
        System.out.println(endTime);
    }

    static void startMove(int nx, int ny){
        //뱀은 초당 1씩 움직인다.
        //맵의 바깥을 만나거나
        //자신의 몸과 부딪히면 게임이 끝난다.
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while (true){
            nx += dx[direction];
            ny += dy[direction];
            endTime++;
            if (nx == 0 || ny == 0 || nx == map.length || ny == map.length) break;
            Snake baem = new Snake(nx, ny);
            if (snakeBody.contains(baem)) break;
            snakeBody.add(baem);
            if (map[nx][ny] == 1){
                map[nx][ny] = 0;
            }else {
                snakeBody.poll();
            }
            //방향 바꾸기
            dirChange();
        }
    }

    static void dirChange(){
        String str = move.get(endTime);
        if (str == null) return;
        if ("L".equals(str)){
            direction = (direction - 1) % 4;
        }else {
            direction = (direction + 1) % 4;
        }
    }

    static void createMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = 0;
            }
        }
    }
}
