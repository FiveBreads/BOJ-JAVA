package BOJ.baekjoon.implementation;

import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-07-27
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 스위치 켜고 끄기
 * content :
 * link : [https://www.acmicpc.net/problem/1244]
 */
public class Num1244 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int switchCnt = sc.nextInt();
        int[] status = new int[switchCnt + 1];
        for (int i = 1; i <= switchCnt; i++) {
            status[i] = sc.nextInt();
        }
        int studentCnt = sc.nextInt();
        for (int i = 0; i < studentCnt; i++) {
            int gender = sc.nextInt();
            int target = sc.nextInt();
            if (gender == 1){ //남성
                int tmp = target;
                while (tmp <= switchCnt){
                    swap(status, tmp);
                    tmp += target;
                }
            }else {//여성
                int start = target;
                int end = target;
                while (start > 0 && end <= switchCnt) {
                    if (status[start] == status[end]) {
                        swap(status, start);
                        status[end] = status[start];
                        start--;
                        end++;
                    }else{
                        break;
                    }
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        int cnt = 0;
        for (int i = 1; i <= switchCnt; i++) {
            if (cnt == 20) {
                answer.append("\n");
                cnt = 0;
            }
            answer.append(status[i]).append(" ");
            cnt++;
        }
        System.out.println(answer.toString());
    }

    private static void swap(int[] status, int tmp) {
        if (status[tmp] == 0) status[tmp] = 1;
        else status[tmp] = 0;
    }
}
