package codility;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Task1 {

    public static int solution(int N){
        StringBuilder sb = new StringBuilder();
        while (N > 0){
            sb.insert(0,N % 2);
            N /= 2;
        }

        ArrayList<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '1'){
                indexList.add(i);
            }
        }

        if (indexList.size() <= 1 || indexList.size() == sb.length()) return 0;

        int max = 0;
        for (int i = 1; i < indexList.size(); i++) {
            max = Math.max(max, indexList.get(i) - indexList.get(i-1));
        }
        return max - 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(1041));
    }
}
