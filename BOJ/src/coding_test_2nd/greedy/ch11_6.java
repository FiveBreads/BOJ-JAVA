package coding_test_2nd.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Food implements Comparable<Food> {
    private int index;
    private int amount;

    public Food(int index, int amount) {
        this.index = index;
        this.amount = amount;
    }

    public void changeAmount(){
        this.amount--;
    }

    public int getIndex() {
        return index;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public int compareTo(Food o) {
        if (this.amount < o.amount){
            return 1;
        }
        return -1;
    }
}
public class ch11_6 {

    public static int solution(int[] food_times, int k){
        Queue<Food> pq = new LinkedList<>();
        for (int i = 0; i < food_times.length; i++) {
            pq.add(new Food(i, food_times[i]));

        }
        int answer = 0;
        while (!pq.isEmpty()){
            int eat = k / pq.size();
            if (eat > 0){
                for (int i = 0; i < pq.size(); i++) {
                    Food fd = pq.poll();
                    fd.changeAmount();
                    if (fd.getAmount() > 0){
                        pq.offer(fd);
                    }
                }
                k -= eat;
            }else {
                for (int i = 0; i < k; i++) {
                    pq.poll();
                }
                k = 0;
                answer = pq.poll().getIndex();
                break;
            }
        }
        if (k > 0){
            return -1;
        }else {
            return answer;
        }
    }

    public static void main(String[] args) {
        int[] food_times = {3, 1, 2};
        int k = 5;
        System.out.println(solution(food_times, k));
    }
}
