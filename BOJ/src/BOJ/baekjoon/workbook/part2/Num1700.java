package BOJ.baekjoon.workbook.part2;

import java.util.*;

/**
 * Created by prayzz12@gmail.com on 2021-08-06
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 멀티탭 스케줄링
 * content :
 * link : [https://www.acmicpc.net/problem/1700]
 */
public class Num1700 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] order = new int[k];
        for (int i = 0; i < k; i++) {
            order[i] = sc.nextInt();
        }
        int answer = 0;
        LinkedList<Integer> multitap = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            int device = order[i];
            if (multitap.indexOf(device) >= 0) continue;
            else {
                if (multitap.size() < n) multitap.add(device);
                else{
                    // 현재 멀티탭에 꽂힌 녀석들 중 가장 나중에 등장하는 녀석을 찾는다.
                    // 다음번 순서부터 끝까지 돌면서 현재 멀티탭에 있는 애를 순서대로 지워간다.
                    // 종료가 되는 시점은 두가지 경우. 멀티탭에 남아있는 애가 하나일 경우.
                    // 혹은 멀티탭에 여러개가 남아있는데 order 끝까지 간 경우.
                    // 멀티탭에 여러개가 남아있는데 order의 순번이 끝까지 가게 된다면 현재 멀티탭에 꽂힌 애들중 n개가 앞으로 다시는 등장하지 않는다는 뜻이다.
                    // 그렇기 때문에 어떤 녀석을 제거해도 상관은 없다.
                    // 하지만 순서가 다 지나기 전에 멀티탭에 한개가 남은 경우에는 그 남은 녀석이 가장 나중에 등장한다는 뜻이기 때문에 남은 마지막이 대상이 된다.
                    int nextOrderIndex = i + 1;
                    LinkedList<Integer> list = new LinkedList<>();
                    list.addAll(multitap);
                    while ((list.size() > 1) && (nextOrderIndex < k)){
                        list.remove((Object) order[nextOrderIndex]);
                        nextOrderIndex++;
                    }
                    int index = multitap.indexOf(list.getFirst());
                    multitap.set(index, device);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}

// 1회차 풀이
/*
// 1. 멀티탭에 이미 내가 있다. 그러면 아무고토 안함.
    // 2. 멀티탭에 내가 없다.
    //  2.1 자리가 있다.
    //      나를 넣는다.
    //  2.2 자리가 없다.
    //      가장 나중에 등장하는 장비 자리를 내가 차지한다.
    static public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] order = new int[k];
        for (int i = 0; i < k; i++) {
            order[i] = sc.nextInt();
        }

        int answer = 0;

        LinkedList<Integer> multiTap = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            int device = order[i]; //현재 순번의 장비
            int index = multiTap.indexOf(device);
            if (index >= 0) continue; //멀티탭에 내가 있을경우
            else{
                if (multiTap.size() < n) multiTap.add(device); // 멀티탭에 자리가 있다
                else { //멀티탭에 자리가 없다.
                    LinkedList<Integer> list = new LinkedList<>();
                    list.addAll(multiTap);

                    int nextDeviceOrder = i + 1; //현재 순서 다음번
                    while ((nextDeviceOrder < k) && (list.size() > 1)){
                        list.remove(order[nextDeviceOrder]);
                        nextDeviceOrder++;
                    }

                    //list.getFirst() -> 마지막에 등장하는 장비번호
                    //현재 멀티탭에서 마지막에 등장하는 장비 번호를 가지고 해당 멀티탭 위치를 찾는다.
                    index = multiTap.indexOf(list.getFirst()); //제거 과정을 지나고 나면 list에는 앞으로 등장하지 않을 값들만 남아있거나 혹은 마지막에 등장하는 값 하나만 남아있다. 따라서 뭐든 상관없다.
                    multiTap.set(index, device);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
* */