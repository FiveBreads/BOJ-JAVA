package BOJ.graphT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ch10_1 {

    static int[] nodes;

    static int find(int n){
        if (nodes[n] != n){
            nodes[n] = find(nodes[n]);
        }
        return nodes[n];
    }

    static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if (pa > pb){
            nodes[a] = pb;
        }else{
            nodes[b] = pa;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        nodes = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            nodes[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int operator = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (operator == 0) {
                union(a, b);
            }
            else {
                if (find(a) == find(b)){
                    sb.append("YES" + "\n");
                }else{
                    sb.append("NO" + "\n");
                }
            }
        }

        System.out.println(sb.toString());
    }
}
