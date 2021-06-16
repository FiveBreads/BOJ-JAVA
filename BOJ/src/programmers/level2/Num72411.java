package programmers.level2;

import java.util.ArrayList;

public class Num72411 {
//메뉴 리뉴얼
    public static String[] solution(String[] orders, int[] course){
        //97 - 122 (A-Z)
        int alpha = 97;
        for (int i = 0; i < course.length; i++) {
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < orders.length; j++) {
                for (int k = 0; k < orders[j].length(); k++) {
                    if (orders[j].charAt(k) == (char) alpha){
                        list.add(orders[j]);
                        break;
                    }
                }
            }
            dfs(course[i] - 1, alpha + 1, list);
        }
        return null;
    }

    public static void dfs(int depth, int alpha, ArrayList<String> list){
        if (depth == 0){
            //최대값을 계산한다.
            return;
        }
        ArrayList<String> tmpList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                if (list.get(i).charAt(j) == (char) alpha){
                    tmpList.add(list.get(i));
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {

    }
}
