package BOJ.baekjoon.implementation;

import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-07-27
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 달팽이
 * content :
 * link : [https://www.acmicpc.net/problem/1913]
 */
public class Num1913 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int target = sc.nextInt();
        StringBuilder targetXY = new StringBuilder();


        int[][] dal = new int[N][N];
        int start = N / 2;
        int end = N / 2;
        int nx = start;
        int ny = start;
        int value = 1;

        dal[nx][ny] = value;
        checkTarget(target, nx, ny, value, targetXY);
        nx--;
        start--;
        end++;
        while (nx >= 0){
            //좌 -> 우
            while (ny <= end){
                dal[nx][ny] = ++value;
                checkTarget(target, nx, ny, value, targetXY);
                ny++;
            }
            ny = end;
            //상 -> 하
            while (nx < end){
                nx++;
                dal[nx][ny] = ++value;
                checkTarget(target, nx, ny, value, targetXY);
            }
            nx = end;

            //우 -> 좌
            while (ny > start){
                ny--;
                dal[nx][ny] = ++value;
                checkTarget(target, nx, ny, value, targetXY);
            }
            ny = start;

            //하 -> 상
            while (nx > start){
                nx--;
                dal[nx][ny] = ++value;
                checkTarget(target, nx, ny, value, targetXY);
            }
            nx = start;
            nx--;
            start--;
            end++;
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer.append(dal[i][j]).append(" ");
            }
            answer.append("\n");
        }
        answer.append(targetXY.toString());
        System.out.println(answer.toString());
    }

    private static void checkTarget(int target, int nx, int ny, int value, StringBuilder targetXY) {
        if (value == target) {
            targetXY.append(nx + 1).append(" ").append(ny + 1);
        }
    }
}
