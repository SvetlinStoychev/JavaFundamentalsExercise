import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults_10 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String command = reader.nextLine();

        LinkedHashMap<String, Integer> pointsMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> submissionsCountMap = new LinkedHashMap<>();

        while (!command.equals("exam finished")) {

            String[] commandArr = command.split("-");
            String inputUserName = commandArr[0];
            String inputLanguage = commandArr[1];

            if (!inputLanguage.equals("banned")) {
                int inputPoints = Integer.parseInt(commandArr[2]);

                if (!pointsMap.containsKey(inputUserName)) {
                    pointsMap.put(inputUserName, inputPoints);
                } else {
                    if (inputPoints > pointsMap.get(inputUserName)) {
                        pointsMap.put(inputUserName, inputPoints);
                    }
                }

                if (!submissionsCountMap.containsKey(inputLanguage)) {
                    submissionsCountMap.put(inputLanguage, 1);
                } else {
                    submissionsCountMap.put(inputLanguage, submissionsCountMap.get(inputLanguage) + 1);
                }
            } else {
                pointsMap.remove(inputUserName);
            }

            command = reader.nextLine();
        }

        System.out.println("Results:");

        for (Map.Entry<String, Integer> entry : pointsMap.entrySet()) {
            System.out.printf("%s | %d%n", entry.getKey(), entry.getValue());
        }

        System.out.println("Submissions:");

        for (Map.Entry<String, Integer> entry : submissionsCountMap.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }
    }
}
