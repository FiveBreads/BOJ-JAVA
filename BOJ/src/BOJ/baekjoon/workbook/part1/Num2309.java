package BOJ.baekjoon.workbook.part1;

import java.util.*;

/**
 * Created by prayzz12@gmail.com on 2021-08-05
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 일곱 난쟁이
 * content :
 * link : [https://www.acmicpc.net/problem/2309]
 */
public class Num2309 {

    static int[] dwarves;
    static int sum;
    static boolean[] visit;
    static List<Integer> answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        visit = new boolean[9];
        dwarves = new int[9];
        sum = 0;

        for (int i = 0; i < 9; i++) {
            dwarves[i] = sc.nextInt();
            sum += dwarves[i];
        }

        dfs(0, 0);

        Collections.sort(answer);
        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }

    static void dfs(int index, int count){
        if (count == 2){
            int tmp = sum;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                if (visit[i]) tmp -= dwarves[i];
                else list.add(dwarves[i]);
            }
            if (tmp == 100){
                answer = list;
            }
            return;
        }
        for (int i = index; i < 9; i++) {
            visit[i] = true;
            dfs(index + 1, count + 1);
            visit[i] = false;
        }
    }
}

//1회차 풀이
/*
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int dwarf = sc.nextInt();
            list.add(dwarf);
            sum += dwarf;
        }
        Collections.sort(list);
        int i, j;
        for (i = 0; i < 9; i++) {
            int tmp = sum - list.get(i);
            for (j = 0; j < 9; j++) {
                if (j == i) continue;
                if (tmp - list.get(j) == 100){
                    for (int k = 0; k < list.size(); k++) {
                        if (k != i && k != j) {
                            System.out.println(list.get(k));
                        }
                    }
                    return;
                }
            }
        }
    }
* */
