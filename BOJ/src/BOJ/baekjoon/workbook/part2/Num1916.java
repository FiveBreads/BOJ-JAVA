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

    static final int INF = (int) 1e9;
    static int[] d;
    static ArrayList<ArrayList<Node>> graph;

    static int n, m;

    static class Node implements Comparable<Node>{
        private int index;
        private int dist;

        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()){
            Node poll = pq.poll();
            int dist = poll.dist;
            int now = poll.index;

            if (d[now] < dist) continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).dist;
                if (cost < d[graph.get(now).get(i).index]){
                    d[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        d = new int[n + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            d[i] = INF;
        }

        StringTokenizer st;
        int now, next, cost;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            now = Integer.parseInt(st.nextToken());
            next = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            graph.get(now).add(new Node(next, cost));
        }

        st = new StringTokenizer(br.readLine());
        now = Integer.parseInt(st.nextToken());
        next = Integer.parseInt(st.nextToken());

        dijkstra(now);

        System.out.println(d[next]);
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
