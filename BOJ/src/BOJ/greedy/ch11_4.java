package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ch11_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            nums[idx++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        if (nums[0] > 1) {
            System.out.println(1);
            return;
        }
        int target = 1;
        for (int num : nums) {
            if (target < num) break;
            target += num;
        }
        System.out.println(target);
    }
}
