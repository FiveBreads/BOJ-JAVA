package programmers.challenge;

import java.util.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num26420_2 {

    public String[] solution(String s) {

        int right_index;
        int len = 1;
        StringBuilder left, right;
        LinkedList<String> left_list = new LinkedList<>();
        LinkedList<String> right_list = new LinkedList<>();
        while (s.length() > 0){
            right_index = s.length();
            if (len > (s.length() / 2)) {
                left_list.add(s);
                break;
            }
            left = new StringBuilder();
            for (int i = 0; i < len; i++) {
                left.append(s.charAt(i));
            }
            right = new StringBuilder();
            for (int i = right_index - len; i < s.length(); i++) {
                right.append(s.charAt(i));
            }
            if (left.toString().equals(right.toString())){
                left_list.add(s.substring(right_index - len));
                right_list.addFirst(s.substring(right_index - len));
                s = s.substring(left.length(), right_index - len);
                len = 1;
            }else{
                len++;
            }
        }

        left_list.addAll(right_list);
        String[] answer = new String[left_list.size()];
        for (int i = 0; i < left_list.size(); i++) {
            answer[i] = left_list.get(i);
        }
        return answer;
    }

    @Test
    void 문자열_자르기(){
        Assertions.assertArrayEquals(new String[]{"abc","xy","asdf","asdf","xy","abc"}, solution("abcxyasdfasdfxyabc"));
        Assertions.assertArrayEquals(new String[]{"abc","xy","qwerty","xy","abc"}, solution("abcxyqwertyxyabc"));
        Assertions.assertArrayEquals(new String[]{"abc","abc","abc","abc"}, solution("abcabcabcabc"));
        Assertions.assertArrayEquals(new String[]{"l","l","t","t","a","a","t","t","l","l"}, solution("llttaattll"));
        Assertions.assertArrayEquals(new String[]{"z","z","z","z","z","z"}, solution("zzzzzz"));
        Assertions.assertArrayEquals(new String[]{"abcdef"}, solution("abcdef"));
        Assertions.assertArrayEquals(new String[]{"abcdef", "abcdef"}, solution("abcdefabcdef"));
        Assertions.assertArrayEquals(new String[]{"aab", "abcdef","aab"}, solution("aababcdefaab"));
        Assertions.assertArrayEquals(new String[]{"a", "b","a","a","b","a","a","b","a"}, solution("abaabaaba"));
        Assertions.assertArrayEquals(new String[]{"a"}, solution("a"));
    }
}
