package BOJ.baekjoon.workbook.part2;

import java.util.*;

/**
 * Created by prayzz12@gmail.com on 2021-08-06
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 * title : 가르침
 * content : -졸업-
 * link : [https://www.acmicpc.net/problem/1062]
 */
public class Num1062 {

    static int n, k, count;
    static boolean[] alpha;
    static List<String> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        if (k < 5) {
            System.out.println(0);
            return;
        }
        if (k == 26) {
            System.out.println(n);
            return;
        }

        count = 0;
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            list.add(str.substring(4, str.length() - 4));
        }
        alpha = new boolean[26];
        alpha['a' - 97] = true;
        alpha['c' - 97] = true;
        alpha['t' - 97] = true;
        alpha['i' - 97] = true;
        alpha['n' - 97] = true;

        dfs(1, 0);

        System.out.println(count);
    }

    static void dfs(int index, int cnt){
        if (cnt == k - 5){
            int tmp = 0;
            for (int i = 0; i < list.size(); i++) {
                boolean flag = true;
                for (int j = 0; j < list.get(i).length(); j++) {
                    if (!alpha[list.get(i).charAt(j) - 97]){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    tmp++;
                }
            }
            count = Math.max(count, tmp);
            return;
        }

        for (int i = index; i < 26; i++) {
            if (alpha[i]) continue;
            alpha[i] = true;
            dfs(i + 1, cnt + 1);
            alpha[i] = false;
        }
    }
}

//2회차 풀이
/*
static int n, k, max;
    static String[] words;
    static boolean[] alpha;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        if (k < 5) {
            System.out.println(0);
            return;
        }
        if (k == 26){
            System.out.println(n);
            return;
        }

        init();

        for (int i = 0; i < n; i++) {
            String word = sc.next();
            words[i] = word.substring(4, word.length() - 4);
        }

        dfs(0, 1);

        System.out.println(max);
    }

    static void dfs(int count, int index){
        if (count == (k - 5)){
            validation();
            return;
        }
        for (int i = index; i < 26; i++) {
            if (alpha[i]) continue;
            alpha[i] = true;
            dfs(count + 1, i + 1);
            alpha[i] = false;
        }
    }

    static void validation(){
        int cnt = 0;
        //현재 단어 중에서 사용 한 알파벳 안에 들어가 있는게 없으면 탈락
        for (int i = 0; i < n; i++) {
            boolean isMatch = true;
            for (int j = 0; j < words[i].length(); j++) {
                if (!alpha[words[i].charAt(j) - 97]) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) cnt++;
        }
        max = Math.max(max, cnt);
    }

    static void init() {
        words = new String[n];
        max = 0;
        alpha = new boolean[26];

        alpha['a' - 97] = true;
        alpha['c' - 97] = true;
        alpha['i' - 97] = true;
        alpha['n' - 97] = true;
        alpha['t' - 97] = true;
    }
* */

//1회차 풀이
/*
static int n, k, max;
    static List<String> words;
    static boolean[] useAlpha;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        if (k < 5){
            System.out.println(0);
            return;
        }

        if (k == 26) {
            System.out.println(n);
            return;
        }

        useAlpha = new boolean[26];
        words = new ArrayList<>();
        max = 0;

        for (int i = 0; i < n; i++) {
            String word = sc.next();
            words.add(word.substring(4, word.length() - 4));
        }

        useAlpha['a' - 97] = true;
        useAlpha['c' - 97] = true;
        useAlpha['i' - 97] = true;
        useAlpha['n' - 97] = true;
        useAlpha['t' - 97] = true;

        dfs(0, 0);

        System.out.println(max);
    }

    static void dfs(int count, int index) {
        if (count == k - 5){ //최소 5개를 제외하고 나머지 개수만큼 채웠을 때
            //검사
            int tmpCount = getCount();
            max = Math.max(max, tmpCount);
            return;
        }

        for (int i = index; i < 26; i++) {
            if (useAlpha[i]) continue;
            useAlpha[i] = true;
            dfs(count + 1, i + 1);
            useAlpha[i] = false;
        }
    }

    static int getCount(){
        int count = 0;
        for (int i = 0; i < words.size(); i++) {
            boolean isValid = true;
            for (int j = 0; j < words.get(i).length(); j++) {
                if (!useAlpha[words.get(i).charAt(j) - 97]){
                    isValid = false;
                    break;
                }
            }
            if (isValid) count++;
        }
        return count;
    }
**/