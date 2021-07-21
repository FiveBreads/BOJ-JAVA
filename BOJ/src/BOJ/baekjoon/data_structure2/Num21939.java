package BOJ.baekjoon.data_structure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

/**
 * Created by prayzz12@gmail.com on 2021-07-21
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 문제 추천 시스템 Version 1
 * content : tree set
 * link : [https://www.acmicpc.net/problem/21939]
 */
class Problem implements Comparable<Problem>{
    private int number;
    private int level;

    public Problem(String[] data) {
        this.number = Integer.parseInt(data[0]);
        this.level = Integer.parseInt(data[1]);
    }

    public Problem(String number, String level) {
        this.number = Integer.parseInt(number);
        this.level = Integer.parseInt(level);
    }

    public int getNumber() {
        return number;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Problem problem = (Problem) o;
        return getNumber() == problem.getNumber() && getLevel() == problem.getLevel();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getLevel());
    }

    @Override
    public int compareTo(Problem o) {
        if (this.level == o.level){
            return Integer.compare(this.number, o.number);
        }
        return Integer.compare(this.level, o.level);
    }
}
public class Num21939 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeSet<Problem> set = new TreeSet<>();
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            map.put(input[0], input[1]);
            set.add(new Problem(input));
        }

        StringBuilder builder = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            if ("add".equals(input[0])){
                set.add(new Problem(input[1], input[2]));
                map.put(input[1], input[2]);
            }else if ("recommend".equals(input[0])){
                if (Integer.valueOf(input[1]) == 1){
                    builder.append(set.last().getNumber()).append("\n");
                }else {
                    builder.append(set.first().getNumber()).append("\n");
                }
            }else{
                set.remove(new Problem(input[1], map.get(input[1])));
            }
        }
        System.out.println(builder.toString());
    }
}
