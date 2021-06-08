package BOJ.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ch7_1 {

    static int[] part;

    public static int binarySearch(int target, int start, int end){
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (part[mid] == target) return mid;
        else if (part[mid] > target) return binarySearch(target, start, mid - 1);
        else return binarySearch(target, mid + 1, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        part = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            part[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] target = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(part);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int res = binarySearch(target[i], 0, n - 1);
            if (res > 0)
                sb.append("YES");
            else
                sb.append("NO");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
