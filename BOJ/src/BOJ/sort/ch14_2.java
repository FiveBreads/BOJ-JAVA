package BOJ.sort;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class ch14_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);
        int idx = list.size();
        if (list.size() % 2 == 0){
            idx /= 2;
            idx--;
        }else {
            idx /= 2;
        }
        System.out.println(list.get(idx));
    }
}
