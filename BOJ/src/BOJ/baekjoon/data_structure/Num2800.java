package BOJ.baekjoon.data_structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by prayzz12@gmail.com on 2021-07-19
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 괄호 제거
 * content : 스택
 * link : [https://www.acmicpc.net/problem/2800]
 */

class Pair {
    private int left;
    private int right;

    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }
}
public class Num2800 {

    static HashSet<String> set;
    static ArrayList<Pair> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Stack<Integer> stk = new Stack<>();

        set = new HashSet<>();
        list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '('){
                stk.push(i);
            }else if (input.charAt(i) == ')'){
                list.add(new Pair(stk.pop(), i));
            }
        }
        dfs(0, input);
        List result = new ArrayList(set);
        Collections.sort(result);
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < result.size(); i++) {
            builder.append(result.get(i)).append("\n");
        }
        System.out.println(builder.toString());
    }

    private static void dfs(int index, String input) {
        if (index < list.size()){
            StringBuilder builder = new StringBuilder(input);
            builder.setCharAt(list.get(index).getLeft(), ' ');
            builder.setCharAt(list.get(index).getRight(), ' ');
            dfs(index + 1, builder.toString());

            builder.setCharAt(list.get(index).getLeft(), '(');
            builder.setCharAt(list.get(index).getRight(), ')');
            dfs(index + 1, builder.toString());
        }else{
            set.add(input.replaceAll(" ", ""));
        }
    }
}
