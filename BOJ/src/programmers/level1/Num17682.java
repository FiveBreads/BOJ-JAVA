package programmers.level1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Num17682 {
    public static int solution(String dartResult) {

        Deque<Integer> que = new LinkedList<>();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < dartResult.length(); i++) {
            if (dartResult.charAt(i) - '0' >= 0 && dartResult.charAt(i) - '0' <= 9){
                number.append(dartResult.charAt(i));
            }else{
                if (number.length() > 0){
                    que.offer(Integer.parseInt(number.toString()));
                    number = new StringBuilder();
                }
                char order = dartResult.charAt(i);
                int num = 0;
                switch (order){
                    case 'D':
                        num = que.removeLast();
                        num = (int) Math.pow(num, 2);
                        que.offer(num);
                        break;
                    case 'T':
                        num = que.removeLast();
                        num = (int) Math.pow(num, 3);
                        que.offer(num);
                        break;
                    case '*':
                        int one = que.removeLast();
                        if (que.size() > 1){
                            int two = que.removeLast();
                            two *= 2;
                            que.addLast(two);
                        }
                        one *= 2;
                        que.add(one);
                        break;
                    case '#':
                        num = que.removeLast();
                        num *= -1;
                        que.addLast(num);
                        break;
                }
            }
        }

        int answer = 0;
        while (!que.isEmpty()){
            answer += que.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("1D2S3T*"));
    }
}
