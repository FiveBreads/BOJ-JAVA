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

    public static int[] nextPermute(int[] nums){
        //배열을 복사한다.
        int[] copies = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copies[i] = nums[i];
        }

        int idx = -1; //시작 인덱스는 없다는 것을 의미하는 -1
        for (int i = 0; i < copies.length - 1; i++) {
            if (copies[i] < copies[i + 1]) {
                idx = i;
            }
        }
        if (idx < 0) {
            //Last Permutation
            return null;
        }
        for (int i = copies.length - 1; i > idx; i--) {
            if (copies[idx] < copies[i]) { //스왑 후 종료
                int tmp = copies[idx];
                copies[idx] = copies[i];
                copies[i] = tmp;
                break;
            }
        }
        for (int i = idx + 1; i < (copies.length + idx + 1) / 2; i++) {
            int tmp = copies[i];
            copies[i] = copies[copies.length - (i - idx)];
            copies[copies.length - (i - idx)] = tmp;
        }
        return copies;
    }

    public static void main(String[] args) {
        //dfs(0, new StringBuilder());
        nextPermute(new int[]{2, 5, 1, 9, 7});
    }
}
