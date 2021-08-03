package BOJ.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by prayzz12@gmail.com on 2021-08-03
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 마법사 상어와 블리자드
 * content :
 * link : [https://www.acmicpc.net/problem/21611]
 */
public class Num21611 {

    static class Bead {
        private int x;
        private int y;
        private int number; //1, 2, 3 가능

        public Bead(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.number = number;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Bead bead = (Bead) o;
            return x == bead.x && y == bead.y && number == bead.number;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, number);
        }
    }

    static int[][] playGround;
    static int N, M, sharkX, sharkY;

    static final int MIN_EXPLOSION_CNT = 4; //폭발은 4개 이상일 때

    static int[] dx = {0, -1, 1, 0, 0}; //0, 상, 하, 좌, 우
    static int[] dy = {0, 0, 0, -1 ,1};

    static int[] boomNumber; //1,2,3번의 구슬 폭발횟수 기록

    static Queue<int[]> magics;
    static Deque<Bead> beadQueue;

    static void init(){
        playGround = new int[N][N];
        sharkX = N / 2;
        sharkY = N / 2;
        boomNumber = new int[4];
        magics = new LinkedList<>();
        beadQueue = new LinkedList<>();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        init();

        //연습장 데이터 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                playGround[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //마법 (방향, 거리)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            magics.offer(new int[]{dir, len});
        }

        for (int i = 0; i < M; i++) {
            makeBeadQueue();
            int[] poll = magics.poll();
            blizzard(poll[0], poll[1]);
            explosion();
            changeBead();
            moveBead();
        }

        int answer = 0;
        for (int i = 1; i <= 3; i++) {
            answer = (boomNumber[i] * i);
        }
        System.out.println(answer);
    }

    //스킬 시전
    static void blizzard(int direction, int len){
        int nx = sharkX;
        int ny = sharkY;
        for (int i = 0; i < len; i++) {
            nx += dx[direction];
            ny += dx[direction];
            int number = playGround[nx][ny];
            beadQueue.remove(new Bead(nx, ny, number));
        }
    }

    //구슬 이동
    static void moveBead(){
        int[] dir = {3, 2, 4, 1}; //큐에 구슬이 들어가는 순서

        Deque<Bead> another = new LinkedList<>();

        int cnt = 1;
        int x = sharkX;
        int y = sharkY;
        while (true){
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < cnt; j++) {
                    if (!beadQueue.isEmpty()) return;
                    x += dx[dir[i]];
                    y += dy[dir[i]];
                    playGround[x][y] = beadQueue.poll().number;
                }
                if (i % 2 == 1) cnt++;
            }
        }
    }

    //구슬 폭발
    static void explosion(){
        boolean isBoom = true;
        while (isBoom){
            int nowNumber = 0;
            int cnt = 0;
            isBoom = false;
            Stack<Bead> stk = new Stack<>();
            while (!beadQueue.isEmpty()){
                Bead poll = beadQueue.poll();
                if (nowNumber == poll.number){
                    cnt++;
                }else{
                    if (cnt >= MIN_EXPLOSION_CNT){
                        isBoom = true;
                        //기록된 개수만큼 구슬 폭발시킴.
                        for (int i = 0; i < cnt; i++) {
                            stk.pop();
                            boomNumber[nowNumber]++;
                        }
                    }
                    nowNumber = poll.number;
                    cnt = 1;
                    stk.push(poll);
                }
            }
            if (cnt >= MIN_EXPLOSION_CNT){
                isBoom = true;
                //기록된 개수만큼 구슬 폭발시킴.
                for (int i = 0; i < cnt; i++) {
                    stk.pop();
                    boomNumber[nowNumber]++;
                }
            }else{
                while (!stk.isEmpty()){
                    beadQueue.addFirst(stk.pop());
                }
            }
        }
    }

    //구슬 변화
    static void changeBead(){
        int nowNumber = 0;
        int cnt = 0;
        Stack<Bead> stk = new Stack<>();
        while (!beadQueue.isEmpty()){
            Bead poll = beadQueue.poll();
            if (nowNumber == poll.number){
                cnt++;
            }else{
                for (int i = 0; i < cnt; i++) {
                    stk.pop();
                }
                stk.push(new Bead(0, 0, cnt));
                stk.push(new Bead(0, 0, nowNumber));

                nowNumber = poll.number;
                cnt = 1;
            }
        }
        for (int i = 0; i < cnt; i++) {
            stk.pop();
        }
        stk.push(new Bead(0, 0, cnt));
        stk.push(new Bead(0, 0, nowNumber));
        while (!stk.isEmpty()){
            beadQueue.addFirst(stk.pop());
        }
    }

    //같은 번호인지 확인
    static boolean isSameNumber(){
        return false;
    }

    static void makeBeadQueue(){
        //dir 3, 2, 4 ,1
        int[] dir = {3, 2, 4, 1}; //큐에 구슬이 들어가는 순서

        int cnt = 1;
        int x = sharkX;
        int y = sharkY;
        while (true){
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < cnt; j++) {
                    x += dx[dir[i]];
                    y += dy[dir[i]];
                    if (x < 0 || x >= N || y < 0 || y >= N || playGround[x][y] == 0) {
                        return;
                    }
                    beadQueue.offer(new Bead(x, y, playGround[x][y]));
                }
                if (i % 2 == 1) cnt++;
            }
        }
    }
}
