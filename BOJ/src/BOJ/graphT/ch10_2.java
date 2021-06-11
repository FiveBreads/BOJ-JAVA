package BOJ.graphT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    private int value;
    private int nodeA;
    private int nodeB;

    public Edge(int value, int nodeA, int nodeB) {
        this.value = value;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.value > o.getValue()){
            return 1;
        }
        return -1;
    }
}

public class ch10_2 {

    static int[] parent;

    static int find(int n){
        if (parent[n] != n){
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }

    static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if (pa > pb){
            parent[a] = pb;
        }else {
            parent[b] = pa;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(c, a, b));
        }
        Collections.sort(edges);

        int last = 0;
        int result = 0;
        for (int i = 0; i < edges.size(); i++) {
            Edge e = edges.get(i);
            int pa = find(e.getNodeA());
            int pb = find(e.getNodeB());
            if (pa != pb){
                union(e.getNodeA(), e.getNodeB());
                //최소신장트리의 값 전체 합계
                result += e.getValue();
                //오름차순으로 정렬되어 있기 때문에 가장 마지막의 값이 결국 가장 큰 값이라고 할 수 있음.
                //이 if문 안에 들어왔다는것은 아직 처리되지 않은 것들 중에 가장 큰 값이기 때문.
                last = e.getValue();
            }
        }
        //최소신장트리의 가중치 합계 중 가장 큰 값을 가지는 간선을 배제하면 최소 최소 신장트리 2개가 생성된다는 꿀팁.
        System.out.println(result - last);
    }
}
