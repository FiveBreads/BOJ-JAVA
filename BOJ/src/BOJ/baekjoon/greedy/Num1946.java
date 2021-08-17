package BOJ.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by prayzz12@gmail.com on 2021-08-17
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 신입사원
 * content :
 * link : [https://www.acmicpc.net/problem/1946]
 */
public class Num1946 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            StringTokenizer st;
            //한 사람이 가지는 두개의 우선순위가 중복없이 주어진다면
            //하나는 배열의 인덱스로 사용하고 하나는 그 값으로 사용한다면
            //정렬도 필요없이 입력 받는것으로 정렬이 완료된다.
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a] = b;
            }

            //오름차순으로 인덱스가 증가하기 때문에
            //배열의 값, 즉 면접 성적은 무조건 기준 값보다 커야함.
            //서류 1등이 면접도 1등이면 1명 합격 가능.
            //근데 서류 1등이 면접이 5등이면
            //서류 2등이 면접 4등 3등 2등 1등 중에 하나면 합격.
            int result = 1;
            int standard = arr[1];
            for (int j = 2; j <= n; j++) {
                if (standard > arr[j]){
                    standard = arr[j];
                    result++;
                }
            }
            builder.append(result)
                .append("\n");
        }
        System.out.println(builder);
    }
}
