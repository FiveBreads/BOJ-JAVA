package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Num17686 {

    public String[] solution(String[] files) {
        ArrayList<ArrayList<Object>> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            ArrayList<Object> file = new ArrayList<>();
            //0: head, 1: number, 2: order, 3:filename
            int digitIndex = 0;
            for (int j = 0; j < files[i].length(); j++) {
                if (Character.isDigit(files[i].charAt(j))){
                    digitIndex = j;
                    break;
                }
            }
            file.add(files[i].substring(0, digitIndex));
            int len = digitIndex + 5 >= files[i].length() ? files[i].length() : digitIndex + 5;
            StringBuilder number = new StringBuilder();
            for (int j = digitIndex; j < len; j++) {
                if (Character.isDigit(files[i].charAt(j))){
                    number.append(files[i].charAt(j));
                }else{
                    break;
                }
            }
            file.add(Integer.parseInt(number.toString()));
            file.add(i);
            file.add(files[i]);

            list.add(file);
        }

        Collections.sort(list, new Comparator<ArrayList<Object>>() {
            @Override
            public int compare(ArrayList<Object> o1, ArrayList<Object> o2) {
                String str1 = (String) o1.get(0);
                String str2 = (String) o2.get(0);

                if (str1.equalsIgnoreCase(str2)){
                    if ((int) o1.get(1) == (int) o2.get(1)){
                        return Integer.compare((int) o1.get(2), (int)o2.get(2));
                    }
                    return Integer.compare((int) o1.get(1), (int)o2.get(1));
                }
                return str1.compareToIgnoreCase(str2);
            }
        });

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = (String) list.get(i).get(3);
        }
        return answer;
    }

    @Test
    void 파일명_정렬(){
        Assertions.assertArrayEquals(new String[]{"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"},
            solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"}));

        Assertions.assertArrayEquals(new String[]{"img000012345", "img1.png","img2","IMG02"},
            solution(new String[]{"img000012345", "img1.png","img2","IMG02"}));

    }
}