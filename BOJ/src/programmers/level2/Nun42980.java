package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Candidate{

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
}
