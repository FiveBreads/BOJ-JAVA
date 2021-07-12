package programmers.level2;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num12941 {
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        int j = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[j];
            j--;
        }
        return answer;
    }

    @Test
    void 최솟값_만들기(){
        Assertions.assertEquals(29, solution(new int[] {1, 4, 2}, new int[]{5, 4, 4}));
        Assertions.assertEquals(10, solution(new int[] {1, 2}, new int[]{3, 4}));
    }
}
