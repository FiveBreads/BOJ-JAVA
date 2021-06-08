package BOJ.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch15_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = n-1;
        int result = -1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (arr[mid] == mid) {
                result = mid;
                break;
            }else if (arr[mid] < mid){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}
