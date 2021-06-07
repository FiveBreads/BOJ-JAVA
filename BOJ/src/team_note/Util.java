package team_note;

public class Util {

    // 최솟값과 최댓값 초기화
    static int minValue = (int) 1e9;
    static int maxValue = (int) -1e9;

    //상하좌우 방향 설정
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int n;

    static void move(int x, int y){

        //방향 이동
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            //배열 범위 밖으로 초과하는지 여부 검사
            if (nx > 0 && nx <= n && ny > 0 && ny <= n) {

            }
        }
    }
}
