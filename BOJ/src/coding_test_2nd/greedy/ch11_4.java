package coding_test_2nd.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ch11_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] coins = new Integer[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins, Collections.reverseOrder());

        int num = 1;
        while (true){
            int sum = num;
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] <= sum){
                    sum -= coins[i];
                }
            }
            if (sum > 0){
                break;
            }else{
                num++;
            }
        }
        System.out.println(num);
    }
}
