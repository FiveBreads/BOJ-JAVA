package coding_test_2nd.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch15_1 {

    public static int [] arr;
    public static int n, x;

    public static int binaryStartSearch(int start, int end){
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (arr[mid] == x){
            if (mid == 0 || arr[mid - 1] < x){
                return mid;
            }else {
                return binaryStartSearch(start, mid - 1);
            }

        }else if (arr[mid] > x){
            return binaryStartSearch(start, mid - 1);
        }else{
            return binaryStartSearch(mid + 1, end);
        }
    }

    public static int binaryEndSearch(int start, int end){
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (arr[mid] == x){
            if (mid == (n - 1) || arr[mid + 1] > x){
                return mid;
            }else {
                return binaryEndSearch(mid + 1, end);
            }

        }else if (arr[mid] > x){
            return binaryEndSearch(start, mid - 1);
        }else{
            return binaryEndSearch(mid + 1, end);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = binaryStartSearch(0, n - 1);
        int end = binaryEndSearch(0, n - 1);
        if (start == -1){
            System.out.println(start);
        }else{
            System.out.println(end - start + 1);
        }
    }
}
