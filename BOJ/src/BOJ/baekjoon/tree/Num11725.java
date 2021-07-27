package BOJ.baekjoon.tree;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-07-24
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 트리의 부모 찾기
 * content :
 * link : [https://www.acmicpc.net/problem/11725]
 */
public class Num11725 {

    static int N ;
    static ArrayList<Integer>[] tree;
    static int[] parents;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        tree = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        parents = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            int one = sc.nextInt();
            int two = sc.nextInt();
            tree[one].add(two);
            tree[two].add(one);
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (!visit[i]){
                dfs(i);
            }
        }

        for (int i = 2; i < parents.length; i++) {
            answer.append(parents[i]).append("\n");
        }
        System.out.println(answer.toString());
    }
    static void dfs(int now){
        if(visit[now]){
            return;
        }
        visit[now] = true;
        for (int next : tree[now]) {
            if(!visit[next]){
                parents[next] = now;
                dfs(next);
            }
        }
    }
}
