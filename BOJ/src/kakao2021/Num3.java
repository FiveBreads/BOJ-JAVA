package kakao2021;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Num3 {
  public String solution(int n, int k, String[] cmd) {
    Stack<Integer> index = new Stack<>();
    Stack<Integer> value = new Stack<>();
    List<Integer> dataList = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      dataList.add(i);
    }
    
    for (int i = 0; i < cmd.length; i++){
      char c = cmd[i].charAt(0);
      String[] strs;
      switch (c){
        case 'U':
          strs = cmd[i].split(" ");
          k -= Integer.parseInt(strs[1]);
          break;
        case 'D':
          strs = cmd[i].split(" ");
          k += Integer.parseInt(strs[1]);
          break;
        case 'C':
          value.push(dataList.get(k));
          index.push(k);
          dataList.remove(k);
          if (k == dataList.size()) k--;
          break;
        case 'Z':
          int zIndex = index.pop();
          int zValue = value.pop();
          dataList.add(zIndex, zValue);
          if (zIndex <= k) k++;
          break;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append("X");
    }
    char[] res = sb.toString().toCharArray();
    for (int i = 0; i < dataList.size(); i++) {
      res[dataList.get(i)] = 'O';
    }
    return String.valueOf(res);
  }

  public static void main(String[] args){
    Num3 num3 = new Num3();
    int n = 8;
    int k = 2;
    String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
    System.out.println(num3.solution(n,k,cmd));
  }
}
