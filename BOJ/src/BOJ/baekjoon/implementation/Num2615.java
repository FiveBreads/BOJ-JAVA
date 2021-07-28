package BOJ.baekjoon.implementation;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-07-28
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 오목
 * content :
 * link : [https://www.acmicpc.net/problem/2615]
 */
public class Num2615 {

    static int[][] map;

    static final int N = 19;

    static int winner = 0;
    static int winnerX = -1;
    static int winnerY = -1;

    static int[] dx = {-1, 0, 1, 1}; //오른쪽 위 대각선, 오른쪽, 오른쪽 아래 대각선, 아래
    static int[] dy = {1, 1, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new int[N][N];
        //입력 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        //탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 0){
                    findWinner(i, j);
                    if (winner > 0) {
                        System.out.println(winner);
                        System.out.println(winnerX + " " + winnerY);
                        return;
                    }
                }
            }
        }
        System.out.println(winner);
    }

    static void findWinner(int x, int y) {
        int value = map[x][y];
        for (int i = 0; i < 4; i++) {
            // 4가지 경우의 수 판단
            int cnt = 1;
            int nx = x;
            int ny = y;
            for (int j = 0; j < 5; j++) {
                nx += dx[i];
                ny += dy[i];
                if (isInRange(nx, ny) && map[nx][ny] == value){
                    cnt++;
                }else {
                    break;
                }
            }
            if (cnt == 5){
                // 바둑알의 총 길이가 6 이상인지 판단.
                // 5개를 확인하고 앞 뒤로 하나씩 더 확인해서 없으면 되는것.
                nx = x - dx[i];
                ny = y - dy[i];
                if (isInRange(nx, ny) && map[nx][ny] == value) continue;
                winner = value;
                winnerX = x + 1;
                winnerY = y + 1;
            }
        }
    }

    static boolean isInRange(int x, int y){
        // 범위 안인지 판단
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
