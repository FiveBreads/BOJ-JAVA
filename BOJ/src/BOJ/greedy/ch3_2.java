package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ch3_2 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        int idx = 0;
        while (st.hasMoreTokens()){
            nums[idx++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int result = 0;
        int check = 0;
        int big = nums[n - 1];
        int small = nums[n - 2];
        int mock = m/(k+1);
        int nam = m%(k+1);

        result = mock*big*k + nam*big + mock*small*1;
        /*for (int i = 0; i < m; i++) {
            if (check < k){
                result += big;
                check++;
            }else {
                result += small;
                check = 0;
            }
        }*/
        System.out.println(result);
    }
}
