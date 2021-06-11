package BOJ.graphT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch18_1 {

    static int[] parent;

    static int find(int x){
        if (parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if (pa > pb){
            parent[a] = pb;
        }else{
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
        int[][] data = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (data[i][j] == 1){
                    union(i, j);
                }
            }
        }

        int[] travel = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int mark = Integer.parseInt(st.nextToken());
            travel[i] = find(mark);
        }

        boolean canTravel = true;
        for (int i = 1; i < m; i++) {
            if (travel[i-1] != travel[i]) canTravel = false;
        }
        if (canTravel){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
