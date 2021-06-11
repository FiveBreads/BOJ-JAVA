package BOJ.graphT;

import java.util.Scanner;

public class ch18_2 {

    static int[] parent;
    static int find (int n){
        if (n == parent[n]) return n;
        return parent[n] = find(parent[n]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if (a < b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        int p = sc.nextInt();

        parent = new int[g + 1];
        for (int i = 0; i <= g; i++) {
            parent[i] = i;
        }

        int result = 0;
        for (int i = 0; i < p; i++) {
            int dock = sc.nextInt();
            int root = find(dock);
            if (root == 0) break;
            union(root, root - 1);
            result++;
        }
        System.out.println(result);
    }
}
