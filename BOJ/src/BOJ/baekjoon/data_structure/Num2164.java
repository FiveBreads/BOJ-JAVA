package BOJ.baekjoon.data_structure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-07-16
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 카드2
 * content : Deque
 * link : [https://www.acmicpc.net/problem/2164]
 */
public class Num2164 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Deque<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            que.addLast(i);
        }

        while (que.size() > 1){
            que.poll();
            que.addLast(que.poll());
        }
        System.out.println(que.poll());
    }
}
