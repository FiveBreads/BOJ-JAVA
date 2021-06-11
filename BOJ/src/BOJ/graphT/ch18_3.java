package BOJ.graphT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Road implements Comparable<Road>{
    private int cost;
    private int nodeA;
    private int nodeB;

    public Road(int cost, int nodeA, int nodeB) {
        this.cost = cost;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getNodeB() {
        return nodeB;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Road o) {
        if (this.cost > o.cost){
            return 1;
        }
        return -1;
    }
}
public class ch18_3 {

    static int[] parent;

    static int find(int x){
        if (parent[x] != x){
            return parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if (a > b){
            parent[a] = b;
        }else {
            parent[b] = a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        ArrayList<Road> roads = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            roads.add(new Road(z, x, y));
        }

        Collections.sort(roads);
        int result = 0;
        for (int i = 0; i < roads.size(); i++) {
            Road r = roads.get(i);
            if (find(r.getNodeA()) != find(r.getNodeB())){
                union(r.getNodeA(),r.getNodeB());
            }else{
                result += r.getCost();
            }
        }
        System.out.println(result);
    }
}
