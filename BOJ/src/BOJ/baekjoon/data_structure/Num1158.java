package BOJ.baekjoon.data_structure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

/**
 * Created by prayzz12@gmail.com on 2021-07-16
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 요세푸스 문제
 * content : Queue
 * link : [https://www.acmicpc.net/problem/1158]
 */
public class Num1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            que.offer(i);
        }

        StringBuilder builder = new StringBuilder();
        builder.append("<");

        int index = 0;
        K--;
        while (que.size() > 1){
            for (int i = 1; i <= K; i++) {
                que.offer(que.poll());
            }
            builder.append(que.poll())
                .append(", ");
        }
        builder.append(que.poll()).append(">");
        System.out.println(builder.toString());
    }
}
