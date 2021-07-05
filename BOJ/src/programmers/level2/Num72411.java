package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num72411 {

    public static Map<String, Integer> data;
    public static int m;

    public String[] solution(String[] orders, int[] course) {

        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i = 0; i < course.length; i++) {
            data = new HashMap<>();
            m = 0;
            for (int j = 0; j < orders.length; j++) {
                if (orders[j].length() < course[i])
                    continue;
                dfs(0, new StringBuilder(), orders[j], course[i], 0);
            }
            if (m > 1){
                Set<String> combi = data.keySet();
                for (String menu : combi) {
                    if (data.get(menu) == m){
                        pq.offer(menu);
                    }
                }
            }
        }
        String[] answer = new String[pq.size()];
        int i = 0;
        while (!pq.isEmpty()) {
            answer[i] = pq.poll();
            i++;
        }
        return answer;
    }

    public void dfs(int cnt, StringBuilder builder, String target, int max, int index){
        if (cnt == max){
            System.out.println("-----------------");
            System.out.println("before ::: " + builder.toString());
            Arrays.sort(builder.chars().toArray());
            System.out.println("after ::: " + builder.toString());
            data.put(builder.toString(), data.getOrDefault(builder.toString(), 0) + 1);
            m = Math.max(m, data.get(builder.toString()));
            return;
        }

        for (int i = index; i < target.length(); i++) {
            dfs(cnt + 1, builder.append(target.charAt(i)), target, max, i + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    @Test
    void 메뉴_리뉴얼(){
        //Assertions.assertArrayEquals(new String[]{"AC", "ACDE", "BCFG", "CDE"}, solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4}));
        //Assertions.assertArrayEquals(new String[]{"ACD", "AD", "ADE", "CD", "XYZ"}, solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2,3,5}));
        Assertions.assertArrayEquals(new String[]{"WX", "XY"}, solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2,3,4}));
    }
}
