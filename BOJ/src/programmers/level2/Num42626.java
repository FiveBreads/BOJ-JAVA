package programmers.level2;

import java.util.PriorityQueue;

public class Num42626 {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }

        int answer = 0;
        while (pq.size() > 1){
            if (pq.peek() >= K) break;
            int min = pq.poll();
            int small = pq.poll() * 2;
            pq.offer(min + small);
            answer++;
        }
        if (pq.peek() >= K){
            return answer;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {

    }
}
