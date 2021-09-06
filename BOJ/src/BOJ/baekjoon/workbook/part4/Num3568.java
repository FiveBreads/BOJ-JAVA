package BOJ.baekjoon.workbook.part4;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-09-06
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : iSharp
 * content : 시뮬레이션
 * link : [https://www.acmicpc.net/problem/3568]
 */
public class Num3568 {

    static LinkedHashMap<String, Integer> makeClone(LinkedHashMap<String, Integer> map){
        LinkedHashMap<String, Integer> clone = new LinkedHashMap<>();
        for (Entry<String, Integer> entry : map.entrySet()) {
            clone.put(entry.getKey(), entry.getValue());
        }
        return clone;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder builder = new StringBuilder(sc.nextLine());

        //0번째 배열에 있는 공통 변수형에서 값 추출.
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("&", 0);
        map.put("[]", 0);
        map.put("*", 0);

        int index = builder.indexOf(" ");
        //공통 변수형의 타입들 추출
        StringBuilder commonVar = new StringBuilder();
        for (int i = 0; i < index; i++) {
            if (Character.isAlphabetic(builder.charAt(i))){
                commonVar.append(builder.charAt(i));
            }else{
                map.put(builder.charAt(i) + "", map.get(builder.charAt(i) + "") + 1);
            }
        }

        //index 지나가며 변수 제작
        StringBuilder var = new StringBuilder();
        LinkedHashMap<String, Integer> instanceMap = makeClone(map);
        for (int i = index + 1; i < builder.length(); i++) {
            char charAt = builder.charAt(i);
            if (charAt == ' ') {
                //새로운 변수가 생긴것. 값을 초기화 하자.
                var = new StringBuilder();
                instanceMap = makeClone(map);
            }else if (charAt == ',' || charAt == ';'){
                //종료되었음 이시점에서 값으로 출력
                StringBuilder result = new StringBuilder();
                result.append(commonVar.toString());
                for (Entry<String, Integer> entry : instanceMap.entrySet()) {
                    if (entry.getValue() > 0){
                        for (int j = 0; j < entry.getValue(); j++) {
                            result.append(entry.getKey());
                        }
                    }
                }
                result.append(" ")
                    .append(var.toString())
                    .append(";");
                System.out.println(result);

            }else if (Character.isAlphabetic(charAt)){
                //변수 명임 추가해주자.
                var.append(charAt);
            }else if (charAt == '*' || charAt == '&'){
                instanceMap.put(charAt + "", instanceMap.get(charAt + "") + 1);
            }else { // charAt == '['
                instanceMap.put("[]", instanceMap.get("[]") + 1);
                i++;
            }
        }
    }
}
