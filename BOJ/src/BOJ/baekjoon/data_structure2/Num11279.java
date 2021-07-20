package BOJ.baekjoon.data_structure2;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-07-20
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 최대 힙
 * content : 최대 힙
 * link : [https://www.acmicpc.net/problem/11279]
 */


public class Num11279 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int input;
        StringBuilder builder = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            input = sc.nextInt();
            if (input == 0){
                if (pq.isEmpty()){
                    builder.append(0).append("\n");
                }else{
                    builder.append(pq.poll()).append("\n");
                }
            }else{
                pq.offer(input);
            }
        }
        System.out.println(builder.toString());
    }
}
