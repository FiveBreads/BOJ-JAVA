package BOJ.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class ch6_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        List<Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        Collections.sort(entryList, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        LinkedHashMap<String, Integer> sortedList = new LinkedHashMap<>();
        for (Entry<String, Integer> entry : entryList) {
            sortedList.put(entry.getKey(), entry.getValue());
        }

        for (String s : sortedList.keySet()) {
            System.out.printf(s + " ");
        }
    }
}
