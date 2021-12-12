package BOJ.baekjoon.myarray;

import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-12-12
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 배열 합치기
 * content :
 * link : [https://www.acmicpc.net/problem/11728]
 */
public class Num11728 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arrA = new int[n];
        int[] arrB = new int[m];

        for (int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            arrB[i] = sc.nextInt();
        }

        int left = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder();
        while (left < n && right < m){
            if (arrA[left] <= arrB[right]){
                sb.append(arrA[left++]).append(" ");
            }else {
                sb.append(arrB[right++]).append(" ");
            }
        }
        while (left < n){
            sb.append(arrA[left++]).append(" ");
        }

        while (right < m) {
            sb.append(arrB[right++]).append(" ");
        }
        System.out.println(sb);
    }
}
