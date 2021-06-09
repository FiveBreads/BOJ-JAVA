package BOJ.dp;

import java.util.Scanner;

public class ch8_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];
        d[1] = 1;
        d[2] = 3;
        for (int i = 3; i <= n; i++) {
            d[i] = (d[i-2] * 2 + d[i-1]) % 796796;
        }
        System.out.println(d[n]);
    }
}
