package BOJ.baekjoon.workbook.part2;

import java.io.*;
import java.util.*;

/**
 * Created by prayzz12@gmail.com on 2021-08-09
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 최소 비용 구하기
 * content :
 * link : [https://www.acmicpc.net/problem/1916]
 */
public class Num1916 {

    static class Bus{
        private int from;
        private int to;
        private int cost;

        public Bus(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE - 1);

        ArrayList<Bus>[] busRoute = new ArrayList[m + 1];
        for (int i = 0; i <= m; i++) {
            busRoute[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int from, to, cost;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            busRoute[from].add(new Bus(from, to, cost));
        }

        st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        Queue<Bus> que = new LinkedList<>();
        for (int i = 0; i < busRoute[from].size(); i++) {
            que.offer(busRoute[from].get(i));
        }
        distance[from] = 0;

        while (!que.isEmpty()){
            Bus poll = que.poll();
            if (distance[poll.to] > distance[poll.from] + poll.cost){
                distance[poll.to] = distance[poll.from] + poll.cost;
                for (int i = 0; i < busRoute[poll.to].size(); i++) {
                    que.offer(busRoute[poll.to].get(i));
                }
            }
        }
        System.out.println(distance[to]);
    }
}

/* bfs 메모리 초과
public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<int[]>[] cities = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            cities[i] = new ArrayList<>();
        }
        StringTokenizer st;
        int from, to, cost;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            cities[from].add(new int[]{to, cost});
        }

        st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < cities[from].size(); i++) {
            que.offer(cities[from].get(i));
        }

        long min = Long.MAX_VALUE;
        while (!que.isEmpty()){
            int[] poll = que.poll();
            if (poll[0] == to){
                min = Math.min(min, poll[1]);
            }else{
                for (int i = 0; i < cities[poll[0]].size(); i++) {
                    int[] bus = cities[poll[0]].get(i);
                    bus[1] += poll[1];
                    que.offer(bus);
                }
            }
        }
        System.out.println(min);
    }

 */
