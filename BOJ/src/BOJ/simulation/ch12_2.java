package BOJ.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ch12_2 {

    public static void main(String[] args) {
        String[] str = {"K1KA5CB7", "AJKDLSI412K4JSJ9D"};
        for (String s : str) {
            strSort(s);
        }
    }

    private static void strSort(String str) {
        ArrayList<Character> alpha = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int data = str.charAt(i) - '0';
            if (data >= 0 && data <= 9){
                sum += data;
            }else {
                alpha.add(str.charAt(i));
            }
        }
        alpha.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alpha.size(); i++) {
            sb.append(alpha.get(i));
        }
        if (sum > 0){
            sb.append(sum);
        }
        System.out.println(sb.toString());
    }
}
