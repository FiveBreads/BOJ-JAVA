package programmers.level1;

import java.util.LinkedList;

public class Num1845 {
//폰켓몬
    public static int solution(int[] nums) {
        int[] pon = new int[200001];
        int n = nums.length / 2;
        for (int i = 0; i < pon.length; i++) {
            pon[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            pon[nums[i]]++;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < pon.length; i++) {
            if (pon[i] > 0) list.add(i);
        }

        if (list.size() >= n){
            return n;
        }else {
            return list.size();
        }
    }

    public static void main(String[] args) {
        int[] data = {3,1,2,3};
        solution(data);
    }
}
