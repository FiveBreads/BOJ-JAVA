package BOJ.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        Arrays.stream(arr).forEach( (value) -> System.out.print(value));
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int idx = i;
            for (int j = i+1; j < arr.length; j++) {
                if (min > arr[j]){
                    min = arr[j];
                    idx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = min;
            arr[idx] = tmp;
        }
        System.out.println();
        Arrays.stream(arr).forEach((value)-> System.out.print(value));
    }
}
