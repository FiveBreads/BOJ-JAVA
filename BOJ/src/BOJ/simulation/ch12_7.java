package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

class Chicken {
    private int i;
    private int j;
    public Chicken(int i, int j){
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Chicken chicken = (Chicken) o;
        return i == chicken.i && j == chicken.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}

public class ch12_7 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][n+1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Map<Chicken, Integer> chickenStores = new HashMap<>();
        for (int homeI = 0; homeI < n; homeI++) {
            for (int homeJ = 0; homeJ < n; homeJ++) {
                if (map[homeI][homeJ] == 1){
                    int min = 100;
                    for (int chI = 0; chI < n; chI++) {
                        for (int chJ = 0; chJ < n; chJ++) {
                            if (map[chI][chJ] == 2){
                                int sum = Math.abs(chI - homeI) + Math.abs(chJ - homeJ);
                                Chicken chicken = new Chicken(chI,chJ);
                                if (chickenStores.containsKey(chicken)){
                                    int chMin = Math.min(chickenStores.get(chicken), sum);
                                    chickenStores.put(chicken, chMin);
                                } else {
                                    chickenStores.put(chicken, sum);
                                }
                            }
                        }
                    }
                }
            }
        }
        ArrayList<Chicken> chickenArrayList = new ArrayList<>(chickenStores.keySet());
        Collections.sort(chickenArrayList, (value1, value2) -> chickenStores.get(value1).compareTo(chickenStores.get(value2)));
        int result = 0;
        for (int i = 0; i < m; i++) {
            result += chickenStores.get(chickenArrayList.get(i));
        }
        System.out.println(result);
    }
}
