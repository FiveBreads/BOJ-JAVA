package programmers.level2;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num42885 {

    public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int min = 0;

        for (int max = people.length - 1; min <= max; max--){
            if (people[min] + people[max] <= limit) min++;
            answer++;
        }
        return answer;
    }

    @Test
    void 구명보트_테스트(){
        Assertions.assertEquals(1, solution(new int[]{50}, 50));
        Assertions.assertEquals(2, solution(new int[]{20, 50, 50, 80}, 100));
        Assertions.assertEquals(3, solution(new int[]{70, 50, 80, 50}, 100));
        Assertions.assertEquals(3, solution(new int[]{50, 30, 20, 70, 10}, 100));
        Assertions.assertEquals(3, solution(new int[]{70, 80, 50}, 100));
        Assertions.assertEquals(5, solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
    }
}
