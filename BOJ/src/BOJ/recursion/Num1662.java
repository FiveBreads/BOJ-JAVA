package BOJ.recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Num1662 {
  //압축
  static char[] data;
  static Map<Integer, Integer> openClose = new HashMap<>();

  public static int rec(int start, int end){
    int strLen = 0;
    for (int i = start; i < end; i++) {
      if (data[i] == '('){
        int mul = data[i - 1] - '0';
        strLen += mul * rec(i + 1, openClose.get(i)) - 1;
        i = openClose.get(i);
      }else {
        strLen++;
      }
    }
    return strLen;
  }

  public static void main(String[] args){
    //3 3(56 2(7 1(9) ) )
    Scanner sc = new Scanner(System.in);
    Stack<Integer> stack = new Stack<>();
    data = sc.nextLine().toCharArray(); // 입력받은 데이터를 문자 배열에 저장한다.
    for (int i = 0; i < data.length; i++) {
      if (data[i] == '(') stack.push(i); // 여는 괄호의 경우 INDEX를 스택에 저장한다.
      else if (data[i] == ')') openClose.put(stack.pop(), i); // 닫는 괄호가 나오면, 여는 괄호의 INDEX를 KEY로 하고 닫는 괄호의 INDEX를 VALUE로 MAP에 저장한다.
    }
    int result = rec(0, data.length);
    System.out.println(String.valueOf(result));
  }
}
