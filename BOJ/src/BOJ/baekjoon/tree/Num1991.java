package BOJ.baekjoon.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-07-24
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 트리의 순회
 * content : 트리
 * link : [https://www.acmicpc.net/problem/1991]
 */
public class Num1991 {

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

    static Tree tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        tree = new Tree(new Node("A"));

        for (int i = 0; i < N; i++) {
            String parent = sc.next();
            String left = sc.next();
            String right = sc.next();
            tree.addNode(parent, left, right);
        }
        System.out.println(tree.preOrder(tree.root, new StringBuilder()).toString());
        System.out.println(tree.inOrder(tree.root, new StringBuilder()).toString());
        System.out.println(tree.postOrder(tree.root, new StringBuilder()).toString());
    }
}
