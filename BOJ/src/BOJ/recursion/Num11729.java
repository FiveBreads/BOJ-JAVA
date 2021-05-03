package BOJ.recursion;

import java.util.Scanner;

public class Num11729 {
  //하노이 타워
  public static void rec(int num, char from, char by, char to){
    if (num == 1){
      System.out.printf("원반 1을 %c에서 %c로 이동\n", from, to);
    }else{
      rec(num-1, from, to, by); //n-1개의 원판을 가운데로 옮겨 주고
      System.out.printf("원반 %d을 %c에서 %c로 이동\n",num, from, to); //맨 아래 친구를 목적지로 옮겨 주고
      rec(num-1, by, from, to);//남은 n-1개의 원판을 목적지로 옮겨 준다.
    }
  }

  public static void main(String[] args){
    //Scanner sc = new Scanner(System.in);
    //int n = sc.nextInt();
    rec(4, 'A','B','C');
  }
}
