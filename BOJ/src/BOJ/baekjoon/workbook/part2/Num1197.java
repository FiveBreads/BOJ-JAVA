package BOJ.baekjoon.workbook.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by prayzz12@gmail.com on 2021-08-10
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 최소 스패닝 트리
 * content :
 * link : [https://www.acmicpc.net/problem/1197]
 */
public class Num1197{

    static class Edge implements Comparable<Edge>{
        private int distance;
        private int nodeA;
        private int nodeB;

        public Edge(int distance, int nodeA, int nodeB) {
            this.distance = distance;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    static int v,e;
    static List<Edge> edges;
    static int[] parents = new int[10001];

    static int findParent(int x){ // 부모를 찾는다는 것. 연결이 되어있는지를 찾는 것.
        if (x == parents[x]) return x;
        return parents[x] = findParent(parents[x]);
    }

    static void unionParent(int a, int b){ //부모를 합친다는 것. 하나가 된다는 것. 연결이 된다는 것.
        a = findParent(a);
        b = findParent(b);
        if (a < b) parents[b] = a;
        else parents[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            edges.add(new Edge(distance, nodeA, nodeB));
        }
        Collections.sort(edges); //오름차순으로 정렬하였기 때문에 하나의 노드에서 다른 노드로 가는 여러가지 간선이 있어도 최소값 우선으로 생성된다.

        for (int i = 0; i <= 10000; i++) {
            //초기화의 의미는 최초에는 노드간 연결이 하나도 없는 상태로 시작하겠다는 뜻.
            parents[i] = i;
        }

        int result = 0;
        for (int i = 0; i < edges.size(); i++) {
            int a = edges.get(i).nodeA;
            int b = edges.get(i).nodeB;
            int distance = edges.get(i).distance;

            if (findParent(a) != findParent(b)){ //두 노드가 같은 부모를 가진다는 뜻은 이미 연결이 되어있다는 뜻이기 때문에 진행하지 않는다.
                unionParent(a, b);
                result += distance;
            }
        }
        System.out.println(result);
    }
}

//1회차 풀이
/*
static class Edge implements Comparable<Edge> {

    private int distance;
    private int nodeA;
    private int nodeB;

    public Edge(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getNodeA() {
        return this.nodeA;
    }

    public int getNodeB() {
        return this.nodeB;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Edge other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public static int v, e;
public static int[] parent = new int[100001];
public static ArrayList<Edge> edges = new ArrayList<>();
public static int result = 0;

public static int findParent(int x) {
    // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
    if (x == parent[x]) return x;
    return parent[x] = findParent(parent[x]);
}

// 두 원소가 속한 집합을 합치기
public static void unionParent(int a, int b) {
    a = findParent(a);
    b = findParent(b);
    if (a < b) parent[b] = a;
    else parent[a] = b;
}

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    v = sc.nextInt();
    e = sc.nextInt();

    // 부모 테이블상에서, 부모를 자기 자신으로 초기화
    for (int i = 1; i <= v; i++) {
        parent[i] = i;
    }

    // 모든 간선에 대한 정보를 입력 받기
    for (int i = 0; i < e; i++) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int cost = sc.nextInt();
        edges.add(new Edge(cost, a, b));
    }

    // 간선을 비용순으로 정렬
    Collections.sort(edges);

    // 간선을 하나씩 확인하며
    for (int i = 0; i < edges.size(); i++) {
        int cost = edges.get(i).getDistance();
        int a = edges.get(i).getNodeA();
        int b = edges.get(i).getNodeB();
        // 사이클이 발생하지 않는 경우에만 집합에 포함
        if (findParent(a) != findParent(b)) {
            unionParent(a, b);
            result += cost;
        }
    }

    System.out.println(result);
}
* */