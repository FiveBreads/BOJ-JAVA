package BOJ.binary_search;

public class BSearchSample {

    public static int binarySearchRecursive(int[] arr, int target, int start, int end){
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] > target) return binarySearchRecursive(arr, target, start, mid - 1);
        else return binarySearchRecursive(arr, target, mid + 1, end);
    }

    public static int binarySearchIterate(int[] arr, int target, int start, int end){
        int mid;
        while (start <= end){
            mid = (start + end) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
