package coding_test_2nd.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ch11_5 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] balls = new int[m + 1];
        for (int i = 0; i < n; i++) {
            balls[sc.nextInt()] += 1;
        }
        int result = 0;
        for (int i = 0; i < balls.length; i++) {
            for (int j = i + 1; j < balls.length; j++) {
                result += (balls[i] * balls[j]);
            }
        }
        System.out.println(result);
    }
}
