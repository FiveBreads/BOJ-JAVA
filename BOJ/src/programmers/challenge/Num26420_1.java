package programmers.challenge;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num26420_1 {

    /**
     * 네이버 웹툰 1번 최대 할인율
     * @param prices
     * @param discounts
     * @return
     */
    public int solution(int[] prices, int[] discounts) {
        PriorityQueue<Integer> price_que = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> discount_que = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < prices.length; i++) {
            price_que.offer(prices[i]);
        }
        for (int i = 0; i < discounts.length; i++) {
            discount_que.offer(discounts[i]);
        }

        int answer = 0;
        while (!price_que.isEmpty() && !discount_que.isEmpty()){
            int price = price_que.poll();
            int discount = discount_que.poll();
            answer += (price / 100) * (100 - discount);
        }
        while (!price_que.isEmpty()){
            answer += price_que.poll();
        }
        return answer;
    }

    @Test
    void 쿠폰(){
        Assertions.assertEquals(82000, solution(new int[]{13000, 88000, 10000}, new int[]{30, 20}));
        Assertions.assertEquals(45275, solution(new int[]{32000, 18000, 42500}, new int[]{50, 20, 65}));
        Assertions.assertEquals(9000, solution(new int[]{18000}, new int[]{50, 20}));
    }
}
