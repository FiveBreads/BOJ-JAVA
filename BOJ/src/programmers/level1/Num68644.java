package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num68644 {

    public int[] solution(int[] numbers) {
        int[] nums = new int[201];
        Arrays.fill(nums, 0);
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                nums[numbers[i] + numbers[j]]++;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                list.add(i);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
