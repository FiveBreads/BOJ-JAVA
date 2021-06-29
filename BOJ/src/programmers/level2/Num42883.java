package programmers.level2;

public class Num42883 {
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int start = 0;
        for (int i = 0; i < number.length() - k; i++) {
            int max = 0;
            for (int j = start; j <= k + i; j++) {
                if (max < (number.charAt(j) - '0')){
                    max = number.charAt(j) - '0';
                    start = j + 1;
                }
            }
            answer.append(max);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        int k = 4;
        String str = "4177252841";
        System.out.println(solution(str, k));
    }
}
