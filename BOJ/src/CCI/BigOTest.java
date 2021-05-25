package CCI;

public class BigOTest {

    static void runtimeCheckFormat(){
        System.out.println("BigOTest.runtimeCheckFormat");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long start = System.nanoTime();


        long end = System.nanoTime();
        System.out.println("수행시간: " + (end - start) + " ns");
    }

    static void bigON(int[] array){
        System.out.println("BigOTest.bigON");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long start = System.nanoTime();
        for (int i : array) {
            if (i < min) min = i;
            if (i > max) max = i;
        }
        long end = System.nanoTime();
        System.out.println("수행시간: " + (end - start) + " ns");
    }

    static void bigO2N(int[] array){
        System.out.println("BigOTest.bigO2N");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long start = System.nanoTime();
        for (int i : array) {
            if (i < min) min = i;
        }
        for (int i : array) {
            if (i > max) max = i;
        }
        long end = System.nanoTime();
        System.out.println("수행시간: " + (end - start) + " ns");
    }

    public static void main(String[] args) {
        int[] arr = {1,6,3,6,8,0,7,4,6,4,2,4,6,9,0,6,4,6,8,9,0,5,4,5,6,4,3,5,6,7,3,5,6,4,6,5,3,10,10,223,23,425,234,1254,1234,1234,1235,2345,2345,341234,123362,345475,8673,23546745,45673};
        bigO2N(arr);
        bigON(arr);
    }
}
