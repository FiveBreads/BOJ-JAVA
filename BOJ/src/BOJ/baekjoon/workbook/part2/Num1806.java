package BOJ.baekjoon.workbook.part2;

import java.io.*;
import java.util.*;
/**
 * Created by prayzz12@gmail.com on 2021-08-07
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 부분합
 * content :
 * link : [https://www.acmicpc.net/problem/1806]
 */
public class Num1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;

        int min = 100001;
        int sum = 0;
        while (end < n){
            sum += arr[end++];
            while (sum >= s){
                sum -= arr[start++]; //end의 경우 더하고 한칸이 이미 올라간 상태기 때문에 start도 한칸 올리고 시작하는 것이 맞다.
                min = Math.min(min, end - start + 1);
            }
        }
        System.out.println(min == 100001 ? 0 : min);
    }
}

// 1회차 풀이
/*
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());
    int[] nums = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
        nums[i] = Integer.parseInt(st.nextToken());
    }

    int start = 0;
    int end = 0;

    int sum = 0;
    int min = 10001;

    while(end < n){
        if (sum < s){
            sum += nums[end++];
        }else {
            sum -= nums[start++];
            min = Math.min(min, (end - start) + 1);
        }
    }
    System.out.println(min > 10000 ? 0 : min);
}
* */
