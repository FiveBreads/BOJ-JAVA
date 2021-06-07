package team_note;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortMethods implements Comparable<SortMethods>{

    private int number1;
    private double number2;

    public SortMethods(int number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public int getNumber1() {
        return number1;
    }

    public double getNumber2() {
        return number2;
    }

    @Override
    public int compareTo(SortMethods o) {
        if (o.getNumber1() == this.number1){
            //오름차순임
            return Double.compare(o.getNumber2(), this.number2);
        }
        return Integer.compare(o.getNumber1(), this.number1);
    }

    public static LinkedHashMap<String, Integer> sortMapByValue(Map<String, Integer> map){
        List<Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        LinkedHashMap<String, Integer> sortedList = new LinkedHashMap<>();
        for (Entry<String, Integer> entry : entries) {
            sortedList.put(entry.getKey(), entry.getValue());
        }
        return sortedList;
    }

    public static void swap(int[] arr, int a1, int a2){
        int tmp = arr[a1];
        arr[a1] = arr[a2];
        arr[a2] = tmp;
    }
}
