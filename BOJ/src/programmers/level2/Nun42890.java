package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Nun42890 {

    static Set<String> keySet;

    public int solution(String[][] relation) {
        keySet = new HashSet<>();

        for (int keyCnt = 1; keyCnt <= relation[0].length; keyCnt++) {
            dfs(keyCnt, new ArrayList<>(), 0, relation);
        }

        return keySet.size();
    }

    private void dfs(int keyCnt, List<Integer> indexList, int start, String[][] relation) {
        if (indexList.size() == keyCnt){
            for (int i = 0; i < relation.length; i++) {
                StringBuilder from = new StringBuilder();
                for (int k = 0; k < indexList.size(); k++) {
                    from.append(relation[i][indexList.get(k)]);
                }
                for (int j = i + 1; j < relation.length; j++) {
                    StringBuilder to = new StringBuilder();
                    for (int k = 0; k < indexList.size(); k++) {
                        to.append(relation[j][indexList.get(k)]);
                    }
                    if (from.toString().equals(to.toString())) return;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Integer integer : indexList) {
                sb.append(integer);
            }
            char[] chars = sb.toString().toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);

            for (String s : keySet) {
                if (key.startsWith(s)) return;
            }
            keySet.add(key);
        }
        int sum = 0;
        for (int i = start; i < relation[0].length; i++) {
            indexList.add(i);
            dfs(keyCnt, indexList, start + 1, relation);
            indexList.remove(indexList.size() - 1);
        }
    }

    @Test
    void 후보키(){
        Assertions.assertEquals(2, solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}}));
        Assertions.assertEquals(0, solution(new String[][]{{"ab", "c"}, {"a", "bc"}, {"x", "yz"}, {"x", "c"}}));
        Assertions.assertEquals(2, solution(new String[][]{
            {"a", "1", "4"},
            {"2", "1", "5"},
            {"a", "2", "4"}}));
        Assertions.assertEquals(2, solution(new String[][]{{"100", "r"},{"200", "c"},{"300", "d"}}));
    }
}



/*class Candidate{

    private ArrayList<Boolean> list;
    private int column_cnt;

    public Candidate(Boolean[] visit, int column_cnt) {
        this.list = new ArrayList<>(Arrays.asList(visit));
        this.column_cnt = column_cnt;
    }
    public boolean isUnique(Candidate target){
        if (this.list.containsAll(target.list)) return true;
        if (target.list.containsAll(this.list)) return true;
        return false;
    }
}

public class Nun42980 {

    public static int column_cnt;
    public static int tuple_cnt;

    public static Boolean[] visit;
    public static ArrayList<Candidate> list = new ArrayList<>();

    public void dfs(int now, int max, String[][] relation){
        if (now == max){
            Map<String, Integer> duplication_map = new HashMap<>();
            for (int i = 0; i < tuple_cnt; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < column_cnt; j++) {
                    if (visit[j]){
                        builder.append(relation[i][j]);
                    }
                }
                if (duplication_map.containsKey(builder.toString())){
                    return;
                }else{
                    duplication_map.put(builder.toString(), max);
                }
            }
            list.add(new Candidate(visit.clone(), max));
            return;
        }
        for (int i = 0; i < column_cnt; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            dfs(now + 1, max, relation);
            visit[i] = false;
        }
    }

    public void makeUnique(){
        for (int i = 0; i < list.size(); i++) {
            Candidate candidate = list.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                if (candidate.isUnique(list.get(j))){
                    list.remove(j);
                    i = -1;
                    break;
                }
            }
        }
    }

    public int solution(String[][] relation) {
        column_cnt = relation[0].length;
        tuple_cnt = relation.length;
        visit = new Boolean[column_cnt];
        for (int i = 0; i < column_cnt; i++) {
            visit[i] = false;
        }
        for (int i = 0; i < column_cnt; i++) {
            visit[i] = true;
            dfs(0, i, relation);
            visit[i] = false;
        }
        makeUnique();
        return list.size();
    }

    @Test
    void 후보키(){
        Assertions.assertEquals(2, solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}}));
    }
}*/
