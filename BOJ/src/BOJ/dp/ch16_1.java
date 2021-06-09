package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ch16_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] mine = new int[n][m];
            int[][] d = new int[n][m];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    mine[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            for (int j = 0; j < n; j++) {
                d[j][0] = mine[j][0];
            }
            for (int j = 1; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    int leftUp, left, leftDown;
                    if (k == 0) {
                        leftUp = 0;
                        leftDown = d[k+1][j-1];
                    }
                    else if (k == n-1) {
                        leftUp = d[k-1][j-1];
                        leftDown = 0;
                    }
                    else {
                        leftUp = d[k-1][j-1];
                        leftDown = d[k+1][j-1];
                    }
                    left = d[k][j-1];
                    d[k][j] = mine[k][j] + Math.max(left, Math.max(leftDown, leftUp));
                }
            }
            int result = 0;
            for (int j = 0; j < n; j++) {
                result = Math.max(result, d[j][m-1]);
            }
            System.out.println(result);
        }
    }
}
