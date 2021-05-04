package BOJ.recursion;

import java.util.Scanner;

public class Num11729 {
  //하노이 타워
  static int cnt = 0;
  public static void rec(int num, int from, int by, int to, StringBuilder sb){
    if (num == 0) return;
    rec(num-1, from, to, by, sb); //n-1개의 원판을 가운데로 옮겨 주고
    cnt++;
    sb.append(from)
          .append(" ")
          .append(to)
          .append("\n");
    rec(num-1, by, from, to, sb);//남은 n-1개의 원판을 목적지로 옮겨 준다.
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    StringBuilder sb = new StringBuilder();
    rec(n, 1,2,3, sb);
    System.out.println(cnt);
    System.out.println(sb.toString());
  }
}
