package BOJ.baekjoon.data_structure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by prayzz12@gmail.com on 2021-07-23
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 부품 대여장
 * content : Map, LocalTime, ChronoUnit
 * link : [https://www.acmicpc.net/problem/21942]
 */
public class Num21942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int penalty = Integer.parseInt(input[2]); // 분당 벌금 비용

        String[] ddMMhh = input[1].split("/");
        int days = Integer.parseInt(ddMMhh[0]); //대여 가능 기간

        String[] hhmm = ddMMhh[1].split(":");
        long total_min = (days * 1440) + (Integer.parseInt(hhmm[0]) * 60) + Integer.parseInt(hhmm[1]); //최대 사용 가능 분

        Map<String, String[]> note = new HashMap<>(); // 진행상황 기록
        Map<String, Double> resultMap = new HashMap<>(); // 벌금 내역 기록
        StringBuilder key, start_date, end_Date;
        String[] data;

        for (int i = 0; i < N; i++) {
            /*
            * data[0] -> yyyy-MM-dd
            * data[1] -> hh:mm
            * data[2] -> 장비 이름
            * data[3] -> 대여자 이름
            * */
            data = br.readLine().split(" ");
            key = new StringBuilder().append(data[2]).append("_").append(data[3]); // key는 장비이름_대여자이름
            if (note.containsKey(key.toString())){ //동일인물이 같은 장비를 빌린적이 있다.
                String[] before = note.get(key.toString());

                start_date = new StringBuilder()
                    .append(before[0])
                    .append("T")
                    .append(before[1])
                    .append(":00");

                end_Date = new StringBuilder()
                    .append(data[0])
                    .append("T")
                    .append(data[1])
                    .append(":00");

                double between = ChronoUnit.MINUTES.between(LocalDateTime.parse(start_date.toString()), LocalDateTime.parse(end_Date.toString()));
                between -= total_min;
                if (between > 0){
                    between *= penalty;
                    resultMap.put(data[3], resultMap.getOrDefault(data[3], (double) 0) + between);
                    note.remove(key.toString());
                }
            }else{
                note.put(key.toString(), data);
            }
        }

        if (resultMap.size() == 0){
            System.out.println(-1);
        }else{
            List<Entry<String, Double>> entries = new LinkedList<>(resultMap.entrySet());
            Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
            StringBuilder answer = new StringBuilder();
            for (Entry<String, Double> entry : entries) {
                answer.append(entry.getKey())
                    .append(" ")
                    .append(String.format("%.0f",entry.getValue()))
                    .append("\n");
            }
            System.out.println(answer.toString());
        }
    }
}
/*static class Rental{
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private String part;
        private String lender;

        public Rental(String startDate, String part, String lender, int days, LocalTime time) {
            this.startDate = LocalDateTime.parse(startDate);
            this.endDate = LocalDateTime.parse(startDate)
                .plusDays(days)
                .plusHours(time.getHour())
                .plusMinutes(time.getMinute());
            this.part = part;
            this.lender = lender;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int penalty = Integer.parseInt(input[2]); // 분당 벌금 비용

        String[] ddMMhh = input[1].split("/");
        int days = Integer.parseInt(ddMMhh[0]); //대여 가능 기간

        String[] hhmm = ddMMhh[1].split(":");
        LocalTime time = LocalTime.of(Integer.parseInt(hhmm[0]), Integer.parseInt(hhmm[1])); //대여 가능 시간

        Map<String, Rental> map = new HashMap<>();
        String[] data;
        Map<String, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            data = br.readLine().split(" ");
            StringBuilder builder = new StringBuilder().append(data[0]).append("T").append(data[1]).append(":00");
            Rental rental = new Rental(builder.toString(), data[2], data[3], days, time);
            String key = new StringBuilder().append(data[2]).append("_").append(data[3]).toString();

            if (map.containsKey(key)){
                Rental findRental = map.get(key);
                if (rental.startDate.isAfter(findRental.endDate)){
                    long between = ChronoUnit.MINUTES.between(findRental.endDate, rental.startDate);
                    resultMap.put(findRental.lender, resultMap.getOrDefault(findRental.lender, 0) + (int) between * penalty);
                }
                map.remove(key);
            }else {
                map.put(key, rental);
            }
        }
        if (resultMap.size() == 0){
            System.out.println(-1);
        }else{
            List<Entry<String, Integer>> entries = new LinkedList<>(resultMap.entrySet());
            Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
            StringBuilder answer = new StringBuilder();
            for (Entry<String, Integer> entry : entries) {
                answer.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
            }
            System.out.println(answer.toString());
        }
    }*/