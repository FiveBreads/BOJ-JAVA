package BOJ.baekjoon.data_structure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Created by prayzz12@gmail.com on 2021-07-21
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 생태학
 * content : TreeMap
 * link : [https://www.acmicpc.net/problem/4358]
 */
public class Num4358 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        TreeMap<String, Double> map = new TreeMap<>();
        double def = 0, total = 0;
        while (!"".equals(input = br.readLine()) && input != null){
            map.put(input, map.getOrDefault(input, def) + 1);
            total++;
        }
        StringBuilder answer = new StringBuilder();
        for (Entry<String, Double> entry : map.entrySet()) {
            answer.append(entry.getKey())
                .append(" ")
                .append(String.format("%.4f", entry.getValue() / total * 100.0000))
                .append("\n");
        }
        System.out.println(answer.toString());
    }
}
