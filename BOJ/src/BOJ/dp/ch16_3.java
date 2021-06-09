package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch16_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] t = new int [n + 1]; //상담 소요 시간
        int[] p = new int [n + 1]; //해당 상담자 상담 비용
        int[] d = new int [n + 1]; //dp table
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            int value = d[i-1];
            for (int j = 1; j <= i; j++) {
                t[j]--;
                if (t[j] == 0) {
                    value = Math.max(value, d[j-1] + p[j]);
                }
            }
            d[i] = value;
        }
        System.out.println(d[n]);
    }
}
