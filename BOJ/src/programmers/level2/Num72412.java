package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class Num72412 {

    //순위 검색
    public static HashMap<String, ArrayList<Integer>> dataMap = new HashMap<>();

    public static int[] solution(String[] info, String[] query) {
        for (int i = 0; i < info.length; i++) {
            makeKey(info[i]);
        }

        for (String s : dataMap.keySet()) {
            ArrayList<Integer> list = dataMap.get(s);
            Collections.sort(list);
        }
        int[] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            String[] one = query[i].split(" ");
            StringBuilder sb = new StringBuilder();
            sb.append(one[0]).append(one[2]).append(one[4]).append(one[6]);
            if (!dataMap.containsKey(sb.toString())){
                answer[i]=0;
                continue;
            }
            ArrayList<Integer> integers = dataMap.get(sb.toString());
            if("-".equals(one[7])){
                answer[i] = integers.size();
            }else {
                int grade = Integer.parseInt(one[7]);
                answer[i] = binarySearch(integers, grade);
            }
        }
        return answer;
    }

    public static void makeKey(String info){
        String[] datas = info.split(" ");
        String[] language = {datas[0], "-"};
        String[] position = {datas[1], "-"};
        String[] career = {datas[2], "-"};
        String[] soul_food = {datas[3], "-"};
        int grade = Integer.parseInt(datas[4]);
        StringBuilder sb;
        for (int i = 0; i < language.length; i++) {
            for (int j = 0; j < position.length; j++) {
                for (int k = 0; k < career.length; k++) {
                    for (int l = 0; l < soul_food.length; l++) {
                        sb = new StringBuilder();
                        sb.append(language[i])
                            .append(position[j])
                            .append(career[k])
                            .append(soul_food[l]);
                        ArrayList<Integer> infoArr;
                        if (dataMap.containsKey(sb.toString())){
                            infoArr = dataMap.get(sb.toString());
                        }else{
                            infoArr = new ArrayList<>();
                        }
                        infoArr.add(grade);
                        dataMap.put(sb.toString(), infoArr);
                    }
                }
            }
        }
    }

    public static int binarySearch(ArrayList<Integer> integers, int target){
        int start = 0;
        int end = integers.size() - 1;
        int mid = 0;
        while (start < end){
            mid = (start + end) / 2;
            if (integers.get(mid) >= target){
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return integers.size() - start;
    }



    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int[] result = solution(info, query);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
