package BOJ.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class ch7_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Integer[] tteok = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tteok[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tteok, Collections.reverseOrder());

        int start = 0, end = tteok[0], result = 0, sum;
        while (start <= end){
            sum = 0;
            if (start > end) break;
            int mid = (start + end) / 2;
            for (int i = 0; i < n; i++) {
                if (tteok[i] > mid) {
                    sum += tteok[i] - mid;
                }
            }
            if (m <= sum) {
                result = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}
