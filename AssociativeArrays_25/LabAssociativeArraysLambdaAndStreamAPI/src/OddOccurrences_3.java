import java.util.*;

public class OddOccurrences_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String[] inputArr = reader.nextLine().split(" ");

        LinkedHashMap<String, Integer> wordsCntMap = new LinkedHashMap<>();

        for (int i = 0; i < inputArr.length; i++) {
            String key = inputArr[i].toLowerCase();

            if (!wordsCntMap.containsKey(key)) {
                wordsCntMap.put(key, 0);
            }

            int value = wordsCntMap.get(key) + 1;
            wordsCntMap.put(key, value);
        }

        ArrayList<String> resultList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : wordsCntMap.entrySet()) {
            int value = entry.getValue();

            if (value % 2 != 0) {
                String key = entry.getKey();
                resultList.add(key);
            }
        }

        System.out.println(String.join(", ", resultList));
    }
}
