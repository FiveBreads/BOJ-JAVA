package BOJ.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1074 {
  private static int r;
  private static int c;
  private static int n;
  private static int cnt = 0;
  private static int res = 0;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    int num = (int) Math.pow(2,n);
    dfs(num, 0, 0);
    System.out.println(res);
  }

  private static void dfs(int num, int x, int y) {
    if (y == r && x == c){
      res = cnt;
    }
    if (num == 1){
      cnt++;
      return;
    }
    if(!(y<=r && r<y+num && x<=c && c<x+num)){
      cnt += num*num;
      return;
    }
    int half = num / 2;
    dfs(half, x, y);
    dfs(half, x + half, y);
    dfs(half, x, y + half);
    dfs(half, x + half, y + half);
  }
}