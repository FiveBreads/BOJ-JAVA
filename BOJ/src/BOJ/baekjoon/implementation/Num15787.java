package BOJ.baekjoon.implementation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by prayzz12@gmail.com on 2021-07-29
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 기차가 어둠을 헤치고
 * content :
 * link : [https://www.acmicpc.net/problem/15787]
 */
public class Num15787 {

    static int N, M;
    static int[][] train;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        train = new int[N + 1][21];
        for (int i = 0; i < M; i++) {
            int orderNum = sc.nextInt();
            int trainIndex = sc.nextInt();
            if (orderNum <= 2) {
                int seatIndex = sc.nextInt();
                orderOneTwo(orderNum, trainIndex, seatIndex);
            }else if (orderNum == 3){
                orderThree(trainIndex);
            }else {
                orderFour(trainIndex);
            }
        }
        Set<String> list = new HashSet<>();
        StringBuilder builder;
        for (int i = 1; i <= N; i++) {
            int[] seats = train[i];
            builder = new StringBuilder();
            Arrays.stream(seats).forEach(builder::append);
            list.add(builder.toString());
        }
        System.out.println(list.size());
    }

    static void orderOneTwo(int orderNum, int trainIdx, int seatIndex){
        if (orderNum == 1){
            train[trainIdx][seatIndex] = 1;
        }else{
            train[trainIdx][seatIndex] = 0;
        }
    }

    static void orderThree(int trainIdx){
        for (int i = 20; i > 1; i--) {
            train[trainIdx][i] = train[trainIdx][i - 1];
        }
        train[trainIdx][1] = 0;
    }

    static void orderFour(int trainIdx){
        for (int i = 1; i < 20; i++) {
            train[trainIdx][i] = train[trainIdx][i + 1];
        }
        train[trainIdx][20] = 0;
    }
}
