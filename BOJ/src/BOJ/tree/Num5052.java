package BOJ.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Num5052 {

  static boolean isConsistent(int N, String[] phone_number) {
    for (int i = 0; i < N - 1; i++) {
      if (phone_number[i+1].startsWith(phone_number[i])) return false;
      if (phone_number[i].startsWith(phone_number[i+1])) return false;
    }
    return true;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    while (t-- > 0) {
      int N = Integer.parseInt(br.readLine());
      String[] phone_number = new String[N]; // 전화번호 목록.
      for (int i = 0; i < N; i++) {
        phone_number[i] = br.readLine();
      }
      Arrays.sort(phone_number); // 오름차순으로 정렬.

      if (isConsistent(N, phone_number)) {
        sb.append("YES" + "\n");
      } else {
        sb.append("NO" + "\n");
      }
    }
    System.out.println(sb.toString());
  }
}