package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num17683{
    static Map<String, String> convertMap = new HashMap<>();

    public void initMap(){
        convertMap.put("C#", "c");
        convertMap.put("D#", "d");
        convertMap.put("F#", "f");
        convertMap.put("G#", "g");
        convertMap.put("A#", "a");
        convertMap.put("B#", "b");
        convertMap.put("E#", "e");
    }

    public String solution(String m, String[] musicinfos) {
        initMap();
        m = replaceScale(m);

        ArrayList<ArrayList<Object>> list = new ArrayList<>();

        int runtime;
        String sheet;
        for (int i = 0; i < musicinfos.length; i++) {
            //0: 시작시간, 1: 종료시간, 2: 제목, 3: 악보
            String[] info = musicinfos[i].split(",");
            runtime = calculateRuntime(info[0], info[1]);
            sheet = getRecursiveMusicSheet(runtime, replaceScale(info[3]));

            ArrayList<Object> infoList = new ArrayList<>();
            infoList.add(info[3]);
            infoList.add(runtime);
            infoList.add(i);
            infoList.add(info[2]);

            if (sheet.contains(m)){
                list.add(infoList);
            }
        }

        if (list.size() == 0){
            return "(None)";
        }else{
            Collections.sort(list, new Comparator<ArrayList<Object>>() {
                @Override
                public int compare(ArrayList<Object> o1, ArrayList<Object> o2) {
                    if ((int) o1.get(1) == (int) o2.get(1)) {
                        return Integer.compare((int) o1.get(2), (int) o2.get(2));
                    }
                    return (int) o2.get(1) - (int) o1.get(1);
                }
            });
            return (String) list.get(0).get(3);
        }
    }

    private String getRecursiveMusicSheet(int runtime, String s) {
        StringBuilder sb = new StringBuilder();
        int scaleIndex = 0;
        int musicLength = s.length();
        for(int j = 0 ; j < runtime ; ++j) {
            sb.append(s.charAt(scaleIndex));
            scaleIndex = (scaleIndex + 1) % musicLength;
        }
        return sb.toString();
    }

    private int calculateRuntime(String startTime, String endTime) {
        String[] startHHMM = startTime.split(":");
        String[] endHHMM = endTime.split(":");

        int sHH = Integer.parseInt(startHHMM[0]);
        int sMM = Integer.parseInt(startHHMM[1]);
        int eHH = Integer.parseInt(endHHMM[0]);
        int eMM = Integer.parseInt(endHHMM[1]);

        return (eHH - sHH) * 60 + (eMM - sMM);
    }

    public String replaceScale(String str){
        for (Entry<String, String> entry : convertMap.entrySet()) {
            str = str.replaceAll(entry.getKey(), entry.getValue());
        }
        return str;
    }
    @Test
    void 방금그곡(){
        Assertions.assertEquals("HELLO", solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        Assertions.assertEquals("FOO", solution("CC#BCC#BCC#BCC#B", new String[]{"03:30,04:00,FOO,CC#B", "04:52,05:00,BAR,CC#BCC#BCC#B"}));
        Assertions.assertEquals("WORLD", solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        Assertions.assertEquals("HAPPY", solution("A#", new String[]{"13:00,13:02,HAPPY,B#A#"}));
        Assertions.assertEquals("(None)", solution("CDEFGAC", new String[]{"12:00,12:06,HELLO,CDEFGA"}));
        Assertions.assertEquals("FOO", solution("CCB", new String[]{"03:00,03:10,FOO,CCB#CCB", "04:00,04:08,BAR,ABC"}));
        Assertions.assertEquals("FOO", solution("CCB", new String[]{"03:00,03:10,FOO,CCB#CCB", "04:00,04:10,BAR,CCB"}));
    }
}




















/*class Music implements Comparable<Music>{
    private int runtime;
    private String name;
    private int order;

    public Music(int runtime, String name, int order) {
        this.runtime = runtime;
        this.name = name;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Music o) {
        if (runtime == o.runtime){
            return runtime - o.runtime;
        }
        return Integer.compare(runtime, o.runtime);
    }
}
public class Num17683 {
    public String solution(String m, String[] musicinfos) {
        int run_time, sheet_len;
        StringBuilder builder;
        String answer = "(None)";
        PriorityQueue<Music> pq = new PriorityQueue<>(Comparator.reverseOrder());

        Map<String, String> convert = new HashMap<>();
        convert.put("C#", "c");
        convert.put("D#", "d");
        convert.put("F#", "f");
        convert.put("G#", "g");
        convert.put("A#", "a");
        convert.put("E#", "e");
        convert.put("B#", "b");

        //들은 멜로디 #치환처리
        for (String s : convert.keySet()) {
            m = m.replaceAll(s, convert.get(s));
        }

        for (int i = 0; i < musicinfos.length; i++) {
            builder = new StringBuilder();
            //방송된 곡정보 추출
            String[] info = musicinfos[i].split(",");

            //시작시간 추출
            String[] start = info[0].split(":");

            //종료시간 추출
            String[] end = info[1].split(":");

            //곡의 악보 #치환처리
            for (String s : convert.keySet()) {
                info[3] = info[3].replaceAll(s, convert.get(s));
            }

            sheet_len = info[3].length();
            run_time = getRunTime(start, end);

            if (run_time == sheet_len){ //악보의 길이와 연주 시간이 같고
                if (info[3].equals(m)){ //실제 악보와 들은 음악이 같으면 내가 들은 그곡이 맞음.
                    pq.offer(new Music(run_time, info[2], i));
                }
            }else { //악보의 길이보다 실제 연주시간이 크거나, 혹은 작을 경우
                int iter_cnt = run_time / sheet_len; //연주시간이 길면 1이상 반복횟수가 나올것이고 연주 시간이 작으면 0이 나와서 반복이 안된다.
                int remainder_cnt = run_time % sheet_len; //반복할 남은 부분 index 찾기
                for (int j = 0; j < iter_cnt; j++) { //반복횟수만큼 돌리기
                    builder.append(info[3]);
                }
                builder.append(info[3].substring(0, remainder_cnt)); //남은거 추가하기
                if (builder.toString().contains(m)) { //재생 시간동안 반복되어서 재생된 멜로디가 내가 들은 멜로디 맞는지 확인.
                    pq.offer(new Music(run_time, info[2], i));
                }
            }
        }
        if (pq.size() == 0){
            return answer;
        }else {
            return pq.poll().getName();
        }
    }

    private int getRunTime(String[] start, String[] end) {
        int start_h = Integer.parseInt(start[0]);
        int start_m = Integer.parseInt(start[1]);

        int end_h = Integer.parseInt(end[0]);
        int end_m = Integer.parseInt(end[1]);

        if (end_h == start_h){
            return end_m - start_m;
        }else{
            return ((end_h * 60) + end_m) - ((start_h * 60) + start_m);
        }
    }

    @Test
    void 방금그곡(){
        Assertions.assertEquals("HELLO", solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        Assertions.assertEquals("FOO", solution("CC#BCC#BCC#BCC#B", new String[]{"03:30,04:00,FOO,CC#B", "04:52,05:00,BAR,CC#BCC#BCC#B"}));
        Assertions.assertEquals("WORLD", solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }
}*/
