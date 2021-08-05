package team_note;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Util {

    static class Node{
        private String data;
        private Node left;
        private Node right;

        public Node(String data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Tree{
        private Node root;

        public Tree(Node node){
            root = node;
        }

        public void addNode(String data, String leftData, String rightData){
            Node findNode = findNodeByData(data);
            if (!".".equals(leftData)){
                findNode.left = new Node(leftData);
            }
            if (!".".equals(rightData)){
                findNode.right = new Node(rightData);
            }
        }

        public Node findNodeByData(String data){
            Queue<Node> que = new LinkedList<>();
            que.offer(root);
            while (!que.isEmpty()){
                Node poll = que.poll();
                if (data.equals(poll.data)){
                    return poll;
                }
                if (poll.left != null) que.offer(poll.left);
                if (poll.right != null) que.offer(poll.right);
            }
            return null;
        }

        public StringBuilder preOrder(Node node, StringBuilder builder){
            if (node != null){
                builder.append(node.data);
                preOrder(node.left, builder);
                preOrder(node.right, builder);
            }
            return builder;
        }

        public StringBuilder postOrder(Node node, StringBuilder builder){
            if (node != null) {
                postOrder(node.left, builder);
                postOrder(node.right, builder);
                builder.append(node.data);
            }
            return builder;
        }

        public StringBuilder inOrder(Node node, StringBuilder builder){
            if (node != null) {
                inOrder(node.left, builder);
                builder.append(node.data);
                inOrder(node.right, builder);
            }
            return builder;
        }

    }

    // 최솟값과 최댓값 초기화
    static int minValue = (int) 1e9;
    static int maxValue = (int) -1e9;

    //상하좌우 방향 설정
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int n;

    static void move(int x, int y){

        //방향 이동
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            //배열 범위 밖으로 초과하는지 여부 검사
            if (nx > 0 && nx <= n && ny > 0 && ny <= n) {

            }
        }
    }

    //최대 공약수
    static int gcd(int a, int b) {
        int big = a;
        int small = b;
        if (a <= b) {
            big = b;
            small = a;
        }
        while (big % small != 0){
            int r = big % small;
            big = small;
            small = r;
        }
        return small;
    }

    //최소 공배수
    static int lcm(int x, int y) {
        return (x * y) / gcd(x, y);
    }

    //소수 판별
    static boolean isPrime(int num){
        if (num == 1) return false;
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }
}
