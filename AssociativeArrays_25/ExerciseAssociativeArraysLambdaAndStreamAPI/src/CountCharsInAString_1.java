import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String[] inputArr = reader.nextLine().split("");

        LinkedHashMap<String, Integer> charCntMap = new LinkedHashMap<>();

        for (String el : inputArr) {

            if (!charCntMap.containsKey(el) && !el.equals(" ")) {
                charCntMap.put(el, 0);
            }

            if (!el.equals(" ")) {
                int value = charCntMap.get(el) + 1;
                charCntMap.put(el, value);
            }

        }

        for (Map.Entry<String, Integer> entry : charCntMap.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            System.out.printf("%s -> %d%n", key, value);
        }
    }
}
