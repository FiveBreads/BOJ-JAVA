package BOJ.baekjoon.data_structure;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by prayzz12@gmail.com on 2021-07-17
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 풍선 터뜨리기
 * content :
 * link : [https://www.acmicpc.net/problem/2346]
 */
public class Num2346 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int[] balloon = new int[n];

        for (int i = 0; i < n; i++) {
            balloon[i] = Integer.valueOf(st.nextToken());
        }

        StringBuilder builder = new StringBuilder();
        int index = 0, count = 1;
        builder.append(index + 1).append(" ");

        while (count < n){
            int value = balloon[index];
            balloon[index] = 0;
            if (value > 0){
                while (value > 0){
                    index++;
                    if (index == n){
                        index = 0;
                    }
                    if (balloon[index] != 0){
                        value--;
                    }
                }
            }else{
                while (value < 0){
                    index--;
                    if (index < 0){
                        index = n - 1;
                    }
                    if (balloon[index] != 0){
                        value++;
                    }
                }
            }
            count++;
            builder.append(index + 1).append(" ");
        }
        System.out.println(builder.toString().trim());
    }
}
