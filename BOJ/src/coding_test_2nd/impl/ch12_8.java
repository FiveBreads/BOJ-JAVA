package coding_test_2nd.impl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

class BoardEdge implements Comparable<BoardEdge>{
    private int boardA;
    private int boardB;
    private int value;

    public BoardEdge(int boardA, int boardB, int value) {
        this.boardA = boardA;
        this.boardB = boardB;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int getBoardA() {
        return boardA;
    }

    public int getBoardB() {
        return boardB;
    }

    @Override
    public int compareTo(BoardEdge o) {
        if (this.value > o.value){
            return -1;
        }
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BoardEdge boardEdge = (BoardEdge) o;
        return boardA == boardEdge.boardA && boardB == boardEdge.boardB;
    }

    @Override
    public int hashCode() {
        return Objects.hash(boardA, boardB);
    }
}
public class ch12_8 {

    public static int weekCnt;
    public static int[] group;

    public static int find(int n){
        if (group[n] != n){
            return group[n] = find(group[n]);
        }
        return group[n];
    }

    public static void union (int a, int b){
        a = find(a);
        b = find(b);
        if (a > b){
            group[b] = a;
        }else{
            group[a] = b;
        }
    }

    public static int nextWeekIndex(int index){
        index++;
        if (index == weekCnt){
            index = 0;
        }
        return index;
    }

    public static int previousWeekIndex(int index){
        index--;
        if (index < 0){
            index = weekCnt - 1;
        }
        return index;
    }

    public static int solution(int n, int[] week, int[] dist){
        ArrayList<BoardEdge> list = new ArrayList<>();

        for (int i = 1; i < week.length; i++) {
            list.add(new BoardEdge(i-1, i, week[i] - week[i - 1]));
        }
        list.add(new BoardEdge(0, week.length - 1, (n - week[week.length - 1]) + week[0]));

        group = new int[week.length];
        for (int i = 0; i < group.length; i++) {
            group[i] = i;
        }

        Collections.sort(list);
        BoardEdge edge = list.get(0);
        union(edge.getBoardA(), edge.getBoardB());


        return 0;
    }

    public static void main(String[] args) {

    }
}
