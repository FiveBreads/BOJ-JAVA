package programmers.level2;

public class Num12913 {
    //땅따먹기
    public static int solution(int[][] land) {
        int n = land.length;
        for (int i = 1; i < n; i++) {
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][1], Math.max(land[i-1][0], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][0]));
        }
        return Math.max(land[n-1][0], Math.max(land[n-1][1], Math.max(land[n-1][2], land[n-1][3])));
    }

    public static void main(String[] args) {
        int[][] arr = {
            {4, 3, 2, 1},
            {2, 2, 2, 1},
            {6, 6, 6, 4},
            {8, 7, 6, 5}
        };
        System.out.println(solution(arr));
    }
}
