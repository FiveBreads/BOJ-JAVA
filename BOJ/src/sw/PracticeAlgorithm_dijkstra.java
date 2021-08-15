package sw;

import java.util.*;

/**
 * Created by prayzz12@gmail.com on 2021-08-15
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title :
 * content :
 * link : [https://www.acmicpc.net/problem/cticeAlgorithm]
 */
public class PracticeAlgorithm_dijkstra {
    static class Node implements Comparable<Node>{
        private int index;
        private int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int INF = (int) 1e9;
    static int[] d = new int[10001];
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Arrays.fill(d, INF);
        dijkstra(1);
    }

    static void dijkstra(int startIndex){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startIndex, 0));

        d[startIndex] = 0;

        while (!pq.isEmpty()){
            Node poll = pq.poll();
            int now = poll.index;
            int dist = poll.cost;

            if (d[now] < dist) continue; //이미 방문한 적이 있다. (INF로 초기화 되었기 때문임)

            for (int i = 0; i < graph.get(now).size(); i++) { //현재 노드에서 출발하는 간선의 개수
                int cost = d[now] + graph.get(now).get(i).cost; //현재 노드까지 오는 최소비용 + 현재 노드에서 다음 노드까지 비용 = 다음 노드까지 가는 비용
                if (cost < d[graph.get(now).get(i).index]){ //다음노드까지 오는 비용보다 현재 루트가 더 최소 금액이라면
                    d[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
    }
}
