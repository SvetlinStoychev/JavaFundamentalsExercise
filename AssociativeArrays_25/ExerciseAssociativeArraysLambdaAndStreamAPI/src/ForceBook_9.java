import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ForceBook_9 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String command = reader.nextLine();

        LinkedHashMap<String, ArrayList<String>> forceBookMap = new LinkedHashMap<>();

        while (!command.equals("Lumpawaroo")) {

            ArrayList<String> currentUserList = new ArrayList<>();

            if (command.contains("|")) {

                String[] commandsArr = command.split(" \\| ");
                String forceSide = commandsArr[0];
                String forceUser = commandsArr[1];

                if ((!checkIfUserExistInMap(forceBookMap, forceUser)) && (!forceBookMap.containsKey(forceSide))) {

                    currentUserList.add(forceUser);
                    forceBookMap.put(forceSide, currentUserList);
                } else if ((!checkIfUserExistInMap(forceBookMap, forceUser)) && forceBookMap.containsKey(forceSide)) {

                    currentUserList = forceBookMap.get(forceSide);
                    currentUserList.add(forceUser);
                    forceBookMap.put(forceSide, currentUserList);
                }

            } else if (command.contains("->")) {

                String[] commandsArr = command.split(" -> ");
                String forceUser = commandsArr[0];
                String forceSide = commandsArr[1];

                if ((!checkIfUserExistInMap(forceBookMap, forceUser)) && (!forceBookMap.containsKey(forceSide))) {

                    currentUserList.add(forceUser);
                    forceBookMap.put(forceSide, currentUserList);

                    System.out.printf("%s joins the %s side!%n", forceUser, forceSide);

                } else if ((!checkIfUserExistInMap(forceBookMap, forceUser)) && forceBookMap.containsKey(forceSide)) {

                    currentUserList = forceBookMap.get(forceSide);
                    currentUserList.add(forceUser);
                    forceBookMap.put(forceSide, currentUserList);

                    System.out.printf("%s joins the %s side!%n", forceUser, forceSide);

                } else if (checkIfUserExistInMap(forceBookMap, forceUser) && forceBookMap.containsKey(forceSide)) {

                    if (!checkIfUserExistInList(forceBookMap.get(forceSide), forceUser)) {

                        removeUserFromMap(forceBookMap, forceUser);
                        currentUserList = forceBookMap.get(forceSide);
                        currentUserList.add(forceUser);
                        forceBookMap.put(forceSide, currentUserList);

                        System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
                    }
                }
            }

         command = reader.nextLine();
        }

        for (Map.Entry<String, ArrayList<String>> entry : forceBookMap.entrySet()) {

            if (entry.getValue().size() != 0) {

                System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());

                for (String user : entry.getValue()) {

                    System.out.printf("! %s%n", user);
                }
            }
        }

    }

    private static void removeUserFromMap(LinkedHashMap<String, ArrayList<String>> map, String user) {

        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {

            ArrayList<String> currentUsers = entry.getValue();

            currentUsers.remove(user);
        }
    }
    private static boolean checkIfUserExistInMap(LinkedHashMap<String, ArrayList<String>> map, String user) {

        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {

            ArrayList<String> currentUsers = entry.getValue();

            if (checkIfUserExistInList(currentUsers, user)) {

                return true;
            }
        }

        return false;
    }

    private static boolean checkIfUserExistInList(ArrayList<String> usersList, String user) {

        if (usersList.contains(user)) {
            return true;
        }

        return false;
    }
}
