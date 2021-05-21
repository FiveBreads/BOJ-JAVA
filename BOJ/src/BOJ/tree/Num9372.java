package BOJ.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num9372 {

    static ArrayList<Integer>[] nodes;


    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(bufferedReader.readLine());

        while (t-- > 0){
            st = new StringTokenizer(bufferedReader.readLine());
            int country = Integer.parseInt(st.nextToken());
            int plane = Integer.parseInt(st.nextToken());

            nodes = new ArrayList[country + 1];

            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = new ArrayList<>();
            }

            for (int i = 0; i < plane; i++) {
                st = new StringTokenizer(bufferedReader.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                nodes[a].add(b);
                nodes[b].add(a);
            }
            sb.append(String.valueOf(country-1) + "\n");
        }
        System.out.println(sb.toString());
    }
}