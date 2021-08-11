package team_note;
/**
 * Created by prayzz12@gmail.com on 2021-08-11
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : KMP알고리즘
 * content : 문자열 비교 O(N)
 * link : [https://www.acmicpc.net/problem/]
 */
public class KMP {

    static int[] pi;

    static int kmp(String target, String str){
        int idx = 0;
        for (int targetIdx = 0; targetIdx < target.length(); targetIdx++) {
            while (target.charAt(targetIdx) != str.charAt(idx) && idx > 0){
                idx = pi[idx - 1];
            }
            if (target.charAt(targetIdx) == str.charAt(idx)){
                idx++;
            }
            if (idx >= str.length()) return 1;
        }
        return 0;
    }

    static int[] getIterInfo(String str){
        int[] iterArr = new int[str.length()];
        int idx = 0;
        for (int i = 1; i < str.length(); i++) {
            while (str.charAt(i) != str.charAt(idx) && idx > 0){ //반복이 끝났다.
                idx = iterArr[idx - 1];
            }
            if (str.charAt(i) == str.charAt(idx)){
                idx++;
                iterArr[i] = idx;
            }
        }
        return iterArr;
    }
}
