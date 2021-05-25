package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch11_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] nums = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            nums[i] = input.charAt(i) - '0';
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (result <= 1 || nums[i] <= 1) result += nums[i];
            else result *= nums[i];
        }
        System.out.println(result);
    }
}
