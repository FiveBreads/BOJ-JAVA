package BOJ.baekjoon.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by prayzz12@gmail.com on 2021-07-30
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : ZOAC
 * content :
 * link : [https://www.acmicpc.net/problem/16719]
 */
public class Num16719 {

    static class Node implements Comparable<Node>{
        private char alpha;
        private int index;

        public Node(char alpha, int index) {
            this.alpha = alpha;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            if (this.alpha == o.alpha){
                return this.index - o.index;
            }
            return Character.compare(this.alpha, o.alpha);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] chars = input.toCharArray();
        TreeSet<Node> pq = new TreeSet<>();
        for (int i = 0; i < chars.length; i++) {
            pq.add(new Node(chars[i], i));
        }
        TreeSet<Integer> indexSet = new TreeSet<>();
        pq.pollFirst();

    }
}
