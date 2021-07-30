package BOJ.baekjoon.implementation;

import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-07-30
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 홀수 홀릭 호석
 * content :
 * link : [https://www.acmicpc.net/problem/20164]
 */
public class Num20164 {

    static int max, min;

    static int getOddCnt (int num){
        String tmp = String.valueOf(num);
        int cnt = 0;
        for (int i = 0; i < tmp.length(); i++) {
            if ((tmp.charAt(i) - '0') % 2 == 1) cnt++;
        }
        return cnt;
    }

    static void dfs (int one, int two, int three, int cnt){
        int sum = one + two + three;
        if (sum < 10){
            cnt += getOddCnt(sum);
            max = Math.max(max, cnt);
            min = Math.min(min, cnt);
            return;
        }else if (sum < 100){
            int tmp_one = sum / 10;
            int tmp_two = sum % 10;
            cnt += getOddCnt(tmp_one);
            cnt += getOddCnt(tmp_two);
            dfs(tmp_one, tmp_two, 0, cnt);
        }else{
            String num = String.valueOf(sum);
            cnt += getOddCnt(sum);
            for (int i = 0; i < num.length() - 2; i++) {
                one = Integer.parseInt(num.substring(0, i + 1));
                for (int j = i + 1; j < num.length() - 1; j++) {
                    two = Integer.parseInt(num.substring(i + 1, j + 1));
                    three = Integer.parseInt(num.substring(j + 1));
                    dfs(one, two, three, cnt);
                }
            }
        }
    }

    public static void main(String[] args) {
        max = 0;
        min = 10000;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String num = String.valueOf(N);
        int cnt = getOddCnt(N);
        if (N < 10){
            max = Math.max(max, cnt);
            min = Math.min(min, cnt);
        }else if (N < 100){
            int tmp_one = N / 10;
            int tmp_two = N % 10;
            cnt += getOddCnt(tmp_one);
            cnt += getOddCnt(tmp_two);
            dfs(tmp_one, tmp_two, 0, cnt);
        }else{
            for (int i = 0; i < num.length() - 2; i++) {
                int one = Integer.parseInt(num.substring(0, i + 1));
                for (int j = i + 1; j < num.length() - 1; j++) {
                    int two = Integer.parseInt(num.substring(i + 1, j + 1));
                    int three = Integer.parseInt(num.substring(j + 1));
                    dfs(one, two, three, cnt);
                }
            }
        }
        System.out.println(min + " " + max);
    }
}
