package BOJ.baekjoon.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by prayzz12@gmail.com on 2021-08-16
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 회의실 배정
 * content : greedy
 * link : [https://www.acmicpc.net/problem/1931]
 */
public class Num1931 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] meet = new long[n][2];
        for (int i = 0; i < n; i++) {
            meet[i][0] = sc.nextInt(); //시작시간
            meet[i][1] = sc.nextInt(); //종료시간
        }

        //시작 시간별로 정렬
        Arrays.sort(meet, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[1] > o2[1]) return 1;
                else if (o1[1] == o2[1]){ //종료 시간이 같을 경우 더 일찍 시작하는 친구부터 나열할 것 그래야 제거하면서 가니까~
                    return Long.compare(o1[0], o2[0]);
                }
                else return -1;
            }
        });

        long[] select = meet[0];
        int nonOverlapCount = 1;
        for (int i = 1; i < n; i++) {
            long start = meet[i][0];
            if (start >= select[1]){
                nonOverlapCount++;
                select = meet[i];
            }
        }
        System.out.println(nonOverlapCount);
    }
}
