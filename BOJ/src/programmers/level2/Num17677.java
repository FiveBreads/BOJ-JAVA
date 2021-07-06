package programmers.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num17677 {
    public int solution(String str1, String str2) {
        int union_cnt = 0;
        int dup_cnt = 0;

        Map<String, Integer> one_map = new HashMap<>();
        Map<String, Integer> two_map = new HashMap<>();

        makeMap(str1.toUpperCase(), one_map);
        makeMap(str2.toUpperCase(), two_map);

        for (Entry<String, Integer> one_entry : one_map.entrySet()) {
            if (two_map.containsKey(one_entry.getKey())){
                union_cnt += Math.max(two_map.get(one_entry.getKey()), one_entry.getValue());
                dup_cnt += Math.min(two_map.get(one_entry.getKey()), one_entry.getValue());
                two_map.remove(one_entry.getKey());
            }else {
                union_cnt += one_entry.getValue();
            }
        }

        for (Entry<String, Integer> two_entry : two_map.entrySet()) {
            union_cnt += two_entry.getValue();
        }

        if (dup_cnt == 0 && union_cnt == 0) return 65536;

        int result = (dup_cnt * 65536) / union_cnt;

        return result;
    }

    private void makeMap(String str, Map<String, Integer> map) {
        StringBuilder data;
        for (int i = 1; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i - 1)) && Character.isAlphabetic(str.charAt(i))){
                data = new StringBuilder();
                data.append(str.charAt(i - 1)).append(str.charAt(i));
                map.put(data.toString(), map.getOrDefault(data.toString(), 0) + 1);
            }
        }
    }

    @Test
    void 뉴스_클러스터링(){
        Assertions.assertEquals(16384, solution("FRANCE", "french"));
        Assertions.assertEquals(65536, solution("handshake", "shake hands"));
        Assertions.assertEquals(43690, solution("aa1+aa2", "AAAA12"));
        Assertions.assertEquals(65536, solution("E=M*C^2", "e=m*c^2"));
    }
}
