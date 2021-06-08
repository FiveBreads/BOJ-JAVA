package BOJ.binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class ch15_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();

        int[] house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = sc.nextInt();
        }

        Arrays.sort(house);

        int start = 1;
        int end = house[n-1] - house[0];
        int res = 0;
        while (start <= end){
            int mid = (start + end) / 2;
            int wifiCnt = 1;
            int beforeValue = house[0];
            for (int i = 1; i < n; i++) {
                if (wifiCnt == c) break;
                if (house[i] >= mid + beforeValue) {
                    wifiCnt++;
                    beforeValue = house[i];
                }
            }
            if (wifiCnt < c){
                end = mid - 1;
            }else {
                start = mid + 1;
                res = mid;
            }
        }
        System.out.println(res);
    }
}
