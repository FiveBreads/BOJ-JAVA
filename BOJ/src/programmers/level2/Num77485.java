package programmers.level2;

public class Num77485 {
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows + 1][columns + 1];
        int count = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = count;
                count++;
            }
        }
        int[] answer = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            int x1 = queries[j][0];
            int y1 = queries[j][1];
            int x2 = queries[j][2];
            int y2 = queries[j][3];

            int temp = map[x1][y1];
            int min = temp;

            for (int i = x1; i < x2; i++) {
                map[i][y1] = map[i + 1][y1];
                min = Math.min(min, map[i][y1]);
            }

            for (int i = y1; i < y2; i++) {
                map[x2][i] = map[x2][i + 1];
                min = Math.min(min, map[x2][i]);
            }

            for (int i = x2; i > x1; i--) {
                map[i][y2] = map[i - 1][y2];
                min = Math.min(min, map[i][y2]);
            }

            for (int i = y2; i > y1; i--) {
                map[x1][i] = map[x1][i - 1];
                min = Math.min(min, map[x1][i]);
            }
            map[x1][y1 + 1] = temp;

            answer[j] = min;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] arr = {{2,2,5,4}, {3,3,6,6}, {5,1,6,3}};
        solution(6, 6, arr);
    }
}
