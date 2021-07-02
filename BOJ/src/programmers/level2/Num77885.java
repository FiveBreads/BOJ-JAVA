package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num77885 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) answer[i] = numbers[i] + 1;
            else{
                StringBuilder sb = new StringBuilder();
                while (numbers[i] > 0){
                    sb.append(numbers[i] % 2);
                    numbers[i] /= 2;
                }
                sb.append(0);
                for (int j = 0; j < sb.length() - 1; j++) {
                    if (sb.charAt(j) == '1' && sb.charAt(j + 1) == '0'){
                        sb.deleteCharAt(j);
                        sb.insert(j, 0);
                        sb.deleteCharAt(j + 1);
                        sb.insert(j + 1, 1);
                        break;
                    }
                }
                long sum = 0;
                for (int j = 0; j < sb.length(); j++) {
                    if (sb.charAt(j) == '1'){
                        sum += Math.pow(2, j);
                    }
                }
                answer[i] = sum;
            }
        }
        return answer;
    }
    @Test
    public void 두개_이하로_다른_비트(){
        long[] solution = solution(new long[]{2, 7});
        Assertions.assertEquals(3, solution[0]);
        Assertions.assertEquals(11, solution[1]);
    }
}
