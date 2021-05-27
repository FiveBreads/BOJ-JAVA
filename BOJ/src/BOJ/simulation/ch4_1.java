package BOJ.simulation;

import java.util.Scanner;

public class ch4_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int x = str.charAt(0) - 'a' + 1;
        int y = str.charAt(1) - '0';

        int[] xMove = {2, 2, -2, -2, -1, 1, 1, -1};
        int[] yMove = {1, -1, -1, 1, -2, -2, 2, 2};

        int count = 0;
        for (int i = 0; i < xMove.length; i++) {
            int nx = x + xMove[i];
            int ny = y + yMove[i];
            if (nx < 1 || nx > 8 || ny < 1 || ny > 8) continue;
            count++;
        }
        System.out.println(count);
    }
}
