package BOJ.shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class City implements Comparable<City>{
    private int index;
    private int distance;

    public City(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(City o) {
        if (this.distance < o.getDistance()) return -1;
        return 1;
    }
}

public class ch9_3 {

    public static ArrayList<ArrayList<City>> graph = new ArrayList<>();
    public static int[] d;
    public static int INF = Integer.MAX_VALUE;

    public static void solution(int start){
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(start, 0));

        d[start] = 0;
        while (!pq.isEmpty()){
            City city = pq.poll();

            int now = city.getIndex();
            int distance = city.getDistance();

            if (distance > d[now]) continue;
            ArrayList<City> cities = graph.get(now);
            for (City city1 : cities) {
                int cost = distance + city1.getDistance();
                if (cost < d[city1.getIndex()]){
                    d[city1.getIndex()] = cost;
                    pq.add(new City(city1.getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            d[i] = INF;
        }

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            graph.get(x).add(new City(y, z));
        }

        solution(c);

        int count = 0;
        int max_distance = 0;
        for (int i : d) {
            if (i != INF) {
                count++;
                max_distance = Math.max(max_distance, d[i]);
            }
        }
        System.out.println((count - 1) + " " + max_distance);
    }
}
