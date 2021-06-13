package coding_test_2nd.impl;

import java.util.LinkedList;
import java.util.Queue;

public class ch12_3 {

    public static int solution(String s){
        int len = s.length() / 2;
        int min = s.length();
        Queue<Character> que = new LinkedList<>();
        for (int i = 1; i <= len; i++) { //압축 가능 길이 반복
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                que.offer(s.charAt(j));
            }

            StringBuilder tmp = new StringBuilder();
            StringBuilder tmp2;
            for (int j = 0; j < i; j++) {
                tmp.append(que.poll());
            }

            int count = 1;
            while (!que.isEmpty()){
                tmp2 = new StringBuilder();
                for (int j = 0; j < i; j++) {
                    tmp2.append(que.poll());
                }
                if (tmp.toString().equals(tmp2.toString())){
                    count++;
                }else {
                    if (count > 1) {
                        result.append(count);
                        count = 1;
                    }
                    result.append(tmp.toString());
                    tmp = tmp2;
                }
            }
            if (count > 1) result.append(count);
            result.append(tmp.toString());
            min = Math.min(min, result.length());
        }
        return min;
    }

    public static void main(String[] args) {
        String s = "abcabcdede";
        System.out.println(solution(s));
    }
}
