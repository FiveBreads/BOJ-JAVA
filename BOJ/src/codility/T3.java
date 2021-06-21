package codility;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class T3 {
    public static int solution(int N) {
        N += 1;
        if (N <= 10) return N;
        String strN = String.valueOf(N);
        int len = strN.length();
        int index = 0;
        Deque<Integer> dq = new LinkedList<>();
        dq.offer(strN.charAt(0) - '0');
        for (int i = 1; i < len; i++) {
           if (strN.charAt(i) == strN.charAt(i -1)){
               index = i;
               int tmp = strN.charAt(i) - '0';
               tmp += 1;
               while (tmp == 10){
                   if (index < 0){
                       dq.offer(1);
                       index = 0;
                       len += 1;
                       break;
                   }
                   tmp = dq.removeLast();
                   tmp += 1;
                   index -= 1;
               }
               tmp = 0;
               for (int j = index + 1; j < len; j++) {
                   dq.offer(tmp);
                   if (tmp == 0) tmp++;
                   else tmp--;
               }
               break;
           }else {
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
