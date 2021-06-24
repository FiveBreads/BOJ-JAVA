package programmers.level1;

import java.math.BigInteger;

public class Num12977 {

    public static int solution(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int part = nums[i] + nums[j] + nums[k];
                    boolean isNot = true;
                    for (int l = 2; l < part; l++) {
                        if (part % l == 0) {
                            isNot = false;
                            break;
                        }
                    }
                    if (isNot) answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        solution(nums);
    }
}
