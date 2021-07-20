package BOJ.baekjoon.data_structure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by prayzz12@gmail.com on 2021-07-20
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 문자열 집합
 * content : map, set도 가능
 * link : [https://www.acmicpc.net/problem/14425]
 */


public class Num14425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] nm = input.split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), 1);
        }
        int answer = 0;
        for (int i = 0; i < m; i++) {
            if (map.containsKey(br.readLine())) answer++;
        }
        System.out.println(answer);
    }
}
