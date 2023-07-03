import java.util.*;

public class Judge_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String command = reader.nextLine();

        LinkedHashMap<String, Integer> contestParticipantsMap = new LinkedHashMap<>();
        LinkedHashMap<String, TreeMap<String, Integer>> contestUserPointsMap = new LinkedHashMap<>();
        TreeMap<String, Integer> userTotalPointsMap = new TreeMap<>();

        while (!command.equals("no more time")) {
            String inputUserName = command.split(" -> ")[0];
            String inputContest = command.split(" -> ")[1];
            int inputPoints = Integer.parseInt(command.split(" -> ")[2]);
            boolean isMorePointsThanBefore = false;
            int pointsDifference = 0;

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
                        isMorePointsThanBefore = true;
                        pointsDifference = inputPoints - currentPoints;
                    }
                } else {
                    currentUserPointsMap.put(inputUserName, inputPoints);
                    contestUserPointsMap.put(inputContest, currentUserPointsMap);

                    contestParticipantsMap.put(inputContest, contestParticipantsMap.get(inputContest) + 1);
                }
            }
            if (isMorePointsThanBefore) {
                int currentPoints = userTotalPointsMap.get(inputUserName);
                currentPoints += pointsDifference;
                userTotalPointsMap.put(inputUserName, currentPoints);
            } else if (userTotalPointsMap.containsKey(inputUserName)) {
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
            //entry.getValue().descendingKeySet();

            for (Map.Entry<String, Integer> integerEntry : entry.getValue().entrySet()) {
                points.add(integerEntry.getValue());
            }

            Collections.sort(points);
            Collections.reverse(points);

            int cnt = 1;
            List<String> printedList = new ArrayList<>();

            for (Integer point : points) {

                for (Map.Entry<String, Integer> integerEntry : entry.getValue().entrySet()) {

                    if (integerEntry.getValue().equals(point) && (!printedList.contains(integerEntry.getKey()))) {

                        System.out.printf("%d. %s <::> %d%n", cnt, integerEntry.getKey(), integerEntry.getValue());
                        cnt++;
                        printedList.add(integerEntry.getKey());
                        break;
                    }
                }
            }
        }

        System.out.println("Individual standings: ");

        ArrayList<Integer> userPointsList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : userTotalPointsMap.entrySet()) {
            userPointsList.add(entry.getValue());
        }

        Collections.sort(userPointsList);
        Collections.reverse(userPointsList);

        int cnt = 1;
        List<String> printedList = new ArrayList<>();

        for (Integer userPoint : userPointsList) {

            for (Map.Entry<String, Integer> entry : userTotalPointsMap.entrySet()) {

                if (entry.getValue().equals(userPoint) && (!printedList.contains(entry.getKey()))) {

                    System.out.printf("%d. %s -> %d%n", cnt, entry.getKey(), entry.getValue());
                    cnt++;
                    printedList.add(entry.getKey());
                    break;
                }
            }
        }
    }
}

