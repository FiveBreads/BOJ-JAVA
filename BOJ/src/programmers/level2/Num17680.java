package programmers.level2;

import java.util.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Num17680 {
    public static final int CACHE_HIT = 1;
    public static final int CACHE_MISS = 5;

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;

        LinkedList<String> cache = new LinkedList<>();
        int answer = 0;

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (cache.remove(city)){
                answer += CACHE_HIT;
            }else {
                if (cache.size() == cacheSize){
                    cache.removeLast();
                }
                answer += CACHE_MISS;
            }
            cache.addFirst(city);
        }
        return answer;
    }

    @Test
    void 캐시(){
        Assertions.assertEquals(50, solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        Assertions.assertEquals(21, solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        Assertions.assertEquals(60, solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        Assertions.assertEquals(52, solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        Assertions.assertEquals(16, solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        Assertions.assertEquals(25, solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }

}
