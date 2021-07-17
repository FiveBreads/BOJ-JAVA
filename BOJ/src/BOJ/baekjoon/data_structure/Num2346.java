package BOJ.baekjoon.data_structure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by prayzz12@gmail.com on 2021-07-17
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 풍선 터뜨리기
 * content :
 * link : [https://www.acmicpc.net/problem/2346]
 */

class Balloon{
    private int order;
    private int value;

    public Balloon(int order, int value) {
        this.order = order;
        this.value = value;
    }

    public int getOrder() {
        return order;
    }

    public int getValue() {
        return value;
    }

    public int getPositiveValue(){
        return Math.abs(this.value);
    }
}
public class Num2346 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        Deque<Balloon> dq = new LinkedList<>();
        int order = 1;
        while (st.hasMoreTokens()){
            dq.offer(new Balloon(order++, Integer.valueOf(st.nextToken())));
        }
        StringBuilder builder = new StringBuilder();
        while (dq.size() > 1){
            Balloon poll = dq.poll();
            if (poll.getValue() < 0){
                for (int i = 1; i <= poll.getPositiveValue(); i++) {
                    dq.addFirst(dq.removeLast());
                }
            }else {
                for (int i = 1; i < poll.getValue(); i++) {
                    dq.addLast(dq.poll());
                }
            }
            builder.append(poll.getOrder()).append(" ");
        }
        builder.append(dq.poll().getOrder());
        System.out.println(builder.toString());
    }
}
