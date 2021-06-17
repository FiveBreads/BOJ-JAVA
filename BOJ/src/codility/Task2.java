package codility;

import java.util.HashMap;
import java.util.Set;

public class Task2 {

    public static int[] solution(int[] A, int K) {
        int len = A.length;
        int[] result = new int[len];

        if (K > 0){
            for (int i = 0; i < len; i++) {
                result[(i + K) % len] = A[i];
            }
        }else if (K < 0){
            for (int i = 0; i < len; i++) {
                result[len - ((K * -1) % len)] = A[i];
            }
        }else {
            return A;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = -8;
        int[] solution = solution(arr, k);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        Object[] objects = map.keySet().toArray();
        return (int) objects[0];
    }
}
