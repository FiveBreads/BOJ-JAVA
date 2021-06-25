package programmers.level1;

import java.util.Deque;
import java.util.LinkedList;

public class Num68935 {
    public int solution(int n) {
        int answer = 0;
        Deque<Integer> dq = new LinkedList<>();
        while (n > 0){
            int data = n % 3;
            n /= 3;
            dq.offer(data);
        }

        int cnt = 0;
        while (!dq.isEmpty()){
             answer += Math.pow(3, cnt) * dq.removeLast();
             cnt++;
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
