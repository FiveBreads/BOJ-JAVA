package BOJ.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class ch13_1 {

    static int n, m, k, x;
    static ArrayList<ArrayList<Integer>> road = new ArrayList<>();
    static int[] d = new int[300001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //도시의 개수
        m = Integer.parseInt(st.nextToken()); //도로의 개수
        k = Integer.parseInt(st.nextToken()); //거리정보 ( 최단거리 )
        x = Integer.parseInt(st.nextToken()); //출발 도시 번호

        for (int i = 1; i <= n; i++) {
            road.add(new ArrayList<Integer>());
            d[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int toB = Integer.parseInt(st.nextToken());
            road.get(a).add(toB);
        }

        d[x] = 0;

        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(x);
        while (!q.isEmpty()) {
            int now = q.poll();
            // 현재 도시에서 이동할 수 있는 모든 도시를 확인
            for (int i = 0; i < road.get(now).size(); i++) {
                int nextNode = road.get(now).get(i);
                // 아직 방문하지 않은 도시라면
                if (d[nextNode] == -1) {
                    // 최단 거리 갱신
                    d[nextNode] = d[now] + 1;
                    q.offer(nextNode);
                }
            }
        }

        boolean check = false;
        for (int i = 1; i <= n; i++) {
            if (d[i] == k) {
                System.out.println(i);
                check = true;
            }
        }
        // 만약 최단 거리가 K인 도시가 없다면, -1 출력
        if (!check) System.out.println(-1);
    }
}
