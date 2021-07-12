package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num12939 {
    public String solution(String s) {
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;

        String[] nums = s.split(" ");
        for (int i = 0; i < nums.length; i++) {
            long num = Long.parseLong(nums[i]);
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        return min + " " + max;
    }

    @Test
    void 최대값과_최소값(){
        Assertions.assertEquals("1 4", solution("1 2 3 4"));
        Assertions.assertEquals("-4 -1", solution("-1 -2 -3 -4"));
        Assertions.assertEquals("-1 -1", solution("-1 -1"));
    }
}
