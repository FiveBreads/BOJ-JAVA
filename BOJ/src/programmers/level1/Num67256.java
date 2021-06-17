package programmers.level1;

public class Num67256 {
//키패드 누르기
    public static String solution(int[] numbers, String hand) {
        int[][] keypad = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {98, 0, 98}
        };
        int leftX = 3;
        int leftY = 0;
        int rightX = 3;
        int rightY = 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 3; k++) {
                    if (keypad[j][k] == numbers[i]){
                        if (k == 0){
                            leftX = j;
                            leftY = k;
                            sb.append("L");
                        }else if (k == 2){
                            rightX = j;
                            rightY = k;
                            sb.append("R");
                        }else{
                            int leftTerm = Math.abs(leftX - j) + Math.abs(leftY - k);
                            int rightTerm = Math.abs(rightX - j) + Math.abs(rightY - k);
                            if (leftTerm == rightTerm){
                                if ("left".equals(hand)){
                                    leftX = j;
                                    leftY = k;
                                    sb.append("L");
                                }else{
                                    rightX = j;
                                    rightY = k;
                                    sb.append("R");
                                }
                            }else if (leftTerm < rightTerm){
                                leftX = j;
                                leftY = k;
                                sb.append("L");
                            }else {
                                rightX = j;
                                rightY = k;
                                sb.append("R");
                            }
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        System.out.println(solution(numbers, hand));
    }
}
