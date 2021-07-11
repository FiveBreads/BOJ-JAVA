package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num12924 {

    public int solution(int n) {
        int sum;
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum > n) break;
                if (sum == n) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }

    @Test
    void 숫자의_표현(){
        Assertions.assertEquals(4, solution(15));
    }
}
