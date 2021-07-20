package BOJ.baekjoon.data_structure2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-07-20
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 절댓값 힙
 * content : 힙
 * link : [https://www.acmicpc.net/problem/11286]
 */


public class Num11286 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = Math.abs(o1);
                int b = Math.abs(o2);
                if (a == b){
                    return o1.compareTo(o2);
                }else {
                    return Integer.compare(a, b);
                }
            }
        });

        int N = sc.nextInt();
        int input;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            input = sc.nextInt();
            if (input == 0){
                if (pq.isEmpty()){
                    builder.append(0).append("\n");
                }else{
                    builder.append(pq.poll()).append("\n");
                }
            }else {
                pq.offer(input);
            }
        }
        System.out.println(builder.toString());
    }
}
