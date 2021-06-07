package BOJ.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Student implements Comparable<Student> {
    private String name;
    private int kor;
    private int eng;
    private int math;

    public Student(String name, String kor, String eng, String math) {
        this.name = name;
        this.kor = Integer.parseInt(kor);
        this.eng = Integer.parseInt(eng);
        this.math = Integer.parseInt(math);
    }

    public String getName() {
        return name;
    }

    public int getKor() {
        return kor;
    }

    public int getEng() {
        return eng;
    }

    public int getMath() {
        return math;
    }

    @Override
    public int compareTo(Student o) {
        if (o.getKor() == this.getKor()){
            if (o.getEng() == this.getEng()){
                if (o.getMath() == this.getMath()){
                    return this.getName().compareTo(o.getName());
                }
                return o.getMath() - this.getMath();
            }
            return this.getEng() - o.getEng();
        }
        return o.getKor() - this.getKor();
    }
}

public class ch14_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            studentList.add(new Student(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()));
        }
        Collections.sort(studentList);
        for (int i = 0; i < n; i++) {
            System.out.println(studentList.get(i).getName());
        }
    }
}
