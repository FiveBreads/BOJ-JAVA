package coding_test_2nd.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Teacher{
    private int x;
    private int y;

    public Teacher(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
public class ch13_6 {

    public static int n;
    public static String[][] hallway;
    public static ArrayList<Teacher> teachers = new ArrayList<>();

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static boolean canHide = false;

    public static boolean checkHallway(){
        //감시망 피할 수 있으면 true, 없으면 false;
        for (int j = 0; j < teachers.size(); j++) {
            Teacher teacher = teachers.get(j);
            int x = teacher.getX();
            int y = teacher.getY();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                while(nx >= 0 && nx < n && ny >= 0 && ny < n){
                    if ("S".equals(hallway[nx][ny])){
                        return false;
                    }else if ("T".equals(hallway[nx][ny]) || "O".equals(hallway[nx][ny])){
                        break;
                    }else{
                        nx += dx[i];
                        ny += dy[i];
                    }
                }
            }
        }
        return true;
    }

    public static void dfs(int wall_cnt){
        if (wall_cnt == 3){
           if (checkHallway()){
                canHide = true;
           }
        }else{
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ("X".equals(hallway[i][j])){
                        hallway[i][j] = "O";
                        dfs(wall_cnt + 1);
                        hallway[i][j] = "X";
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        hallway = new String[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                hallway[i][j] = st.nextToken();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ("T".equals(hallway[i][j])){
                    teachers.add(new Teacher(i, j));
                }
            }
        }

        dfs(0);
        if (canHide){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
