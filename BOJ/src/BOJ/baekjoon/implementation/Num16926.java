package BOJ.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by prayzz12@gmail.com on 2021-07-28
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 배열 돌리기
 * content :
 * link : [https://www.acmicpc.net/problem/16926]
 */
public class Num16926 {

    static int N,M,R;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //각 깊이 별 R번 씩 회전
        int start_x = 0;
        int end_x = N - 1;
        int start_y = 0;
        int end_y = M - 1;
        int cnt = 0;
        while (start_x < end_x){
            while (cnt < R){
                //4방향 회전
                int tmp_data = map[start_x][start_y];
                for (int i = start_y; i < end_y; i++) {
                    // <-방향
                    map[start_x][i] = map[start_x][i + 1];
                }

                for (int i = start_x; i < end_x; i++) {
                    //ㅅ
                    //|
                    map[i][end_y] = map[i + 1][end_y];
                }

                for (int i = end_y; i > start_x; i--) {
                    //->
                    map[end_x][i] = map[end_x][i - 1];
                }

                for (int i = end_x; i > start_x; i--) {
                    //|
                    //V
                    map[i][start_y] = map[i - 1][start_y];
                }
                map[start_x + 1][start_y] = tmp_data;
                cnt++;
            }
            start_x++;
            start_y++;
            end_x--;
            end_y--;
            cnt = 0;
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                answer.append(map[i][j]).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer.toString());
    }
}
