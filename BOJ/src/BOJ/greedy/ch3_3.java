package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ch3_3 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //행
        int m = Integer.parseInt(st.nextToken()); //열
        String str = "";
        int max = 0;
        while ((str = br.readLine()) != null){
            String[] nums = str.split(" ");
            Arrays.sort(nums);
            int tmp = Integer.parseInt(nums[0]);
            max = Math.max(max,tmp);
        }
        System.out.println(max);
    }
}
