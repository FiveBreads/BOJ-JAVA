package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch11_5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] weightCnt = new int[m+1];
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            int idx = Integer.parseInt(st.nextToken());
            weightCnt[idx]++;
        }
        int result = 0;
        for (int i = 1; i < weightCnt.length; i++) {
            if (weightCnt[i] > 0){
                n -= weightCnt[i];
                result += (n * weightCnt[i]);
            }

        }
        System.out.println(result);
    }
}
