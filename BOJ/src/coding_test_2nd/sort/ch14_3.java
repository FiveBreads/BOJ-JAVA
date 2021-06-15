package coding_test_2nd.sort;

import java.util.ArrayList;
import java.util.Collections;

class Round implements Comparable<Round>{
    private int index;
    private double failure;

    public int getIndex() {
        return index;
    }

    public Round(int index) {
        this.index = index;
    }

    public void calculateFailure(int total_cnt, int non_clear_cnt){
        this.failure = (non_clear_cnt * 100) / total_cnt;
    }

    @Override
    public int compareTo(Round o) {
        if (this.failure == o.failure){
            return Integer.compare(this.index, o.index);
        }else if (this.failure < o.failure){
            return 1;
        }else {
            return -1;
        }
    }
}
public class ch14_3 {

    static int[] round;
    public static int[] solution(int n, int[] stages){
        round = new int[n + 2];
        int total = 0;
        for (int i = 1; i <= n + 1; i++) {
            round[i] = 0;
        }
        for (int stage : stages) {
            round[stage]++;
            total++;
        }
        ArrayList<Round> list = new ArrayList<>();
        for (int i = 1; i < round.length - 1; i++) {
            Round r = new Round(i);
            r.calculateFailure(total, round[i]);
            total -= round[i];
            list.add(r);
        }
        Collections.sort(list);
        for (Round round1 : list) {
            System.out.println(round1.getIndex());
        }
        return null;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] stages = {4,4,4,4};
        solution(n, stages);
    }
}
