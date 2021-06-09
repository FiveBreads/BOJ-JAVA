package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ch16_6 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder A = new StringBuilder(br.readLine());
        StringBuilder B = new StringBuilder(br.readLine());

        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)){
                int idx = B.indexOf(A.charAt(i) + "");
                if (idx == -1){
                    
                    boolean isEqual = true;
                    for (int j = 0; j < i; j++) {
                        if (A.charAt(i) != B.charAt(i)){
                            isEqual = false;
                        }
                    }
                    for (int j = i+1; j < A.length(); j++) {

                    }
                    A.deleteCharAt(i);
                    count++;
                }else if (idx > i){
                    String str = B.substring(i, idx);
                    A.insert(i, str);
                    count += str.length();
                }else if (idx == i){
                    A.replace(i, i+1, B.charAt(i) + "");
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
