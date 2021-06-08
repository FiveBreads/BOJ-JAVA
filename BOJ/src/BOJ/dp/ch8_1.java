package BOJ.dp;

import java.util.Scanner;

public class ch8_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] dpTable = new int[30001];
        for (int i = 2; i <= x; i++) {
            dpTable[i] = dpTable[i-1] + 1;
            if (i % 2 == 0){
                dpTable[i] = Math.min(dpTable[i], dpTable[i/2] + 1);
            }
            if (i % 3 == 0){
                dpTable[i] = Math.min(dpTable[i], dpTable[i/3] + 1);
            }
            if (i % 5 == 0){
                dpTable[i] = Math.min(dpTable[i], dpTable[i/5] + 1);
            }
        }
    }
}
