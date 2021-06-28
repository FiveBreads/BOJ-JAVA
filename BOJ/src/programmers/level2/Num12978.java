package programmers.level2;

public class Num12978 {

    public int solution(int N, int[][] road, int K) {
        int[][] map = new int[N + 1][N + 1];
        int INF = (int) 1e9;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                map[i][j] = INF;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) map[i][j] = 0;
            }
        }

        for (int i = 0; i < road.length; i++) {
            map[road[i][0]][road[i][1]] = Math.min(map[road[i][0]][road[i][1]], road[i][2]);
            map[road[i][1]][road[i][0]] = Math.min(map[road[i][1]][road[i][0]], road[i][2]);
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (map[1][i] != INF && map[1][i] <= K) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
