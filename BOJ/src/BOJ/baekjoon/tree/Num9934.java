package BOJ.baekjoon.tree;

import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-07-24
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 완전 이진 트리
 * content : 
 * link : [https://www.acmicpc.net/problem/9934]
 */
public class Num9934 {

    static StringBuilder[] height;
    static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        int nodeCnt = (int) Math.pow(2, K) - 1;
        int[] nums = new int[nodeCnt];

        height = new StringBuilder[K + 1];
        for (int i = 1; i <= K; i++) {
            height[i] = new StringBuilder();
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        dfs(nums, 0, nums.length - 1, 1);
        for (int i = 1; i <= K; i++) {
            System.out.println(height[i].toString());
        }
    }

    public static void dfs(int[] nums, int start, int end, int depth){
        if (depth > K) return;
        int mid = (start + end) / 2;
        height[depth].append(nums[mid]).append(" ");
        dfs(nums, start, mid - 1, depth + 1);
        dfs(nums, mid + 1, end, depth + 1);
    }
}
