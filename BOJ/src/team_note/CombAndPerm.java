package team_note;

public class CombAndPerm {

    static String str = "abcdef";
    static int r = 3;
    static int n = 6;

    static boolean[] visit = new boolean[n];

    public static void dfs(int cnt, StringBuilder stringBuilder){
        if (cnt == n){
            System.out.println(stringBuilder.toString());
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            //if (visit[i]) continue; 중복이 없는경우 주석처리하면 된다.
            visit[i] = true;
            dfs(cnt + 1, stringBuilder.append(str.charAt(i)));
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) {
        dfs(0, new StringBuilder());
    }
}
