import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        LinkedHashMap<String, Integer> resourceMap = new LinkedHashMap<>();

        while (true) {
            String key = reader.nextLine();

            if (key.equals("stop")) {
                break;
            }

            int value = Integer.parseInt(reader.nextLine());

            if (!resourceMap.containsKey(key)) {
                resourceMap.put(key, value);
            } else {
                int nextValue = resourceMap.get(key) + value;
                resourceMap.put(key, nextValue);
            }
        }

        for (Map.Entry<String, Integer> entry : resourceMap.entrySet()) {

            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
