package team_note;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by prayzz12@gmail.com on 2021-08-10
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 
 * content : 
 * link : [https://www.acmicpc.net/problem/phMethods]
 */
public class Dijkstra {
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
}
