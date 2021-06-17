package programmers.level2;

public class Num12911 {
    //다음 큰 숫자
    public static int getCount(int number){
        int cnt = 0;
        while (number >= 1){
            if (number % 2 == 1) cnt++;
            number /= 2;
        }
        return cnt;
    }
    public static int solution(int n) {
        int answer = n + 1;
        int nCnt = getCount(n);
        int nextCnt = 0;
        while (true){
            nextCnt = getCount(answer);
            if (nCnt == nextCnt) break;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(1000000));
    }
}
