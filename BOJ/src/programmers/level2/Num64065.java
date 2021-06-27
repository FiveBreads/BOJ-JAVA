package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class Num64065 {
    public static int[] solution(String s) {
        s = s.replace("{", "");
        s = s.replace("}", "");
        String[] elements = s.split(",");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < elements.length; i++) {
            if (map.get(elements[i]) != null){
                map.put(elements[i], map.get(elements[i]) + 1);
            }else {
                map.put(elements[i], 1);
            }
        }
        Stream<Entry<String, Integer>> sorted = map.entrySet().stream().sorted(Entry.comparingByValue(Collections.reverseOrder()));

        List<String> result = new ArrayList<>();
        sorted.forEach(value -> result.add(value.getKey()));

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = Integer.parseInt(result.get(i));
        }
        return answer;
    }

    public static void main(String[] args) {
        solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
    }
}
