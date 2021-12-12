package BOJ.baekjoon.myarray;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-12-12
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 올바른 배열
 * content :
 * link : [https://www.acmicpc.net/problem/1337]
 */
public class Num1337 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int min = 5;
        for (int i = 0; i < n; i++) {
            int count = 0;
            int target = arr[i];
            int target_index = i;
            for (int j = 0; j < 5; j++) {
                if (target_index >= n) {
                    count++;
                    continue;
                }
                if (arr[target_index] == target){
                    target_index++;
                }else{
                    count++;
                }
                target++;
            }
            min = Math.min(min, count);
        }
        System.out.println(min);
    }
}
