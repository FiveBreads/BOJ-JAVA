package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ch11_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] nums = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            nums[i] = input.charAt(i) - '0';
        }

        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] != nums[i]) count++;
        }
        if(count > 0){
            double cal = count;
            count = (int) Math.ceil(cal/2);
        }
        System.out.println(count);
    }
}
