import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordSynonyms_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        LinkedHashMap<String, ArrayList<String>> resultMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String word = reader.nextLine();
            String synonym = reader.nextLine();

            if (!resultMap.containsKey(word)) {
                resultMap.put(word, new ArrayList<String>());
            }

            ArrayList<String> currentList = resultMap.get(word);
            currentList.add(synonym);
            resultMap.put(word, currentList);
        }

        for (Map.Entry<String, ArrayList<String>> entry : resultMap.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();

            System.out.printf("%s - %s%n", key, String.join(", ", value));
        }
    }
}
