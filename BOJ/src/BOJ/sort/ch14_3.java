package BOJ.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Stage implements Comparable<Stage>{
    private int stageNum;
    private double failRate;

    public Stage(int stageNum, double failRate) {
        this.stageNum = stageNum;
        this.failRate = failRate;
    }

    public double getFailRate() {
        return failRate;
    }

    public int getStageNum() {
        return stageNum;
    }

    @Override
    public int compareTo(Stage o) {
        if (this.failRate == o.getFailRate()){
            return Integer.compare(this.stageNum, o.getStageNum());
        }
        return Double.compare(o.getFailRate(), this.failRate);
    }
}

public class ch14_3 {

    public static int[] solution(int N, int[] stages){
        int[] answer = new int[N];
        ArrayList<Stage> arrayList = new ArrayList<>();
        int length = stages.length;

        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i){
                    cnt += 1;
                }
            }
            double fail = 0;
            if (length > 1) {
                fail = (double) cnt / length;
            }

            arrayList.add(new Stage(i, fail));
            length -= cnt;
        }
        Collections.sort(arrayList);

        // 정렬된 스테이지 번호 반환
        for (int i = 0; i < N; i++) {
            answer[i] = arrayList.get(i).getStageNum();
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
