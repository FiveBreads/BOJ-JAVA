package BOJ.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ch8_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] warehouse = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = 0;
            warehouse[i] = sc.nextInt();
        }

        d[0] = warehouse[0];
        d[1] = Math.max(warehouse[1], warehouse[0]);

        for (int i = 2; i < n; i++) {
            d[i] = Math.max(d[i - 1], (warehouse[i] + d[i - 2]));
        }
        System.out.println(d[n-1]);
    }
}
