package coding_test_2nd.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class ch11_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data);
        int groupCnt = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            groupCnt++;
            if (data[i] <= groupCnt){
                result++;
                groupCnt = 0;
            }
        }
        System.out.println(result);
    }
}
