package BOJ.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ch14_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(sc.nextInt());
        }
        int res = 0;

        if (pq.size() == 1){
            res = pq.peek();
        }
        while (pq.size() > 1){
            int one = pq.poll();
            int two = pq.poll();
            int sum = one + two;
            res += sum;
            pq.offer(sum);
        }
        System.out.println(res);
    }
}
