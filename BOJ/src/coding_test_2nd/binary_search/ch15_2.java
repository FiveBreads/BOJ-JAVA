package coding_test_2nd.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch15_2 {
    public static int[] arr;

    public static int binarySearch(int start, int end){
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (arr[mid] == mid) {
            return mid;
        }
        else if (arr[mid] > mid){
            return binarySearch(start, mid - 1);
        }else{
            return binarySearch(mid + 1, end);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = binarySearch(0, n - 1);
        System.out.println(result);
    }
}
