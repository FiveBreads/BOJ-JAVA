package BOJ.graphT;

public class UnionFind {

    public static int[] parentArr;

    public static int findParent(int node){
        if (node != parentArr[node]) {
            parentArr[node] = findParent(parentArr[node]);
        }
        //return node;
        //경로 압축
        return parentArr[node];
    }

    public static void unionParent(int a, int b){
        int aParent = findParent(a);
        int bParent = findParent(b);
        if (aParent > bParent){
            //b의 부모가 더 root일 경우
            parentArr[a] = bParent;
        }else {
            //a의 부모가 더 root인 경우
            parentArr[b] = aParent;
        }
    }

    public static void main(String[] args) {
        parentArr = new int[7];
        int[][] unions = {
            {1, 4},
            {2, 3},
            {2, 4},
            {5, 6}
        };
        // root 노드 초기화
        for (int i = 0; i <= 6; i++) {
            parentArr[i] = i;
        }

        //union연산 수행
        for (int i = 0; i < unions.length; i++) {
            int a = unions[i][0];
            int b = unions[i][1];
            unionParent(a, b);
        }

        for (int i = 1; i <= 6; i++) {
            System.out.println(parentArr[i]);
        }
    }
}
