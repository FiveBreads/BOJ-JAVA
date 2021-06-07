package BOJ.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class ch6_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Integer[] nArr = new Integer[n];
        Integer[] kArr = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            kArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nArr);
        Arrays.sort(kArr, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            nArr[i] = kArr[i];
        }

        int res = 0;
        for (int i = 0; i < nArr.length; i++) {
            res += nArr[i];
        }
        System.out.println(res);
    }
}
