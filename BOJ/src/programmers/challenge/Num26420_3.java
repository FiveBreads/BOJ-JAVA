package programmers.challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num26420_3 {
    public int solution(String s, String t) {
        int start_index = 0;
        int iter_cnt = t.length();

        int result = 0;

        StringBuilder target = new StringBuilder(s);
        while ((start_index = target.indexOf(t, start_index)) >= 0){
            result ++;
            for (int i = 0; i < iter_cnt; i++) {
                target.deleteCharAt(start_index);
            }
            if (start_index - iter_cnt >= 0){
                start_index -= iter_cnt;
            }else{
                start_index = 0;
            }
        }
        return result;
    }

    @Test
    void 문자열_지우기(){
        Assertions.assertEquals(2, solution("aabcbcd", "abc"));
        Assertions.assertEquals(5, solution("aaaaabbbbb", "ab"));
        Assertions.assertEquals(1, solution("aabcbcd", "ab"));
        Assertions.assertEquals(2, solution("aabcbcd", "b"));
        Assertions.assertEquals(0, solution("acac", "acacacac"));
        Assertions.assertEquals(0, solution("acacacat", "acacacac"));
    }
}
