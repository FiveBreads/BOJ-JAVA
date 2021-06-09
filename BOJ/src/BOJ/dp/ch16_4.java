package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch16_4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] soldier = new int[n];
        int[] d = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            soldier[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            d[i] = d[i-1];
            if (soldier[i] > soldier[i - 1]){
                d[i] += 1;
            }
        }
        System.out.println(d[n-1]);
    }
}
