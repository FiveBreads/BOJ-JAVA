package coding_test_2nd.impl;

public class ch12_4 {

    public static boolean checkLock(int[][] map, int n){
        for (int i = n; i < 2 * n; i++) {
            for (int j = n; j < 2 * n; j++) {
                if(map[i][j] != 1) return false;
            }
        }
        return true;
    }

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

        int keyLen = key.length;
        int lockLen = lock.length;

        int[][] map = new int[3 * lockLen][3 * lockLen];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = 0;
            }
        }

        for (int i = 0; i < lockLen; i++) {
            for (int j = 0; j < lockLen; j++) {
                map[i + lockLen][j + lockLen] = lock[i][j];
            }
        }
        for (int p = 0; p < 4; p++) {
            key = rotateMatrixBy90Degree(key);
            for (int i = lockLen-(keyLen-1); i < 2 * lockLen; i++) {
                for (int j = lockLen-(keyLen-1); j < 2 * lockLen; j++) {
                    for (int k = 0; k < keyLen; k++) {
                        for (int l = 0; l < keyLen; l++) {
                            map[i + k][j + l] += key[k][l];
                        }
                    }
                    if (checkLock(map, lockLen)){
                        return true;
                    }else{
                        for (int k = 0; k < lockLen; k++) {
                            for (int l = 0; l <lockLen; l++) {
                                map[i + k][j + l] -= key[k][l];
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] key = {
            {0, 0, 0},
            {1, 0, 0},
            {0, 1, 1}
        };
        int[][] lock = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        System.out.println(solution(key, lock));
    }
}
