package programmers.level2;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num17687 {
    public String solution(int n, int t, int m, int p) {
        Map<Integer, Character> convertMap = new HashMap<>();
        char alpha = 'A';
        for (int i = 0; i < 6; i++) {
            convertMap.put(i+10, (char) (alpha + i));
        }

        StringBuilder totStr = new StringBuilder().append("0");
        int maxLen = p + (m * t);

        int i = 1;
        StringBuilder builder;
        while (totStr.length() < maxLen){
            int tmp = i;
            builder = new StringBuilder();
            while (tmp != 0){
                int conData = tmp % n;
                if (convertMap.containsKey(conData)){
                    builder.insert(0,convertMap.get(conData));
                }else{
                    builder.insert(0,conData);
                }
                tmp /= n;
            }
            totStr.append(builder.toString());
            i++;
        }

        builder = new StringBuilder();
        i = 0;
        while (i < t){
            int index = m * i + p - 1;
            builder.append(totStr.charAt(index));
            i++;
        }
        return builder.toString();
    }

    @Test
    void n진수_게임(){
        Assertions.assertEquals("0111",solution(2,4,2,1));
        Assertions.assertEquals("02468ACE11111111",solution(16,16,2,1));
        Assertions.assertEquals("13579BDF01234567",solution(16,16,2,2));
    }
}
