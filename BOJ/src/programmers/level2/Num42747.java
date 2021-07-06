package programmers.level2;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num42747 {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }

    @Test
    void H_index(){
        Assertions.assertEquals(3, solution(new int[]{3, 0, 6, 1, 5}));
        Assertions.assertEquals(4, solution(new int[]{4, 4, 4, 5, 0, 1, 2, 3}));
        Assertions.assertEquals(3, solution(new int[]{3, 0, 6, 1, 5}));
        Assertions.assertEquals(1, solution(new int[]{0, 0, 1, 1}));
        Assertions.assertEquals(1, solution(new int[]{0, 1}));
        Assertions.assertEquals(2, solution(new int[]{2, 7, 5}));
        Assertions.assertEquals(4, solution(new int[]{10, 11, 12, 13}));
    }
}
