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

        TreeMap<String, ArrayList<String>> userContestMap = new TreeMap<>();
        TreeMap<String, ArrayList<Integer>> userPointsMap = new TreeMap<>();
        LinkedHashMap<String, Integer> userBestPointsMap = new LinkedHashMap<>();

        while (!command.equals("end of submissions")) {
            String[] commandsArr = command.split("=>");

            String inputContest = commandsArr[0];
            String inputPassword = commandsArr[1];
            String inputUserName = commandsArr[2];
            int inputPoints = Integer.parseInt(commandsArr[3]);

            if (contestPasswordMap.containsKey(inputContest)) {

                if (contestPasswordMap.get(inputContest).equals(inputPassword)) {

                    if (!userContestMap.containsKey(inputUserName)) {
                        ArrayList<String> currentContest = new ArrayList<>();
                        currentContest.add(inputContest);
                        userContestMap.put(inputUserName, currentContest);

                        ArrayList<Integer> currentPoints = new ArrayList<>();
                        currentPoints.add(inputPoints);
                        userPointsMap.put(inputUserName, currentPoints);

                        userBestPointsMap.put(inputUserName, inputPoints);
                    } else if (userContestMap.containsKey(inputUserName) && userContestMap.get(inputUserName).contains(inputContest)) {
                        int pointsPosition = userContestMap.get(inputUserName).indexOf(inputContest);
                        int currentPoints = userPointsMap.get(inputUserName).get(pointsPosition);

                        if (currentPoints < inputPoints) {
                            userPointsMap.get(inputUserName).set(pointsPosition, inputPoints);
                        }
                    } else if (userContestMap.containsKey(inputUserName) && (!userContestMap.get(inputUserName).contains(inputContest))) {
                        ArrayList<String> currentContest = userContestMap.get(inputUserName);
                        currentContest.add(inputContest);
                        userContestMap.put(inputUserName, currentContest);

                        ArrayList<Integer> currentPoints = userPointsMap.get(inputUserName);
                        currentPoints.add(inputPoints);
                        userPointsMap.put(inputUserName, currentPoints);

                        int currentBestPoints = userBestPointsMap.get(inputUserName);
                        currentBestPoints += inputPoints;
                        userBestPointsMap.put(inputUserName, currentBestPoints);
                    }
                }
            }

            command = reader.nextLine();
        }

        String bestUserName = "";
        int bestPoints = 0;

        for (Map.Entry<String, Integer> entry : userBestPointsMap.entrySet()) {
            String userName = entry.getKey();
            int points = entry.getValue();

            if (points > bestPoints) {
                bestUserName = userName;
                bestPoints = points;
            }
        }

        for (Map.Entry<String, ArrayList<Integer>> entry : userPointsMap.entrySet()) {
            String key = entry.getKey();
            ArrayList<Integer> value = entry.getValue();

            for (int i = 0; i < value.size() - 1; i++) {
                int biggestPoints = value.get(i);
                int bestIndex = -1;

                for (int j = i + 1; j < value.size(); j++) {

                    if (biggestPoints < value.get(j)) {
                        biggestPoints = value.get(j);
                        bestIndex = j;
                    }
                }

                if (bestIndex != -1) {
                    int temPoints = value.get(i);
                    value.set(i, value.get(bestIndex));
                    value.set(bestIndex, temPoints);

                    ArrayList<String> contestList = userContestMap.get(key);
                    String temContest = contestList.get(i);
                    contestList.set(i, contestList.get(bestIndex));
                    contestList.set(bestIndex, temContest);
                }
            }
        }

        System.out.printf("Best candidate is %s with total %d points.%n", bestUserName, bestPoints);

        System.out.println("Ranking: ");

        for (Map.Entry<String, ArrayList<String>> entry : userContestMap.entrySet()) {
            System.out.printf("%s%n", entry.getKey());

            ArrayList<String> contestList = entry.getValue();

            for (String contest : contestList) {
                int pointsPosition = contestList.indexOf(contest);

                System.out.printf("#  %s -> %d%n", contest, userPointsMap.get(entry.getKey()).get(pointsPosition));
            }
        }
    }
}
