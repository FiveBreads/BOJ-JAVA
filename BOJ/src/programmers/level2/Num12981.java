package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class Num12981 {

    public static int[] solution(int n, String[] words) {
        Map<String, Integer> dupMap = new HashMap<>();
        int cnt = 1;
        boolean isWrong = false;
        dupMap.put(words[0], cnt);
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() == 1 || dupMap.containsKey(words[i]) || !words[i - 1].endsWith(words[i].charAt(0) + "")) {
                cnt += i;
                isWrong = true;
                break;
            }
            dupMap.put(words[i], 1);
        }
        int[] answer = new int[2];
        if (!isWrong){
            answer[0] = 0;
            answer[1] = 0;
        }else{
            if (cnt % n == 0){
                answer[0] = n;
                answer[1] = cnt / n;
            }else{
                answer[0] = cnt % n;
                answer[1] = (cnt / n) + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] str = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        solution(3, str);
    }
}
