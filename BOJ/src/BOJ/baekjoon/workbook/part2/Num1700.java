package BOJ.baekjoon.workbook.part2;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by prayzz12@gmail.com on 2021-08-06
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 멀티탭 스케줄링
 * content :
 * link : [https://www.acmicpc.net/problem/1700]
 */
public class Num1700 {
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
}