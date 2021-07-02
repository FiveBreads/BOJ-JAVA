package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num12951 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String first = s.charAt(0) + "";
        answer.append(first.toUpperCase());

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                answer.append(" ");
            }else if (s.charAt(i - 1) == ' '){
                answer.append((s.charAt(i) + "").toUpperCase());
            }else{
                answer.append((s.charAt(i) + "").toLowerCase());
            }
        }
        return answer.toString();
    }

    @Test
    public void jadenCase_문자열_만들기(){
        Assertions.assertEquals(solution("3people unFollowed me"), "3people Unfollowed Me");
        Assertions.assertEquals(solution("for the last week"), "For The Last Week");
        Assertions.assertEquals(solution("a"), "A");
        Assertions.assertEquals(solution("4"), "4");
        Assertions.assertEquals(solution("9person 8night 4people"), "9person 8night 4people");
        Assertions.assertEquals(solution(" "), " ");
        Assertions.assertEquals(solution("   "), "   ");
        Assertions.assertEquals(solution(" aBc"), " Abc");
        Assertions.assertEquals(solution("a    bc"), "A    Bc");
        Assertions.assertEquals(solution("a b c d"), "A B C D");
    }
}
