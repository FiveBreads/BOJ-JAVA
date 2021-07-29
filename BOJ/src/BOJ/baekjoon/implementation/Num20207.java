package BOJ.baekjoon.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-07-29
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 달력
 * content :
 * link : [https://www.acmicpc.net/problem/20207]
 */
public class Num20207 {

    static class Item implements Comparable<Item>{
        private int start;
        private int end;
        private int total;

        public Item(int start, int end) {
            this.start = start;
            this.end = end;
            this.total = end - start + 1;
        }

        @Override
        public int compareTo(Item o) {
            if (this.start == o.start){
                return Integer.compare(this.total, o.total);
            }
            return Integer.compare(this.start, o.start);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<PriorityQueue<Item>> calendar = new ArrayList<>();
        for (int i = 0; i <= 365; i++) {
            calendar.add(new PriorityQueue<>());
        }

        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            calendar.get(start).offer(new Item(start, end));
        }
        int max = 0;
        int start = 0;
        int sum = 0;
        for (int i = 1; i <= 365; i++) {
            /*if (calendar[i] > 0){
                if (start == 0) start = i;
                max = Math.max(max, calendar[i]);
            }else if (calendar[i] == 0 && start > 0){
                //값 계산 로직실행
                sum += ((i - start) * max);
                //초기화
                max = 0;
                start = 0;
            }*/
        }
        System.out.println(sum);
    }
}
