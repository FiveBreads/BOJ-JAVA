package BOJ.baekjoon.data_structure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * Created by prayzz12@gmail.com on 2021-07-21
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 이중 우선순위 큐
 * content : treemap
 * link : [https://www.acmicpc.net/problem/7662]
 */
public class Num7662 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.valueOf(br.readLine());
        int k;
        for (int i = 0; i < T; i++) {
            TreeMap<Integer, Integer> pq = new TreeMap<>();
            k = Integer.valueOf(br.readLine());
            for (int j = 0; j < k; j++) {
                String[] input = br.readLine().split(" ");
                if ("I".equals(input[0])){
                    Integer value = Integer.valueOf(input[1]);
                    pq.put(value, pq.getOrDefault(value, 0) + 1);
                }else if (!pq.isEmpty()){
                    if (String.valueOf(1).equals(input[1])){
                        Integer max = pq.lastKey();
                        if (pq.get(max) == 1){
                            pq.remove(max);
                        }else{
                            pq.put(max, pq.get(max) - 1);
                        }
                    }else{
                        //최소값 제거
                        Integer min = pq.firstKey();
                        if (pq.get(min) == 1){
                            pq.remove(min);
                        }else{
                            pq.put(min, pq.get(min) - 1);
                        }
                    }
                }
            }
            if (pq.isEmpty()){
                answer.append("EMPTY").append("\n");
            }else{
                answer.append(pq.lastKey()).append(" ").append(pq.firstKey()).append("\n");
            }
        }
        System.out.println(answer.toString());
    }
}
