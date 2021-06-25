package programmers.level2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Document implements Comparable<Document>{
    private int index;
    private int value;

    public Document(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Document o) {
        return Integer.compare(this.value, o.value);
    }
}
public class Num42587 {
    public int solution(int[] priorities, int location) {
        Queue<Document> printer = new LinkedList<>();
        PriorityQueue<Document> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            Document document = new Document(i, priorities[i]);
            printer.offer(document);
            pq.offer(document);
        }

        int cnt = 0;
        while (!printer.isEmpty()){
            Document document = printer.poll();
            if (document.getValue() == pq.peek().getValue()){
                pq.poll();
                cnt++;
                if (document.getIndex() == location) {
                    break;
                }
            }else {
                printer.offer(document);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}
