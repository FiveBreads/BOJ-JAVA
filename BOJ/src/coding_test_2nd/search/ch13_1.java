package coding_test_2nd.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ch13_1 {

    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static int[] d = new int[300001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //도시 개수
        int m = Integer.parseInt(st.nextToken()); //도로 개수
        int k = Integer.parseInt(st.nextToken()); //거리 정보
        int x = Integer.parseInt(st.nextToken()); //출발 도시 번호

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            d[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
        }
        Queue<Integer> que = new LinkedList<>();
        que.offer(x);
        d[x] = 0;
        while (!que.isEmpty()){
            int now = que.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                if (d[next] == -1){
                    d[next] = d[now] + 1;
                    que.offer(next);
                }
            }
        }
        boolean check = false;
        for (int i = 1; i <= n; i++) {
            if (d[i] == k){
                System.out.println(i);
                check = true;
            }
        }
        if (!check) {
            System.out.println(-1);
        }
    }
}
