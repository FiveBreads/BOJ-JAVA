package BOJ.baekjoon.data_structure2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-07-22
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 중앙값 구하기
 * content : 정렬
 * link : [https://www.acmicpc.net/problem/2696]
 */
public class Num2696 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder answer = new StringBuilder();
        int M, input, mid, tmp_cnt;
        for (int i = 0; i < T; i++) {
            M = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            StringBuilder tmp = new StringBuilder();
            tmp_cnt = 0;
            for (int j = 0; j < M; j++) {
                //max, min 값 초기화
                //index 중간이거든요
                input = sc.nextInt();
                list.add(input);
                if (list.size() % 2 != 0){
                    Collections.sort(list, Collections.reverseOrder());
                    Object[] array = list.toArray();
                    mid = list.size() / 2;
                    tmp.append(array[mid]).append(" ");
                    tmp_cnt++;
                    // tmp cnt % 10 == 0이 되는 순간 공백 추가해주기
                    if (tmp_cnt % 10 == 0){
                        tmp.append("\n");
                    }
                }
            }
            answer.append(tmp_cnt)
                .append("\n")
                .append(tmp)
                .append("\n");
        }
        System.out.println(answer.toString());
    }
}
