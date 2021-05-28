package BOJ.simulation;

public class ch12_3 {

    public static void main(String[] args) {
        String[] str = {"aabbaccc",
            "ababcdcdababcdcd",
            "abcabcdede",
            "abcabcabcabcdededededede",
            "xababcdcdababcdcd"
        };
        for (String s : str) {
            getMinLength(s);
        }
    }

    private static void getMinLength(String str) {
        int len = str.length();
        int min = str.length();
        int half = len / 2;
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= half; i++) { //반복되는 문자열 길이 늘어나는 loop
            String dupStr = str.substring(0, i);
            cnt = 1;
            for (int idx = i; idx < len; idx += i) { //실제 탐색 loop
                if (!str.substring(idx).startsWith(dupStr)){
                    if (cnt > 1){
                        sb.append(cnt);
                    }
                    sb.append(dupStr);
                    cnt = 1;
                    if (idx + i < len){
                        dupStr = str.substring(idx, idx + i);
                    }else {
                        dupStr = str.substring(idx);
                    }
                }else {
                    cnt++;
                }
            }
            if (cnt > 1){
                sb.append(cnt);
            }
            sb.append(dupStr);
            min = Math.min(sb.length(), min);
            sb = new StringBuilder();
        }
        System.out.println(min);
    }
}
