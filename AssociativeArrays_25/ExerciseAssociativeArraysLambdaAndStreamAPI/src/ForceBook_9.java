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
            String[] commandArr = command.split(" ");
            String inputForceSide = commandArr[0];
            String inputCommand = commandArr[1];
            String inputForceUser = commandArr[2];

            switch (inputCommand) {
                case "|":

                    if (!forceBookMap.containsKey(inputForceSide)) {

                        ArrayList<String> forceUsers = new ArrayList<>();
                        forceUsers.add(inputForceUser);
                        forceBookMap.put(inputForceSide, forceUsers);

                    } else {

                        if (!checkIfUserExistInMap(forceBookMap, inputForceUser)) {

                            ArrayList<String> usersList = forceBookMap.get(inputForceSide);
                            usersList.add(inputForceUser);
                            forceBookMap.put(inputForceSide, usersList);
                        }
                    }
                    break;
                case "->":

                    if (!forceBookMap.containsKey(inputForceSide)) {

                        ArrayList<String> userList = new ArrayList<>();
                        userList.add(inputForceUser);
                        forceBookMap.put(inputForceSide, userList);

                        System.out.printf("%s joins the %s side!%n", inputForceUser, inputForceSide);

                    } else {

                        if (checkIfUserExistInMap(forceBookMap, inputForceUser)) {

                            removeUserFromMap(forceBookMap, inputForceUser);
                            ArrayList<String> usersList = forceBookMap.get(inputForceSide);
                            usersList.add(inputForceUser);
                            forceBookMap.put(inputForceSide, usersList);

                        } else {

                            ArrayList<String> usersList = forceBookMap.get(inputForceSide);
                            usersList.add(inputForceUser);
                            forceBookMap.put(inputForceSide, usersList);
                        }
                    }
                    break;
                default:
                    System.out.println("W.T.F is " + inputCommand);
                    break;
            }

            command = reader.nextLine();
        }

        for (Map.Entry<String, ArrayList<String>> entry : forceBookMap.entrySet()) {

            System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());

            for (String user : entry.getValue()) {

                
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
