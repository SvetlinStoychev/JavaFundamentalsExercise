import java.util.*;

public class Ranking_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String command = reader.nextLine();

        LinkedHashMap<String, String> contestPasswordMap = new LinkedHashMap<>();

        while (!command.equals("end of contests")) {
            String[] commandsArr = command.split(":");
            String inputContest = commandsArr[0];
            String inputPassword = commandsArr[1];

            contestPasswordMap.put(inputContest, inputPassword);

            command = reader.nextLine();
        }

        command = reader.nextLine();

        TreeMap<String, LinkedHashMap<String, Integer>> userContestPointsMap = new TreeMap<>();

        while (!command.equals("end of submissions")) {
            String[] commandArr = command.split("=>");
            // {contest}=>{password}=>{username}=>{points}
            String inputContest = commandArr[0];
            String inputPassword = commandArr[1];
            String inputUserName = commandArr[2];
            int inputPoints = Integer.parseInt(commandArr[3]);

            if (contestPasswordMap.containsKey(inputContest)) {

                if (contestPasswordMap.get(inputContest).equals(inputPassword)) {

                    if (!userContestPointsMap.containsKey(inputUserName)) {
                        LinkedHashMap<String, Integer> currentContestPoints = new LinkedHashMap<>();
                        currentContestPoints.put(inputContest, inputPoints);
                        userContestPointsMap.put(inputUserName, currentContestPoints);
                    } else {

                        if (userContestPointsMap.get(inputUserName).containsKey(inputContest)) {
                            int currentPoints = userContestPointsMap.get(inputUserName).get(inputContest);

                            if (inputPoints > currentPoints) {
                                userContestPointsMap.get(inputUserName).put(inputContest, inputPoints);
                            }
                        } else {
                            userContestPointsMap.get(inputUserName).put(inputContest, inputPoints);
                        }
                    }
                }
            }

            command = reader.nextLine();
        }

        String bestUser = "";
        int bestPoints = 0;

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : userContestPointsMap.entrySet()) {
            int points = 0;

            for (Map.Entry<String, Integer> integerEntry : entry.getValue().entrySet()) {

                points += integerEntry.getValue();
            }

            if (points > bestPoints) {
                bestPoints = points;
                bestUser = entry.getKey();
            }
        }

        System.out.printf("Best candidate is %s with total %d points.%n", bestUser, bestPoints);
        System.out.println("Ranking: ");

        ArrayList<Integer> pointsList = new ArrayList<>();

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : userContestPointsMap.entrySet()) {
            System.out.println(entry.getKey());

            for (Map.Entry<String, Integer> integerEntry : entry.getValue().entrySet()) {
                pointsList.add(integerEntry.getValue());
            }

            Collections.sort(pointsList);
            Collections.reverse(pointsList);
            String lastPrintedCourse = "";

            for (Integer point : pointsList) {

                for (Map.Entry<String, Integer> integerEntry : entry.getValue().entrySet()) {

                    if (point == integerEntry.getValue() && (!lastPrintedCourse.equals(integerEntry.getKey()))) {
                        lastPrintedCourse = integerEntry.getKey();
                        System.out.printf("#  %s -> %d %n", integerEntry.getKey(), integerEntry.getValue());
                    }
                }
            }
        }
     }
}
