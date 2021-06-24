package programmers.level2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Num12973 {
    public static int solution(String s)
    {
        if (s.length() == 1) return 0;
        Deque<Character> que = new LinkedList<>();
        que.offer(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (que.size() > 0 && que.getLast() == s.charAt(i)){
                que.removeLast();
            }else{
                que.offer(s.charAt(i));
            }
        }
        if (que.isEmpty()) return 1;
        else return 0;
    }

    public static void main(String[] args) {
        String str = "cdcd";
        solution(str);
    }
}
