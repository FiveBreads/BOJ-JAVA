package programmers.level2;

import java.util.PriorityQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FileName implements Comparable<FileName>{
    private String head;
    private String number;
    private String tail;
    private int order;

    public FileName(String head, String number, String tail, int order) {
        this.head = head;
        this.number = number;
        this.tail = tail;
        this.order = order;
    }

    private int indexOfBiggerThanZero(String body) {
        int i = 0;
        while (true){
            if (body.charAt(i) == '0'){
                i++;
            }else{
                break;
            }
        }
        return i;
    }

    public String getFullFileName(){
        StringBuilder builder = new StringBuilder();
        return builder.append(head).append(number).append(tail).toString();
    }

    @Override
    public int compareTo(FileName o) {
        if (head.toLowerCase().equals(o.head.toLowerCase())){
            int number1 = Integer.parseInt(number);
            int number2 = Integer.parseInt(o.number);
            if (number1 == number2){
                return Integer.compare(order, o.order);
            }
            return Integer.compare(number1, number2);
        }
        return head.toLowerCase().compareTo(o.head.toLowerCase());
    }
}
public class Num17686 {
    public String[] solution(String[] files) {
        PriorityQueue<FileName> pq = new PriorityQueue<>();
        for (int i = 0; i < files.length; i++) {
            int startNumber = 0;
            int endNumber = 0;
            for (int j = 0; j < files[i].length() - 1; j++) {
                if (files[i].charAt(j) == ' ') continue;
                if (Character.isDigit(files[i].charAt(j))){
                    startNumber = j;
                    endNumber = j + 1;
                    for (int k = j + 1; k < files[i].length(); k++) {
                        if (Character.isDigit(files[i].charAt(k))){
                            endNumber++;
                        }else {
                            break;
                        }
                    }
                    break;
                }
            }
            if (endNumber - startNumber > 5){
                endNumber = startNumber + 5;
            }
            pq.offer(new FileName(files[i].substring(0, startNumber), files[i].substring(startNumber, endNumber), files[i].substring(endNumber), i));
        }

        String[] answer = new String[pq.size()];
        int i = 0;
        while (!pq.isEmpty()){
            answer[i] = pq.poll().getFullFileName();
            i++;
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
