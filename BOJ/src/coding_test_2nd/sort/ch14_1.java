package coding_test_2nd.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Student implements Comparable<Student>{
    private String name;
    private int kor;
    private int eng;
    private int math;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student o) {
        if (this.kor == o.kor){
            if (this.eng == o.eng){
                if (this.math == o.math){
                    return this.name.compareTo(o.name);
                }else if(this.math > o.math){
                    return -1;
                }else {
                    return 1;
                }
            }
            return Integer.compare(this.eng, o.eng);
        }else if(this.kor > o.kor){
            return -1;
        }else {
            return 1;
        }
    }
}
public class ch14_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            list.add(new Student(name, kor, eng, math));
        }
        Collections.sort(list);
        for (Student student : list) {
            System.out.println(student.getName());
        }
    }
}
