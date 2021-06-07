package BOJ.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        Arrays.stream(arr).forEach(value -> System.out.print(value));
        System.out.println();
        for (int i = 1; i < arr.length; i++) {
            int standard = arr[i];  // 기준
            int aux = i - 1;   // 비교할 대상
            while (aux >= 0 && standard < arr[aux]) {
                arr[aux + 1] = arr[aux];   // 비교대상이 큰 경우 오른쪽으로 밀어냄
                aux--;
            }
            arr[aux + 1] = standard;  // 기준값 저장
            Arrays.stream(arr).forEach(value -> System.out.print(value));
            System.out.println();
        }
    }
}
