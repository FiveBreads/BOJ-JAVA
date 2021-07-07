package programmers.level2;

import java.util.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num12909 {
    boolean solution(String s) {

        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stk.push('(');
            else {
                if (!stk.isEmpty() && stk.peek() == '(') stk.pop();
                else return false;
            }
        }
        if (stk.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    @Test
    void 올바른_괄호(){
        Assertions.assertEquals(true, solution("()()"));
        Assertions.assertEquals(true, solution("(())()"));
        Assertions.assertEquals(false, solution(")()("));
        Assertions.assertEquals(false, solution("(()("));
    }
}
