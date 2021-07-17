package BOJ.baekjoon.data_structure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-07-17
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 프린터 큐
 * content : 큐
 * link : [https://www.acmicpc.net/problem/1966]
 */

class Node {
    private int order;
    private int value;

    public Node(int order, int value) {
        this.order = order;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int getOrder() {
        return order;
    }
}
public class Num1966 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder builder = new StringBuilder();

        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            int[] cnt = new int[10];
            Queue<Node> que = new LinkedList<>();
            int N = sc.nextInt();
            int M = sc.nextInt();

            int res = 0;

            for (int j = 0; j < N; j++) {
                Node node = new Node(j, sc.nextInt());
                cnt[node.getValue()]++;
                que.offer(node);
            }
            boolean isFirst;
            while (!que.isEmpty()){
                isFirst = true;
                Node poll = que.poll();
                for (int j = poll.getValue() + 1; j < 10; j++) {
                    if (cnt[j] > 0){
                        isFirst = false;
                        break;
                    }
                }
                if (isFirst){
                    res += 1;
                    cnt[poll.getValue()]--;
                    if (poll.getOrder() == M){
                        builder.append(res).append("\n");
                        break;
                    }
                }else{
                    que.offer(poll);
                }
            }
        }
        System.out.println(builder.toString());
    }
}
