package coding_test_2nd.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

class SnakeBody{
    private int x;
    private int y;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SnakeBody snakeBody = (SnakeBody) o;
        return x == snakeBody.x && y == snakeBody.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public SnakeBody(int x, int y) {
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

public class ch12_5 {

    static int[][] map;
                    //동  남  서  북
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int direction = 0;
    static int runtime = 0;
    static int n;

    static HashMap<Integer, String> move = new HashMap<>();

    static void startMove(int x, int y){
        Deque<SnakeBody> que = new LinkedList<>();
        que.offer(new SnakeBody(x, y));
        while (true){
            x = x + dx[direction];
            y = y + dy[direction];
            runtime++;
            SnakeBody sb = new SnakeBody(x, y);
            if (x < 1 || y < 1 || x > n || y > n) return;
            if (que.contains(sb)) return;
            que.addFirst(sb);
            if (map[x][y] != 1){
                que.removeLast();
            }
            changeDirection();
        }
    }

    static void changeDirection(){
        String str = move.get(runtime);
        if (str == null) return;
        if ("L".equals(str)){
            direction = (direction - 1) % 4;
        }else {
            direction = (direction + 1) % 4;
        }
        //if (direction == -1) direction = 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                map[i][j] = 0;
            }
        }

        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String movement = st.nextToken();
            move.put(x, movement);
        }

        startMove(1, 1);
        System.out.println(runtime);
    }
}
