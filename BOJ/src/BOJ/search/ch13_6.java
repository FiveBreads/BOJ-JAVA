package BOJ.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch13_6 {

    static int n;
    static String[][] school;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean dfs (int objCnt, int x, int y){
        if (objCnt == 3){
            if (monitoringStudent()){
                return true;
            }
        }else {
            //map에다가 장애물설치
            for (int i = x; i < n; i++) {
                for (int j = y; j < n; j++) {
                   if ("X".equals(school[i][j])){
                       school[i][j] = "O";
                       if (dfs(objCnt+1, i, j+1)){
                           return true;
                       };
                       school[i][j] = "X";
                   }
                }
                y = 0;
            }
        }
        return false;
    }

    static boolean monitoringStudent(){
        //선생님 위치 찾고
        //선생님의 상하좌우로 쭉 뻗어나가는 중에 범위밖인경우, 선생님이 있는경우, 장애물 있는경우 true;
        //학생이 있는경우 false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ("T".equals(school[i][j])){
                    for (int k = 0; k < 4; k++) {
                        int nx = i;
                        int ny = j;
                        while (true){
                            nx += dx[k];
                            ny += dy[k];
                            if (nx < 0 || ny < 0 || nx >= n || ny >= n
                                || "T".equals(school[nx][ny])
                                || "O".equals(school[nx][ny])) break;
                            else if ("X".equals(school[nx][ny])) continue;
                            else return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        school = new String[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                school[i][j] = st.nextToken();
            }
        }
        if (dfs(0, 0, 0)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }
}
