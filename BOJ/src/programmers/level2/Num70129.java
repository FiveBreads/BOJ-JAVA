package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num70129 {
    public int[] solution(String s) {
        int zeroCnt = 0;
        int convertCnt = 0;

        StringBuilder str = new StringBuilder(s);
        while (true){
            if ("1".equals(str.toString())) break;
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0'){
                    zeroCnt++;
                }else{
                    tmp.append(s.charAt(0));
                }
            }
            int num = tmp.length();
            str = new StringBuilder();
            while(num > 0){
                str.append(num % 2);
                num /= 2;
            }
            convertCnt++;
            str.reverse();
        }
        int[] answer = {convertCnt, zeroCnt};
        return answer;
    }

    @Test
    public void 이진_변환_반복하기(){
        int[] solution = solution("110010101001");
        Assertions.assertEquals(solution[0], 3);
        Assertions.assertEquals(solution[1], 8);

        solution = solution("01110");
        Assertions.assertEquals(solution[0], 3);
        Assertions.assertEquals(solution[1], 3);

        solution = solution("1111111");
        Assertions.assertEquals(solution[0], 4);
        Assertions.assertEquals(solution[1], 1);
    }
}
