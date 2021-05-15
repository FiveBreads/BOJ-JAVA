package BOJ.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Num5052 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    int[] testCases = new int[t];
    String[][] hpArr = new String[t][];
    for (int i = 0; i < t; i++) {
      testCases[i] = Integer.parseInt(br.readLine());
      hpArr[i] = new String[testCases[i]];
      for (int j = 0; j < hpArr[i].length; j++) {
        hpArr[i][j] = br.readLine();
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      Arrays.sort(hpArr[i]);
      int target = 0;
      while (target < hpArr[i].length){
        String str = hpArr[i][target++];
        for (int j = target; j < hpArr[i].length; j++) {
          if (hpArr[i][j].startsWith(str)){
            target = hpArr[i].length;
            sb.append("NO"+"\n");
            break;
          }
        }
      }
    }
    System.out.println(sb.toString());
  }
}