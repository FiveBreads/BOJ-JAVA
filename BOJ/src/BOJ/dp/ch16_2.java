package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch16_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int [][] tri = new int[n][n];
        int [][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (st.hasMoreTokens()){
                    tri[i][j] = Integer.parseInt(st.nextToken());
                }else{
                    tri[i][j] = -1;
                }
            }
        }
        d[0][0] = tri[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int leftUp = 0, rightUp = 0;
                if (j == 0) {
                    rightUp = d[i-1][j];
                }else if (tri[i - 1][j] == -1){
                    leftUp = d[i-1][j-1];
                }else{
                    rightUp = d[i-1][j];
                    leftUp = d[i-1][j-1];
                }
                d[i][j] = tri[i][j] + Math.max(leftUp, rightUp);
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result,d[n-1][i]);
        }
        System.out.println(result);
    }
}
