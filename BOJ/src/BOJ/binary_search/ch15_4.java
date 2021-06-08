package BOJ.binary_search;

import java.util.Arrays;
import java.util.Comparator;

public class ch15_4 {

    public static int[] solution(String[] words, String[] queries){
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) return 1;
                else if (o1.length() < o2.length()) return -1;
                else return o1.compareTo(o2);
            }
        });

        int wordArrLen = words.length;
        int queryArrLen = queries.length;

        int[] answer = new int[queryArrLen];
        for (int i = 0; i < queryArrLen; i++) {
            answer[i] = 0;
        }

        for (int i = 0; i < queryArrLen; i++) {
            int len = queries[i].length(); //원하는 길이
            boolean isFirst = false; //원하는 길이가 배열의 첫번째에 있는 경우 확인
            //초기 탈출 조건
            if (len < words[0].length()) continue;
            if (len == words[0].length()) isFirst = true;
            if (words[wordArrLen - 1].length() < len) continue;

            int start = 0;
            int end = wordArrLen - 1;
            int startIndex = 0;

            if (isFirst){
                start = 1;
                end = 0;
            }

            while (start <= end){
                int mid = (start + end) / 2;
                if (words[mid].length() == len
                    && (mid == 0 || words[mid - 1].length() != len)) {
                    startIndex = mid;
                    break;
                }
                else if (words[mid].length() < len) {
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }

            boolean isPrefix = false;
            String str;
            if (queries[i].lastIndexOf("?") == (queries[i].length() - 1)){
                //접두사
                isPrefix = true;
                str = queries[i].substring(0, queries[i].indexOf("?"));
            }else {
                //접미사
                str = queries[i].substring(queries[i].lastIndexOf("?") + 1);
            }


            for (int j = startIndex; j < wordArrLen; j++) {
                if (words[j].length() != len) break;
                if (isPrefix){
                    if (words[j].startsWith(str)) answer[i]++;
                }else{
                    if (words[j].endsWith(str)) answer[i]++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] words = {"fry", "frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        int [] result = solution(words, queries);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
