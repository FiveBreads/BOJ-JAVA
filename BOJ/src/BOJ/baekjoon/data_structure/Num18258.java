package BOJ.baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Created by prayzz12@gmail.com on 2021-07-16
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 큐2
 * content : Queue
 * link : [https://www.acmicpc.net/problem/18258]
 */
public class Num18258 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> que = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.startsWith("push")){
                String[] push = str.split(" ");
                que.add(Integer.valueOf(push[1]));
            }else if (str.startsWith("pop")){
                if (que.isEmpty()) {
                    builder.append(-1).append('\n');
                } else {
                    builder.append(que.removeFirst()).append('\n');
                }
            }else if (str.startsWith("size")){
                builder.append(que.size()).append('\n');
            }else if (str.startsWith("empty")){
                if (que.isEmpty()){
                    builder.append(1).append('\n');
                }else{
                    builder.append(0).append('\n');
                }
            }else if (str.startsWith("front")){
                if (que.isEmpty()) {
                    builder.append(-1).append('\n');
                } else {
                    builder.append(que.getFirst()).append('\n');
                }
            }else if (str.startsWith("back")){
                if (que.isEmpty()) {
                    builder.append(-1).append('\n');
                } else {
                    builder.append(que.getLast()).append('\n');
                }
            }
        }
        System.out.println(builder.toString());
        br.close();
    }
}
