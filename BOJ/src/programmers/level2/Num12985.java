package programmers.level2;

public class Num12985 {
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        while (true){
            if (a % 2 != 0) a++;
            if (b % 2 != 0) b++;
            if (Math.abs(a - b) <= 1) break;
            a /= 2;
            b /= 2;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 20));
    }
}
