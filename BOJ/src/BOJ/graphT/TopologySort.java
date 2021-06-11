package BOJ.graphT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TopologySort {

    public static int[] inderee;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static ArrayList<Integer> topologySort(){

        ArrayList<Integer> resultList = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();

        //최초 진입차수가 0인 노드 큐에 삽입
        for (int i = 1; i <= inderee.length; i++) {
            if (inderee[i] == 0) que.offer(i);
        }

        while (!que.isEmpty()){
            int node = que.poll();
            //결과 리스트에 삽입.
            resultList.add(node);

            //진입차수 0인 노드에서 출발하여 도착하는 노드 리스트
            ArrayList<Integer> nodes = graph.get(node);

            //도착하는 노드에서 해당 연결 삭제
            for (int i = 0; i < nodes.size(); i++) {
                int b = nodes.get(i);
                inderee[b]--;
                //연결이 삭제된 노드의 진입차수가 0일경우 큐에 삽입.
                if (inderee[b] == 0){
                    que.offer(b);
                }
            }
        }
        return resultList;
    }


    public static void main(String[] args) throws IOException {
        // N(노드) = 8, A(시작노드), B(도착노드), M(간선 개수)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = 8;
        int m = 7;
        inderee = new int[n + 1];
        //진입 차수 0으로 초기화
        Arrays.fill(inderee, 0);

        //간선정보 초기화
        for (int i = 1; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            inderee[b]++;
        }

        topologySort();
    }
}
