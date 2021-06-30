package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class Num68645 {

    public static int[] solution(int n) {
        int[][] tri = new int[n][n];
        for (int i = 0; i < tri.length; i++) {
            for (int j = 0; j < tri.length; j++) {
                tri[i][j] = -1;
            }
        }

        int max = (n * (n + 1)) / 2;

        int i = 0, j = 0, value = 1;
        tri[0][0] = 1;

        while (value < max){
            while ((i + 1) < n && tri[i + 1][j] < 0){
                i++;
                value++;
                tri[i][j] = value;
            }

            while ((j + 1) < n && tri[i][j + 1] < 0){
                j++;
                value++;
                tri[i][j] = value;
            }

            while ((i - 1) > 0 && tri[i - 1][j - 1] < 0){
                i--;
                j--;
                value++;
                tri[i][j] = value;
            }
        }

        value = 0;

        int[] answer = new int[max];
        for (i = 0; i < n; i++) {
            for (j = 0; j <= i; j++) {
                answer[value] = tri[i][j];
                value++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(4);

    }
}
