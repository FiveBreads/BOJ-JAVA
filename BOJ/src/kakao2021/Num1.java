package kakao2021;

import java.util.HashMap;
import java.util.Map;

public class Num1 {
  static Map<String, Integer> numMap = new HashMap<>();

  public void setMap(){
    numMap.put("zero", 0);
    numMap.put("one", 1);
    numMap.put("two", 2);
    numMap.put("three", 3);
    numMap.put("four", 4);
    numMap.put("five", 5);
    numMap.put("six", 6);
    numMap.put("seven", 7);
    numMap.put("eight", 8);
    numMap.put("nine", 9);
  }

  public int solution(String s) {
    this.setMap();
    StringBuilder sb = new StringBuilder(s);
    for(String str : numMap.keySet()){
      int start = 0;
      int length = str.length();
      while(sb.toString().contains(str)){
        int from = sb.toString().indexOf(str, start);
        sb.replace(from,from+length, String.valueOf(numMap.get(str)));
      }
    }
    int answer = 0;
    answer = Integer.parseInt(sb.toString());
    return answer;
  }
  public static void main(String[] args){
    Num1 num1 = new Num1();
    String str = "123";
    System.out.println(num1.solution(str));
  }
}
