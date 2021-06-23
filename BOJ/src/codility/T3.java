package codility;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class T3 {
    public static int solution(int N) {
        N += 1;
        if (N <= 10){
            return N;
        }
        String strN = String.valueOf(N);

        Deque<Integer> dq = new LinkedList<>();
        dq.offer(strN.charAt(0) - '0');

        int index = 0;
        for (int i = 1; i < strN.length(); i++) {
            if (strN.charAt(i) == strN.charAt(i - 1)){
                int plus = strN.charAt(i) - '0';
                plus += 1;
                index = i;
                boolean isShift = false;
                while (plus == 10){
                    if (dq.isEmpty()) {
                        dq.offer(1);
                        index = -1;
                        isShift = true;
                        break;
                    }
                    int left = dq.removeLast();
                    plus = left + 1;

                    if (!dq.isEmpty() && dq.getLast() == plus){
                        plus++;
                    }
                    index--;
                }
                if (!isShift) dq.offer(plus);
                int tmp = 0;
                for (int j = index + 1; j < strN.length(); j++) {
                    dq.offer(tmp);
                    if (tmp == 0) tmp++;
                    else tmp--;
                }
                break;
            }else{
                dq.offer(strN.charAt(i) - '0');
            }
        }
        StringBuilder result = new StringBuilder();
        while (!dq.isEmpty()){
            result.append(dq.poll());
        }
        return Integer.parseInt(result.toString());
    }

    public static void main(String[] args) {
        int[] arr = {
            55,
            1765,
            98,
            44432,
            3298
        };
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("data = %d, result = %d\n", arr[i], solution(arr[i]));
        }
    }
}
