package programmers.level1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Num17681 {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Deque<Integer> dq1 = new LinkedList<>();
            int a1 = arr1[i];
            while (a1 > 0){
                dq1.addFirst(a1 % 2);
                a1 /= 2;
            }
            while (dq1.size() < n){
                dq1.addFirst(0);
            }

            Deque<Integer> dq2 = new LinkedList<>();
            int a2 = arr2[i];
            while (a2 > 0){
                dq2.addFirst(a2 % 2);
                a2 /= 2;
            }
            while (dq2.size() < n){
                dq2.addFirst(0);
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                int a = dq1.poll();
                int b = dq2.poll();
                if (a == 1 || b == 1){
                    sb.append("#");
                }else {
                    sb.append(" ");
                }
            }
            list.add(sb.toString());
        }
        
        String[] answer = new String[n];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        int n = 5;
        solution(n, arr1, arr2);
    }
}
