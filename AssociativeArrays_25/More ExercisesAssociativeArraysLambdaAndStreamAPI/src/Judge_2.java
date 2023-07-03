import java.util.*;

public class Judge_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String command = reader.nextLine();

        LinkedHashMap<String, Integer> contestParticipantsMap = new LinkedHashMap<>();
        LinkedHashMap<String, TreeMap<String, Integer>> contestUserPointsMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> userTotalPointsMap = new LinkedHashMap<>();

        while (!command.equals("no more time")) {
            String inputUserName = command.split(" -> ")[0];
            String inputContest = command.split(" -> ")[1];
            int inputPoints = Integer.parseInt(command.split(" -> ")[2]);

            if (!contestUserPointsMap.containsKey(inputContest)) {
                TreeMap<String, Integer> currentUserPointsMap = new TreeMap<>();
                currentUserPointsMap.put(inputUserName, inputPoints);
                contestUserPointsMap.put(inputContest, currentUserPointsMap);

                contestParticipantsMap.put(inputContest, 1);
            } else {
                TreeMap<String, Integer> currentUserPointsMap = contestUserPointsMap.get(inputContest);

                if (currentUserPointsMap.containsKey(inputUserName)) {
                    int currentPoints = currentUserPointsMap.get(inputUserName);

                    if (inputPoints > currentPoints) {
                        currentUserPointsMap.put(inputUserName, inputPoints);
                        contestUserPointsMap.put(inputContest, currentUserPointsMap);
                    }
                } else {
                    currentUserPointsMap.put(inputUserName, inputPoints);
                    contestUserPointsMap.put(inputContest, currentUserPointsMap);

                    contestParticipantsMap.put(inputContest, contestParticipantsMap.get(inputContest) + 1);
                }
            }

            if (userTotalPointsMap.containsKey(inputUserName)) {
                int currentPoints = userTotalPointsMap.get(inputUserName);
                currentPoints += inputPoints;
                userTotalPointsMap.put(inputUserName, currentPoints);
            } else {
                userTotalPointsMap.put(inputUserName, inputPoints);
            }

            command = reader.nextLine();
        }

        for (Map.Entry<String, TreeMap<String, Integer>> entry : contestUserPointsMap.entrySet()) {
            System.out.printf("%s: %d participants%n", entry.getKey(), contestParticipantsMap.get(entry.getKey()));
            ArrayList<Integer> points = new ArrayList<>();

            for (Map.Entry<String, Integer> integerEntry : entry.getValue().entrySet()) {
                points.add(integerEntry.getValue());
            }

            Collections.sort(points);
            Collections.reverse(points);

            int cnt = 1;
            String lastPrinted = "";

            for (Integer point : points) {

                for (Map.Entry<String, Integer> integerEntry : entry.getValue().entrySet()) {

                    if (integerEntry.getValue() == point && (!integerEntry.getKey().equals(lastPrinted))) {

                        System.out.printf("%d. %s <::> %d%n", cnt, integerEntry.getKey(), integerEntry.getValue());
                        cnt++;
                        lastPrinted = integerEntry.getKey();
                    }
                }
            }
        }
    }
}
