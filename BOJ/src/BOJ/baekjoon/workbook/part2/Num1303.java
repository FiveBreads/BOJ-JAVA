package BOJ.baekjoon.workbook.part2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-08-19
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 전쟁 - 전투
 * content :
 * link : [https://www.acmicpc.net/problem/1303]
 */
public class Num1303 {

    static int n;
    static int m;
    static int [] dx ={0,1,0,-1};
    static int [] dy ={-1,0,1,0}; //상 우 하 좌

    static String [][] map;
    static boolean [][] chk;

    static int white_cnt =0;
    static int black_cnt =0;
    static class Node{
        int y;
        int x;

        public Node(int y, int x){
            this.y=y;
            this.x=x;
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new String[m][n];
        chk = new boolean[m][n];

        for(int i = 0; i<m; i++){
            String line = sc.next();
            for(int j =0; j<n; j++){
                map[i][j] = line.substring(j,j+1);
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!chk[i][j]){
                    if(map[i][j].equals("B")){
                        int num = bfs(i, j, "B");
                        black_cnt += num*num;
                    }else{
                        int num = bfs(i, j, "W");
                        white_cnt += num * num;
                    }

                }
            }
        }
        System.out.println(white_cnt + " " + black_cnt);
    }

    public static int bfs(int y, int x, String color){
        Queue<Node> queue  = new LinkedList<>();
        queue.add(new Node(y,x));
        int cnt =1;
        chk[y][x] = true;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            for(int i = 0; i < 4; i++){
                int now_y = now.y + dy[i];
                int now_x = now.x + dx[i];
                if(now_y >= 0 && now_y < m && now_x >= 0 && now_x < n){
                    if(!chk[now_y][now_x] && color.equals(map[now_y][now_x])){
                        queue.add(new Node(now_y,now_x));
                        chk[now_y][now_x] = true;
                        cnt++;
                    }
                }

            }
        }
        return cnt;
    }
}
