package BOJ.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Num2504 {
  //괄호의 값
  static Stack<String> stk = new Stack<>();

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] data = br.readLine().toCharArray();
    Map<String, String> bracketMap = new HashMap<>();
    bracketMap.put("]", "[");
    bracketMap.put(")", "(");

    Map<String, Integer> valueMap = new HashMap<>();
    valueMap.put("[", 3);
    valueMap.put("(", 2);

    for (int i = 0; i < data.length; i++){
      char c = data[i];
      switch (c){
        case '(':
        case '[':
          stk.push(Character.toString(c));
          break;
        case ']':
        case ')':
          String hopeBracket = bracketMap.get(Character.toString(c));
          if (stk.isEmpty()) {
            System.out.println(0); //초기에 )혹은 ]가 들어왔을 경우 즉시 탈출
            return;
          }
          String popData = stk.pop();
          if (bracketMap.containsValue(popData)){
            //값 치환 연산
            if (popData.equals(hopeBracket)){
              stk.push(String.valueOf(valueMap.get(popData)));
            }else {
              System.out.println(String.valueOf(0));
              return;
            }
          }else {
            //값더하기 연산
            int tmp = Integer.parseInt(popData); //숫자임.
            while (!stk.isEmpty()){
              popData = stk.pop();
              if (popData.equals(hopeBracket)){
                stk.push(String.valueOf(valueMap.get(popData) * tmp));
                break;
              }else if(popData.chars().allMatch(Character::isDigit)){
                tmp += Integer.parseInt(popData);
              }else {
                System.out.println(String.valueOf(0));
                return;
              }
            }
          }
          break;
      }
    }
    int sum = 0;
    while(!stk.isEmpty()){
      if(!stk.peek().chars().allMatch(Character::isDigit)){ //(혹은 [만 들어와서 값 치환이 안된 경우
        System.out.println(0);
        return;
      }
      sum += Integer.parseInt(stk.pop());
    }
    System.out.println(sum);
  }
}
