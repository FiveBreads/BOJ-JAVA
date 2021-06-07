package BOJ.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 7, 9, 2, 4, 6, 8};
        quickSort(arr, 0, arr.length - 1);

    }

    static void quickSort(int[] arr, int left, int right) {
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int low = left + 1;
        int high = right;
        while (low <= high){
            while (pivot >= arr[low] && low <= right) low++;
            while (pivot <= arr[high] && high >= (left + 1)) high--;
            if (low <= high){
                swap(arr, low, high);
            }
        }
        swap(arr, left, high);
        return high;
    }

    private static void swap(int[] arr, int low, int high) {
        int tmp;
        tmp = arr[low];
        arr[low] = arr[high];
        arr[high] = tmp;
    }
}
