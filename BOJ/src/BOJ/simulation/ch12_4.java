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

    public static void solution(int[][] key, int[][] lock){
        int n = key.length;
        int m = lock.length;
        int[][] newLock = new int[m * 3][m * 3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                newLock[i + m][j + m] = lock[i][j];
            }
        }
        for (int relocate = 0; relocate < 4; relocate++) {
            key = rotateMatrixBy90Degree(key);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {

                }
            }
        }

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

    }
}