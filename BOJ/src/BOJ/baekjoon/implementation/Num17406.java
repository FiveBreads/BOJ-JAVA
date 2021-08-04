package BOJ.baekjoon.implementation;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-08-04
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 배열 돌리기 4
 * content :
 * link : [https://www.acmicpc.net/problem/17406]
 */
public class Num17406 {

    static class Rotation{
        private int r;
        private int c;
        private int s;

        public Rotation(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }

    static int n, m, k;
    static int MIN;
    static boolean[] visit;
    static Rotation[] rotations;
    static int[][] map;

    static ArrayList<ArrayList<Rotation>> rotationList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //배경 입력 받기
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        map = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        //필요한 기본 값 설정
        visit = new boolean[k];
        rotations = new Rotation[k];
        MIN = Integer.MAX_VALUE;

        //회전 정보 입력
        for (int i = 0; i < k; i++) {
            rotations[i] = new Rotation(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        //회전 경우의 수 조합 리스트 초기화
        rotationList = new ArrayList<>();

        //회전 경우의 수 계산.
        for (int i = 0; i < k; i++) {
            visit[i] = true;
            ArrayList<Rotation> rotationRoad = new ArrayList<>();
            rotationRoad.add(rotations[i]);
            createRotationRoad(rotationRoad);
            visit[i] = false;
        }

        //조합의 수 만큼 최소값 찾기 시작
        for (ArrayList<Rotation> list : rotationList) {
            findMin(list);
        }
        System.out.println(MIN);
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


    static void createRotationRoad(ArrayList<Rotation> rotationRoad) {
        if (rotationRoad.size() == k){
            rotationList.add(rotationRoad);
            return;
        }
        for (int i = 0; i < k; i++) {
            if (visit[i]) continue; //이미 방문한 경우 제외
            visit[i] = true;
            rotationRoad.add(rotations[i]); //경우의 수 추가
            createRotationRoad(rotationRoad);
            rotationRoad.remove(rotationRoad.size() - 1); //다음 순서를 위해 제거
            visit[i] = false;
        }
    }

    static void findMin(ArrayList<Rotation> rotationRoad){
        //하나의 조합마다 처음에서 회전을 진행해야 하기 때문에 복사된 배열 사용
        int[][] tmpMap = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                tmpMap[i][j] = map[i][j];
            }
        }

        //하나의 조합에서 순서대로 회전 정보 꺼내서 최소 최대값 설정
        for (int i = 0; i < rotationRoad.size(); i++) {
            Rotation rotation = rotationRoad.get(i);
            int leftMin = rotation.r - rotation.s;
            int leftMax = rotation.r + rotation.s;
            int rightMin = rotation.c - rotation.s;
            int rightMax = rotation.c + rotation.s;

            //4개의 변수는 각각 x의 최대 최소, y의 최대 최소 이다.
            //(leftMin, rightMin)   (leftMin, rightMax)
            //(leftMax, rightMin)   (leftMax, rightMax)

            while (leftMin < leftMax && rightMin < rightMax){ //좌상단의 위치와 우하단의 위치가 같아지거나 작아지는 순간 회전 종료

                int tmp = tmpMap[leftMin][rightMin];

                //시계 방향 회전전
                //  ㅅ
                //  |
                for (int j = leftMin; j < leftMax; j++) {
                    tmpMap[j][rightMin] = tmpMap[j + 1][rightMin];
                }

                // <--
                for (int j = rightMin; j < rightMax; j++) {
                    tmpMap[leftMax][j] = tmpMap[leftMax][j + 1];
                }

                //  |
                //  V
                for (int j = leftMax; j > leftMin; j--) {
                    tmpMap[j][rightMax] = tmpMap[j - 1][rightMax];
                }

                // -->
                for (int j = rightMax; j > rightMin; j--) {
                    tmpMap[leftMin][j] = tmpMap[leftMin][j - 1];
                }

                tmpMap[leftMin][rightMin + 1] = tmp;
                leftMin++;
                rightMin++;
                leftMax--;
                rightMax--;
            }
        }
        setMin();
    }

    static void setMin(){
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= m; j++) {
                sum += map[i][j];
            }
            MIN = Math.min(MIN, sum);
        }
    }
}
