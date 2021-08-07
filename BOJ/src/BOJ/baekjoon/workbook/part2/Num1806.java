package BOJ.baekjoon.workbook.part2;

import java.io.*;
import java.util.*;
/**
 * Created by prayzz12@gmail.com on 2021-08-07
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 부분합
 * content :
 * link : [https://www.acmicpc.net/problem/1806]
 */
public class Num1806 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long S = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] Narr = new int[N];
        for(int i = 0; i < N; i++){
            Narr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 100001, sum = 0;
        int firstPointer = 0, secondPointer = 0;
        while(true){
            if(sum >= S){
                sum -= Narr[firstPointer++];
                ans = Math.min(ans, (secondPointer - firstPointer) + 1);
            }
            else if(secondPointer == N) break;
            else sum += Narr[secondPointer++];
        }
        if(ans == 100001){
            bw.write(0 + "\n");
        } else {
            bw.write(ans + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
