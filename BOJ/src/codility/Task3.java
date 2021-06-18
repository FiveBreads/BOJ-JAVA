package codility;

import java.util.*;

public class Task3 {

    public int[] solution(int N, int[] A) {
        int max_counter = N + 1;
        int[] result = new int[N];
        for (int i = 0; i < N; i++){
            result[i] = 0;
        }
        int max = 0;
        boolean isChange = false;
        for (int i = 0; i < A.length; i++){
            if (A[i] == max_counter && isChange){
                Arrays.fill(result, max);
                isChange = false;
            }else{
                result[A[i] - 1]++;
                max = Math.max(result[A[i] - 1], max);
                isChange = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[0];
        System.out.println(arr.length);
        ArrayList<Integer> list = new ArrayList<>();

    }
}
