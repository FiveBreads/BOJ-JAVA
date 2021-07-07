package programmers.level2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Music implements Comparable<Music>{
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
}
