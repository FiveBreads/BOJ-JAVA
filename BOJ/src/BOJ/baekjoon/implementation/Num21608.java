package BOJ.baekjoon.implementation;

import java.util.*;
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
        private int x = 0;
        private int y = 0;
        private int[] likeFriend;

        public Student(int[] likeFriend) {
            this.likeFriend = likeFriend;
        }
    }

    static int[][] emptyClass;
    static int[][] locationClass;
    static Student[] students;

    static int N;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        emptyClass = new int[N + 1][N + 1];
        locationClass = new int[N + 1][N + 1];

        initEmptyClass();

        int n2 = N * N;
        students = new Student[n2 + 1];
        List<Integer> orderList = new ArrayList<>();

        for (int i = 0; i < n2; i++) {
            int studentIdx = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            students[studentIdx] = new Student(new int[]{a, b, c, d});
            orderList.add(studentIdx);
        }

        for (int i = 0; i < orderList.size(); i++) {
            findFriends(orderList.get(i));
        }

        int answer = 0;
        for (int i = 1; i < students.length; i++) {
            int cnt = 0;
            int[] likeFriend = students[i].likeFriend;
            for (int j = 0; j < 4; j++) {
                int xSub = Math.abs(students[likeFriend[j]].x - students[i].x);
                int ySub = Math.abs(students[likeFriend[j]].y - students[i].y);
                if (xSub + ySub == 1){
                    cnt++;
                }
            }
            switch (cnt){
                case 1:
                    answer += 1;
                    break;
                case 2:
                    answer += 10;
                    break;
                case 3:
                    answer += 100;
                    break;
                case 4:
                    answer += 1000;
            }
        }
        System.out.println(answer);
    }

    static void findFriends(int me){
        int[] friend = students[me].likeFriend;
        int[][] rangeFriends = new int [N + 1][N + 1]; //주변에 친구 있는 장소.
        int maxFriendCnt = 0;
        int x = 0;
        int y = 0;

        for (int i = 0; i < 4; i++) { //내 친구들의 주변 변칸에 1씩 가중치 준다.
            int friendX = students[friend[i]].x;
            int friendY = students[friend[i]].y;
            if (friendX > 0 && friendY > 0){
                updateRange(friendX, friendY, rangeFriends);
            }
        }

        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= N; j++) {
                if (maxFriendCnt < rangeFriends[i][j]) {
                    maxFriendCnt = rangeFriends[i][j];
                    x = i;
                    y = j;
                } else if (maxFriendCnt == rangeFriends[i][j]){
                    if (emptyClass[x][y] < emptyClass[i][j]){
                        x = i;
                        y = j;
                    }
                }
            }
        }
        students[me].x = x;
        students[me].y = y;
        locationClass[x][y] = me;
        subRangeEmpty(x, y);
    }

    static void subRangeEmpty(int x, int y) {
        //학생의 위치로 선정된 책상에 인접한 4곳의 자리가 가지고 있는 주변 빈공간 1씩 빼주기
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx > 0 && nx <= N && ny > 0 && ny <= N) {
                emptyClass[nx][ny]--;
            }
        }
    }

    static void updateRange(int x, int y, int[][] rangeFriends){
        // 해당 위치 주변에 내가 좋아하는 친구가 몇명 있는지 검사.
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx > 0 && nx <= N && ny > 0 && ny <= N && locationClass[nx][ny] == 0) {
                rangeFriends[nx][ny]++;
            }
        }
    }

    static void initEmptyClass(){
        //빈 자리 검사.
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    //배열 범위 밖으로 초과하는지 여부 검사
                    if (nx > 0 && nx <= N && ny > 0 && ny <= N) {
                        emptyClass[i][j]++;
                    }
                }
            }
        }
    }
}
