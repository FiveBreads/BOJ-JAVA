package programmers.level2;

public class Num12980 {
    public int solution(int n) {
        int ans = 0;
        while(n != 0){
            if(n % 2 == 0){
                n /= 2;
            } else {
                n--;
                ans++;
            }
        }
        return ans;
    }
}
