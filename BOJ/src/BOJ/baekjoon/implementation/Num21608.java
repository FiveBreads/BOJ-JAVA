package BOJ.baekjoon.implementation;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-07-26
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 상어 초등학교
 * content :
 * link : [https://www.acmicpc.net/problem/21608]
 */
public class Num21608 {

    static class Student{
        private int x;
        private int y;
        private int[] friends;

        public Student(int[] friends) {
            this.x = -1;
            this.y = -1;
            this.friends = friends;
        }
    }

    static int N;
    static int[][] emptyCntMap;
    static int[][] classMap;
    static LinkedHashMap<Integer, Student> relation;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void find(Entry<Integer, Student> entry){
        int[][] tmpMap = new int[N][N];

        Student value = entry.getValue();
        int[] friends = value.friends;

        for (int i = 0; i < 4; i++) {
            Student likeFriend = relation.get(friends[i]);
            if (likeFriend.x >= 0 && likeFriend.y >= 0){
                for (int j = 0; j < 4; j++) {
                    int nx = likeFriend.x + dx[j];
                    int ny = likeFriend.y + dy[j];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && classMap[nx][ny] == 0) {
                        tmpMap[nx][ny]++;
                    }
                }
            }
        }
        int x = 0;
        int y = 0;
        int max = 0;
        int emptyMax = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((max < tmpMap[i][j]) || (max == tmpMap[i][j] && emptyMax < emptyCntMap[i][j])){
                    x = i;
                    y = j;
                    max = tmpMap[i][j];
                    emptyMax = emptyCntMap[i][j];
                }
            }
        }
        value.x = x;
        value.y = y;
        classMap[x][y] = entry.getKey();
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                emptyCntMap[nx][ny]--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int n2 = N * N;
        emptyCntMap = new int[N][N];
        fillEmptyCntMap();

        classMap = new int[N][N];
        relation = new LinkedHashMap<>();

        for (int i = 0; i < n2; i++) {
            int student = sc.nextInt();
            int[] like = new int[4];
            for (int j = 0; j < 4; j++) {
                like[j] = sc.nextInt();
            }
            relation.put(student, new Student(like));
        }

        Map<Integer, Integer> pointMap = new HashMap<>();
        pointMap.put(0, 1);
        pointMap.put(1, 1);
        pointMap.put(2, 10);
        pointMap.put(3, 100);
        pointMap.put(4, 1000);

        for (Entry<Integer, Student> entry : relation.entrySet()) {
            find(entry);
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = 0;
                Student student = relation.get(classMap[i][j]);
                for (int k = 0; k < 4; k++) {
                    Student friend = relation.get(student.friends[k]);
                    if (Math.abs(student.x - friend.x)
                        + Math.abs(student.y - friend.y) == 1){
                        cnt++;
                    }
                }
                result += pointMap.get(cnt);
            }
        }
        System.out.println(result);
    }

    private static void fillEmptyCntMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        emptyCntMap[i][j]++;
                    }
                }
            }
        }
    }
}
