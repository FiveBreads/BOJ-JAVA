package codility;

import java.util.HashMap;

public class T1 {

    public static String solution(String S, String C) {
        String[] persons = S.split("; ");
        HashMap<String, Integer> countMap = new HashMap<>();
        StringBuilder result = new StringBuilder();
        String suffix = "@" + C.toLowerCase() + ".com; ";
        for (int i = 0; i < persons.length; i++){
            String[] names = persons[i].split(" ");
            String firstName = names[0].toLowerCase();
            String lastName = names.length > 2 ? names[2].toLowerCase() : names[1].toLowerCase();
            for (int j = 0; j < lastName.length(); j++) {
                if (lastName.charAt(j) == '-') lastName = lastName.replace("-", "");
            }

            if (lastName.length() > 8) lastName = lastName.substring(0, 8);

            String prefix = firstName + "." + lastName;
            int count = 1;
            if (countMap.containsKey(prefix)){
                count = countMap.get(prefix) + 1;
                result.append(prefix).append(count).append(suffix);
                countMap.put(prefix, count);
            }else {
                countMap.put(prefix, count);
                result.append(prefix).append(suffix);
            }
        }
        return result.substring(0, result.lastIndexOf(";")).toString();
    }

    public static void main(String[] args) {
        String S = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
        String C = "Example";
        System.out.println(solution(S, C));
    }
}
