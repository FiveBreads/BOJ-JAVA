package programmers.level3;

import java.util.Arrays;

public class Num43238 {
//입국심사
    public static long solution(int n, int[] times){
        Arrays.sort(times);
        if (n == 1){
            return times[0];
        }
        long max_value = times[times.length - 1];
        long start = 0;
        long end = ((long) n) * max_value;
        long answer = 1000000001;
        while (start <= end){
            long mid = (start + end) / 2;
            long partSum = 0;
            for (int i = 0; i < times.length; i++) {
                partSum += mid / times[i];
            }
            if (n == partSum){
                answer = Long.min(answer, mid);
                end = mid - 1;
            }else if (n < partSum){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] times = {
            {7,10}
            };
        for (int i = 0; i < times.length; i++) {
            System.out.println(solution(n, times[i]));
        }
    }
}
