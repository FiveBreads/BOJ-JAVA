package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num42842 {

    public int[] solution(int brown, int yellow) {

        int height = 0;
        int width = 0;
        for (height = 3; height <= (brown + 4) / 2; height++) {
            width = (brown + 4) / 2 - height;
            if (width < height) break;

            int yellowCnt = (height - 2) * (width - 2);
            if (yellowCnt == yellow) break;

        }

        int[] answer = {width, height};
        return answer;
    }

    @Test
    void 카펫(){
        Assertions.assertArrayEquals(new int[]{4,3}, solution(10, 2));
        Assertions.assertArrayEquals(new int[]{3,3}, solution(8, 1));
        Assertions.assertArrayEquals(new int[]{8,6}, solution(24, 24));
    }
}
