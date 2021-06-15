package coding_test_2nd.sort;

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
        if (n == 1){
            System.out.println(pq.poll());
        }else {
            int sum = 0;
            while (pq.size() > 1) {
                int a = pq.poll();
                int b = pq.poll();
                pq.offer(a + b);
                sum += (a + b);
            }
            System.out.println(sum);
        }
    }
}
