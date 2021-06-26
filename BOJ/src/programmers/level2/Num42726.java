package programmers.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Num42726 {

    public static String solution(int[] numbers) {
        String[] strNum = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNum[i] = String.valueOf(numbers[i]);
        }
        Comparator comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        };
        Arrays.sort(strNum, comp);

        StringBuilder result = new StringBuilder();
        for (String s : strNum) {
            result.append(s);
        }
        if (result.charAt(0) == '0'){
            return "0";
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[] strs = {3, 30, 34, 5, 9};
        System.out.println(solution(strs));
    }
}
