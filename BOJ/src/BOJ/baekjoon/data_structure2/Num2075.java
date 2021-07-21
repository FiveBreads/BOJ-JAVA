package BOJ.baekjoon.data_structure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by prayzz12@gmail.com on 2021-07-21
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : N번째 큰 수
 * content : Priority Queue
 * link : [https://www.acmicpc.net/problem/2075]
 */
public class Num2075 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.valueOf(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()){
                pq.offer(Integer.valueOf(st.nextToken()));
            }
        }
        int i = 0;
        while (i < n - 1){
            pq.poll();
            i++;
        }
        System.out.println(pq.poll());
    }
}
