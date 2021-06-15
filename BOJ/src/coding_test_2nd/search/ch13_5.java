package coding_test_2nd.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch13_5 {

    public static int plus, subtract, multiply, division, n;
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;
    public static int[] nums;


    public static void dfs(int num, int index){
        if (index == n){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }else{
            if (plus > 0){
                plus--;
                dfs(num + nums[index], index + 1);
                plus++;
            }
            if (subtract > 0){
                subtract--;
                dfs(num - nums[index], index + 1);
                subtract++;
            }
            if (multiply > 0){
                multiply--;
                dfs(num * nums[index], index + 1);
                multiply++;
            }
            if (division > 0){
                division--;
                dfs(num / nums[index], index + 1);
                division++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        plus = Integer.parseInt(st.nextToken());
        subtract = Integer.parseInt(st.nextToken());
        multiply = Integer.parseInt(st.nextToken());
        division = Integer.parseInt(st.nextToken());

        dfs(nums[0], 1);
        System.out.println(max);
        System.out.println(min);
    }
}
