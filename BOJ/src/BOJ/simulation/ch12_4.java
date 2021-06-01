package BOJ.simulation;

import java.util.*;

public class ch12_4 {
    // 2차원 리스트 90도 회전하기
    public static int[][] rotateMatrixBy90Degree(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] result = new int[n][m]; // 결과 리스트
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][n - i - 1] = a[i][j];
            }
        }
        return result;
    }

    public static boolean solution(int[][] key, int[][] lock){
        int n = key.length;
        int m = lock.length;
        int[][] newLock = new int[m * 3][m * 3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                newLock[i + m][j + m] = lock[i][j];
            }
        }
        int t = m - n + 1;
        for (int relocate = 0; relocate < 4; relocate++) {
            key = rotateMatrixBy90Degree(key);
            for (int i = t; i < 2*m; i++) {
                for (int j = t; j < 2*m; j++) { //key의 (0,0) 값이 움직일 수 있는 범위
                    //key가 lock에 값을 더하는 과정
                    for (int k = i; k < i+n; k++) {
                        for (int l = j; l < j+n; l++) {
                            newLock[k][l] += key[k][l];
                        }
                    }
                    if (check(newLock)){
                        return true;
                    }
                    for (int k = i; k < i+n; k++) {
                        for (int l = j; l < j+n; l++) {
                            newLock[k][l] -= key[k][l];
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean check(int[][] newLock){
        int m = newLock.length / 3;
        for (int i = m; i < m * 2; i++) {
            for (int j = m; j < m * 2; j++) {
                if (newLock[i][j] != 1) return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[][] key = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(solution(key, lock));
    }
}