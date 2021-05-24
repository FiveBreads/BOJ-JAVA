package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ch11_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] members = new int[n];
        for (int i = 0; i < members.length; i++) {
            members[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(members);

        int result = 0;
        int count = 0;
        for (int i = 0; i < members.length; i++) {
            count++;
            if (count >= members[i]){
                result++;
                count = 0;
            }
        }
    }
}
