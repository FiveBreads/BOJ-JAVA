package programmers.level2;

import java.math.BigInteger;

public class Num62048 {
//멀쩡한 사각형
    public long solution(int w, int h) {
        BigInteger bw = BigInteger.valueOf(w);
        BigInteger bh = BigInteger.valueOf(h);
        BigInteger gcd = bw.gcd(bh );

        return w * h - (w + h - gcd.longValue());
    }
    public static void main(String[] args) {

    }
}
