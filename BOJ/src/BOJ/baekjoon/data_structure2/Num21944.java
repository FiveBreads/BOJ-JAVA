package BOJ.baekjoon.data_structure2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by prayzz12@gmail.com on 2021-07-22
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 문제 추천 시스템 version2
 * content : TreeSet
 * link : [https://www.acmicpc.net/problem/21944]
 */
class Prob implements Comparable<Prob>{
    private int number;
    private int value;
    private int group;

    public Prob(int number, int value, int group) {
        this.number = number;
        this.value = value;
        this.group = group;
    }

    public int getNumber() {
        return number;
    }

    public int getValue() {
        return value;
    }

    public int getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Prob prob = (Prob) o;
        return getNumber() == prob.getNumber() && getValue() == prob.getValue()
            && getGroup() == prob
            .getGroup();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getValue(), getGroup());
    }

    @Override
    public int compareTo(Prob o) {
        if (this.value == o.value){
            return o.number - this.number;
        }
        return o.value - this.value;
    }
}
public class Num21944 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        TreeSet<Prob> rec2 = new TreeSet<>();
        Map<Integer, TreeSet<Prob>> rec = new HashMap<>();
        Map<Integer, Integer> numberGroup = new HashMap<>();
        Map<Integer, Integer> numberValue = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int number = sc.nextInt();
            int value = sc.nextInt();
            int group = sc.nextInt();
            Prob prob = new Prob(number, value, group);
            rec2.add(prob);

            TreeSet<Prob> treeSet = new TreeSet<>();
            if (rec.containsKey(group)){
                treeSet = rec.get(group);
            }
            treeSet.add(prob);
            rec.put(group, treeSet);

            numberGroup.put(number, group);
            numberValue.put(number, value);
        }

        int M = sc.nextInt();
        int number, group, value;
        Prob prob;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String command = sc.next();
            if ("add".equals(command)){
                number = sc.nextInt();
                value = sc.nextInt();
                group = sc.nextInt();
                prob = new Prob(number, value, group);
                rec2.add(prob);

                TreeSet<Prob> treeSet = new TreeSet<>();
                if (rec.containsKey(group)){
                    treeSet = rec.get(group);
                }
                treeSet.add(prob);
                rec.put(group, treeSet);

                numberGroup.put(number, group);
                numberValue.put(number, value);
            }else if ("recommend".equals(command)){
                group = sc.nextInt();
                int x = sc.nextInt();
                if (x == 1){
                    answer.append(rec.get(group).first().getNumber()).append("\n");
                }else {
                    answer.append(rec.get(group).last().getNumber()).append("\n");
                }
            }else if ("recommend2".equals(command)){
                int x = sc.nextInt();
                if (x == 1){
                    answer.append(rec2.first().getNumber()).append("\n");
                }else {
                    answer.append(rec2.last().getNumber()).append("\n");
                }

            }else if ("recommend3".equals(command)){
                int x = sc.nextInt();
                value = sc.nextInt();
                if (x == 1){
                    Prob floor = rec2.floor(new Prob(0, value, 0));
                    if (floor == null){
                        answer.append(-1).append("\n");
                    }else{
                        answer.append(floor.getNumber()).append("\n");
                    }
                }else{
                    Prob higher = rec2.higher(new Prob(0, value, 0));
                    if (higher == null){
                        answer.append(-1).append("\n");
                    }else{
                        answer.append(higher.getNumber()).append("\n");
                    }
                }
            }else { //solved
                number = sc.nextInt();
                value = numberValue.get(number);
                group = numberGroup.get(number);
                prob = new Prob(number, value, group);
                rec2.remove(prob);
                rec.get(group).remove(prob);
            }
        }
        System.out.println(answer.toString());
    }
}
